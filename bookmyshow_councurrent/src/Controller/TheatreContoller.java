package Controller;

import Entities.Movies;
import Entities.Show;
import Entities.Theatre;
import Enums.City;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TheatreContoller {
    Map<City, List<Theatre>> cityTheatre;
    List<Theatre>theatreList;
    public TheatreContoller() {
        cityTheatre = new HashMap<>();
        theatreList = new ArrayList<>();
    }

    public void addTheatreInController(Theatre theatre, City city){
        theatreList.add(theatre);
        List<Theatre>cityVstheatre = cityTheatre.getOrDefault(city, new ArrayList<>());
        cityVstheatre.add(theatre);
        cityTheatre.put(city, cityVstheatre);
    }
    public Map<Theatre, List<Show>> getAllShow(Movies movie, City city) {

        //get all the theater of this city

        Map<Theatre, List<Show>> theatreVsShows = new HashMap<>();

        List<Theatre> theatres = cityTheatre.get(city);

        //filter the theatres which run this movie

        for(Theatre theatre : theatres) {

            List<Show> givenMovieShows = new ArrayList<>();
            List<Show> shows = theatre.getShow();

            for(Show show : shows) {
                if(show.getMovie().getId() == movie.getId()) {
                    givenMovieShows.add(show);
                }
            }
            if(!givenMovieShows.isEmpty()) {
                theatreVsShows.put(theatre, givenMovieShows);
            }
        }

        return theatreVsShows;
    }

}

