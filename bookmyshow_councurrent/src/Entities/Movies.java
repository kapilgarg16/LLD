package Entities;

import Enums.Genres;
import Enums.Languages;

public class Movies {
    int id;
    String movieName;
    Genres genres;
    Languages language;
    int movieLength;

    public Movies(int id, String movieName, Genres genres, Languages language, int movieLength) {
        this.id = id;
        this.movieName = movieName;
        this.genres = genres;
        this.language = language;
        this.movieLength = movieLength;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public Genres getGenres() {
        return genres;
    }

    public void setGenres(Genres genres) {
        this.genres = genres;
    }

    public Languages getLanguage() {
        return language;
    }

    public void setLanguage(Languages language) {
        this.language = language;
    }

    public int getMovieLength() {
        return movieLength;
    }

    public void setMovieLength(int movieLength) {
        this.movieLength = movieLength;
    }
}
