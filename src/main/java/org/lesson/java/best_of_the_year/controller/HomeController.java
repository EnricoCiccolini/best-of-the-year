package org.lesson.java.best_of_the_year.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import multimediaClass.Movie;
import multimediaClass.Song;

@Controller
@RequestMapping("/")

public class HomeController {
    Movie Matrix = new Movie("Matrix", "1", "Wachowsky");
    Song Sultan = new Song("Sultan of swing", "2", "Dire Straits");
    Movie TheLordOfTheRing = new Movie("The lord of the rings ", "3", "Jackson");
    Song RomeoAndJuliet = new Song("Romeo and juliet", "4", "Dire Straits");

    Movie[] movies = { Matrix, TheLordOfTheRing };
    Song[] songs = { Sultan, RomeoAndJuliet };

    // metodi
    private String getBestMovies(Movie[] movies) {
        String result = "";
        for (Movie movie : movies) {
            result = result + " ," + movie.getTitolo();
        }
        return result;
    }

    private String getBestSongs(Song[] songs) {
        String result = "";
        for (Song song : songs) {
            result = result + " ," + song.getTitolo();
        }
        return result;
    }

    @RequestMapping("/")
    public String Home(Model model) {
        model.addAttribute("name", "Enrico");

        return "home";
    }

    @RequestMapping("movies")
    public String Movie(Model model) {
        model.addAttribute("movies", getBestMovies(movies));

        return "movies";
    }

    @RequestMapping("songs")
    public String Song(Model model) {
        model.addAttribute("songs", getBestSongs(songs));

        return "songs";
    }

    @RequestMapping("movies/{id}")
    public String Movieid(Model model, @PathVariable("id") String mid) {

        for (Movie movie : movies) {

            if (mid.equals(movie.getid())) {
                model.addAttribute("movies", (movie));
            }

        }

        return "moviesid";
    }

    @RequestMapping("songs/{id}")
    public String Songsid(Model model, @PathVariable("id") String sid) {

        for (Song Song : songs) {

            if (sid.equals(Song.getid())) {
                model.addAttribute("songs", (Song));
            }

        }

        return "songsid";
    }

}
