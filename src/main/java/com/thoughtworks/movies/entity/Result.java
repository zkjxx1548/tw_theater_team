package com.thoughtworks.movies.entity;

import java.math.BigDecimal;

public class Result {
    private int id;
    private BigDecimal rating;
    private String title;
    private String originalTitle;
    private String[] genres;
    private String year;
    private String image;
    private String summary;
    private String[] cast;

    public Result() {
    }

    public Result(int id, BigDecimal rating, String title, String originalTitle, String[] genres, String year, String image, String summary, String[] cast) {
        this.id = id;
        this.rating = rating;
        this.title = title;
        this.originalTitle = originalTitle;
        this.genres = genres;
        this.year = year;
        this.image = image;
        this.summary = summary;
        this.cast = cast;
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

    public String getImage() {
        return image;
    }

    public String getSummary() {
        return summary;
    }

    public String[] getCast() {
        return cast;
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

    public void setImage(String image) {
        this.image = image;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setCast(String[] cast) {
        this.cast = cast;
    }
}
