package com.thoughtworks.movies.springboot;

import com.thoughtworks.movies.entity.Movie;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface MovieRepository extends CrudRepository<Movie, String> {
    @Query("INSERT INTO movies (id, rating, title, origin_title, genres, year, pub_dates, image, summary, durations, photo, album, cast) VALUE " +
            "(:id, :rating, :title, :origin_title, :genres, :year, :pub_dates, :image, :summary, :durations, :photo, :album, :cast)")
    @Modifying
    public void realSave(@Param("id") int id, @Param("title") String title,
                         @Param("origin_title")  String originTitle, @Param("rating") double rating,
                         @Param("genres") String genres,@Param("year") String year,
                         @Param("pub_dates")String pubDates,
                         @Param("image") String image, @Param("summary") String summary,
                         @Param("durations")String durations,@Param("photo")String photo,
                         @Param("album")String album, @Param("cast") String casts
                         );
}
