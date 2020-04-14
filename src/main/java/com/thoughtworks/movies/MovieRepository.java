package com.thoughtworks.movies;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface MovieRepository extends CrudRepository<Movie, String> {
    @Query("INSERT INTO movies (id, alt, year, title, rating, origin_title, directors, casts, genres, image) VALUE " +
            "(:id, :alt, :year, :title, :rating, :origin_title, :directors, :casts, :genres, :image)")
    @Modifying
    public void realSave(@Param("id") int id, @Param("alt") String alt, @Param("year") String year,
                         @Param("title") String title, @Param("rating") double rating,
                         @Param("origin_title")  String originTitle, @Param("directors") String directors,
                         @Param("casts") String casts, @Param("genres") String genres, @Param("image") String image);
}
