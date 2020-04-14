package com.thoughtworks.movies;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class MovieService {
    final MovieRepository movieRepository;
    private final String FILE = Objects.requireNonNull(MovieDB.class.getClassLoader().getResource("movies.csv")).getFile();
    private ArrayList<Movie> movies = new ArrayList<>();

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
        initMovies();
    }

    public Movie[] search(String info) {
        if(getMoviesByTitle(info).length != 0) {
            return getMoviesByTitle(info);
        }
        if (getMoviesByOriginTitle(info).length != 0) {
            return getMoviesByOriginTitle(info);
        }
        if (getMoviesByDirector(info).length != 0) {
            return getMoviesByDirector(info);
        }
        if (getMoviesByCast(info).length != 0) {
            return getMoviesByCast(info);
        }
        if (getMoviesByGenres(info).length != 0) {
            return getMoviesByGenres(info);
        } else {
            return null;
        }
    }

    public Movie[] getMoviesByGenres(String genres) {
        return movies.stream()
                .filter(movie -> movie.getGenres().contains(genres))
                .toArray(Movie[]::new);
    }

    public Movie[] getMoviesByTitle(String title) {
        return movies.stream()
                .filter(movie -> movie.getTitle().equals(title))
                .toArray(Movie[]::new);
    }

    public Movie[] getMoviesByOriginTitle(String originTitle) {
        return movies.stream()
                .filter(movie -> movie.getOriginalTitle().equals(originTitle))
                .toArray(Movie[]::new);
    }

    public Movie[] getMoviesByCast(String cast) {
        return movies.stream()
                .filter(movie -> movie.getCasts().contains(cast))
                .toArray(Movie[]::new);
    }

    public Movie[] getMoviesByDirector(String director) {
        return movies.stream()
                .filter(movie -> movie.getDirectors().contains(director))
                .toArray(Movie[]::new);
    }


    private void initMovies() {
        movies.clear();
        for(Movie movie : movieRepository.findAll()) {
            movies.add(movie);
        }
    }

    public Movie recommendByTitle(String title) {
        Movie recommendMovie = movies.get(0);
        Movie currentMovie = getMoviesByTitle(title)[0];
        String[] currentMovieDirectors = currentMovie.getDirectors().split(",");
        String[] currentMovieGenres = currentMovie.getGenres().split(",");
        String[] currentMovieCasts = currentMovie.getCasts().split(",");
        int score = 0;
        for (Movie movie : movies){
            int tempScore = 0;
            if (movie.getTitle().equals(title)){
                continue;
            }
            tempScore += Arrays.stream(currentMovieCasts)
                    .mapToInt(cast -> movie.getCasts().contains(cast) ? 6 : 0)
                    .sum();
            tempScore += Arrays.stream(currentMovieDirectors)
                    .mapToInt(director -> movie.getDirectors().contains(director) ? 4 : 0)
                    .sum();
            tempScore += Arrays.stream(currentMovieGenres)
                    .mapToInt(genres -> movie.getGenres().contains(genres) ? 2 : 0)
                    .sum();
            tempScore -= Math.abs(movie.getRating() - currentMovie.getRating()) * 10;
            if (tempScore > score) {
                score = tempScore;
                recommendMovie = movie;
            }
        }
        return recommendMovie;
    }

    public void initData() {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE))){
            bufferedReader.readLine();
            while (bufferedReader.ready()){
                String data = bufferedReader.readLine();
                String[] split = data.trim().split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)", -1);
                List<String> collect = Arrays.stream(split).map(s -> s.replace("\"", "")).collect(Collectors.toList());
                movieRepository.realSave(Integer.parseInt(collect.get(0)), collect.get(1), collect.get(2), collect.get(3),
                        Double.parseDouble(collect.get(4)), collect.get(5), collect.get(6),
                        collect.get(7), collect.get(8), collect.get(9));
            }
            initMovies();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
