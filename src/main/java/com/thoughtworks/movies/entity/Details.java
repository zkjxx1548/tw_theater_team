package com.thoughtworks.movies.entity;

import java.math.BigDecimal;

public class Details {
    private int id;
    private BigDecimal rating;
    private String title;
    private String originalTitle;
    private String[] genres;
    private String year;
    private String[] pubDates;
    private String image;
    private String summary;
    private String[] durations;
    private String[] photos;
    private String album;
    private String[] cast;
    private Movie[] recommended;

    public Details() {
    }

    public Details(int id, BigDecimal rating, String title, String originalTitle, String[] genres, String year, String[] pubDates, String image, String summary, String[] durations, String[] photos, String album, String[] cast, Movie[] recommended) {
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
        this.photos = photos;
        this.album = album;
        this.cast = cast;
        this.recommended = recommended;
    }

    public int getId() {
        return id;
    }

    public BigDecimal getRating() {
        return rating;
    }

    public String getTitle() {
        return title;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public String[] getGenres() {
        return genres;
    }

    public String getYear() {
        return year;
    }

    public String[] getPubDates() {
        return pubDates;
    }

    public String getImage() {
        return image;
    }

    public String getSummary() {
        return summary;
    }

    public String[] getDurations() {
        return durations;
    }

    public String[] getPhotos() {
        return photos;
    }

    public String getAlbum() {
        return album;
    }

    public String[] getCast() {
        return cast;
    }

    public Movie[] getRecommended() {
        return recommended;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRating(BigDecimal rating) {
        this.rating = rating;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public void setGenres(String[] genres) {
        this.genres = genres;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setPubDates(String[] pubDates) {
        this.pubDates = pubDates;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setDurations(String[] durations) {
        this.durations = durations;
    }

    public void setPhotos(String[] photos) {
        this.photos = photos;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public void setCast(String[] cast) {
        this.cast = cast;
    }

    public void setRecommended(Movie[] recommended) {
        this.recommended = recommended;
    }
}
