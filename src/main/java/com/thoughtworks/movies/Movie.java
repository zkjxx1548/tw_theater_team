package com.thoughtworks.movies;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("movies")
public class Movie {
    @Id
    private int id;
    private double rating;
    private String title;
    @Column("origin_title")
    private String originalTitle;
    private String genres;
    private String year;
    @Column("pub_dates")
    private String pubDates;
    private String image;
    private String summary;
    private String durations;
    private String photo;
    private String album;
    private String cast;

    public Movie(int id, double rating, String title, String originalTitle, String genres, String year, String pubDates, String image, String summary, String durations, String photo, String album, String cast) {
        this.id = id;
        this.rating = rating;
        this.title = title;
        this.originalTitle = originalTitle;
        this.genres = genres;
        this.year = year;
        this.pubDates = pubDates;
        this.image = image;
        this.summary = summary;
        this.durations = durations;
        this.photo = photo;
        this.album = album;
        this.cast = cast;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getPubDates() {
        return pubDates;
    }

    public void setPubDates(String pubDates) {
        this.pubDates = pubDates;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDurations() {
        return durations;
    }

    public void setDurations(String durations) {
        this.durations = durations;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getCast() {
        return cast;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }
}
