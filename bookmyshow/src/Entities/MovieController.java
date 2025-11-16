package Entities;

import Enums.City;

import java.util.*;

public class MovieController {
    //filter movies based on the city
    Map<City, List<Movies>> cityMovies;
    List<Movies>moviesList;

    public MovieController() {
        cityMovies = new HashMap<>();
        moviesList = new ArrayList<>();
    }

    public void addMovieInController(City city, Movies movie){
        moviesList.add(movie);
        List<Movies>cityVsmovie = cityMovies.getOrDefault(city, new ArrayList<>());
        cityVsmovie.add(movie);
        cityMovies.put(city, cityVsmovie);
    }

    public Movies getMovieByName(String movieName){
        boolean f = false;
        int i;
        for(i = 0 ; i < moviesList.size() ; i++){
            if(Objects.equals(moviesList.get(i).getMovieName(), movieName)){
                f = true;
                break;
            }
        }
        return  moviesList.get(i);
    }

    public  List<Movies> getMoviesByCity(City city)
    {
       return cityMovies.get(city);
    }
    public Map<City, List<Movies>> getCityMovies() {
        return cityMovies;
    }

    public void setCityMovies(Map<City, List<Movies>> cityMovies) {
        this.cityMovies = cityMovies;
    }

    public List<Movies> getAllMovies() {
        return moviesList;
    }

    public void setAllMovies(List<Movies> allMovies) {
        this.moviesList = allMovies;
    }
}
