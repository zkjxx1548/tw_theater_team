package com.thoughtworks.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {
    final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/initData")
    public void initData (){
        movieService.initData();
    }

    @PostMapping("/getMoviesByGenres")
    public Movie[] getMoviesByGenres(@RequestBody String genres){
        return movieService.getMoviesByGenres(genres);
    }

    @PostMapping("/getMoviesByTitle")
    public Movie getMovieByTitle(@RequestBody String title){
        return movieService.getMoviesByTitle(title);
    }

    @PostMapping("/recommend")
    public Movie recommend(@RequestBody String title) {
        return movieService.recommendByTitle(title);
    }
}
