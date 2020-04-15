package com.thoughtworks.movies.springboot;

import com.thoughtworks.movies.entity.Details;
import com.thoughtworks.movies.entity.Movie;
import com.thoughtworks.movies.entity.Result;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@CrossOrigin(origins = "*")
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
    public Details getDetail(@RequestParam(name = "id")String id){
        return movieService.getMoviesById(id)[0];
    }

    @GetMapping("/search")
    public Result[] search(@RequestParam(name = "keyword")String keyword){
        return movieService.search(keyword);
    }

    @PostMapping("/save")
    public void save(@RequestParam Movie movies){
        System.out.println(movies);
    }

    @GetMapping("/initData")
    public void initData (){
        movieService.initData();
    }

    @PostMapping("/recommend")
    public Movie recommend(@RequestBody String title) {
        return movieService.recommendByTitle(title);
    }
}
