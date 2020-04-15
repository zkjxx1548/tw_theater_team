package com.thoughtworks.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.Arrays;

@RestController
public class MovieController {
    final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/movies")
    public Movie[] getBriefs(@RequestParam(name = "genre") String genre,
                             @RequestParam(name = "sorting") String sorting,
                             @RequestParam(name = "limit") int limit){
        return Arrays.copyOf(movieService.getMoviesByGenres(genre), limit);
    }

    @GetMapping("/details")
    public Movie getDetail(@RequestParam(name = "id")String id){
        return movieService.getMoviesById(id)[0];
    }

    @GetMapping("search")
    public Movie search(@RequestParam(name = "keyword")String info){
        return movieService.search(info)[0];
    }

    @PostMapping("/save")
    public void save(@RequestParam Movie movies){
        System.out.println(movies);
    }

    @GetMapping("/initData")
    public void initData (){
        movieService.initData();
    }

    @PostMapping("/getMoviesByGenres")
    public Movie[] getMoviesByGenres(@RequestBody String genres){
        return movieService.getMoviesByGenres(genres);
    }

    @PostMapping("/getMovieByTitle")
    public Movie[] getMovieByTitle(@RequestBody String title){
        return movieService.getMoviesByTitle(title);
    }

    @PostMapping("/getMovieById")
    public Movie[] getMovieById(@RequestBody String id){
        return movieService.getMoviesById(id);
    }

    @PostMapping("/searchMovies")
    public Movie[] searchMovie(@RequestBody String info){
        return movieService.search(info);
    }

    @PostMapping("/recommend")
    public Movie recommend(@RequestBody String title) {
        return movieService.recommendByTitle(title);
    }
}
