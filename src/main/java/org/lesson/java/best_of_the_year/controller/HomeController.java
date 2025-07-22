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

    private Movie Matrix = new Movie("Matrix", "1", "Wachowsky");
    private Song Sultan = new Song("Sultan of swing", "2", "Dire Straits");
    private Movie TheLordOfTheRing = new Movie("The lord of the rings ", "3", "Jackson");
    private Song RomeoAndJuliet = new Song("Romeo and juliet", "4", "Dire Straits");

    private Movie[] movies = { Matrix, TheLordOfTheRing };
    private Song[] songs = { Sultan, RomeoAndJuliet };

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

        return "pages/home";
    }

    @RequestMapping("movies")
    public String Movie(Model model) {
        model.addAttribute("movies", getBestMovies(movies));
        model.addAttribute("media", movies);

        return "pages/movies";
    }

    @RequestMapping("songs")
    public String Song(Model model) {
        model.addAttribute("songs", getBestSongs(songs));
        model.addAttribute("media", songs);

        return "pages/songs";
    }

    @RequestMapping("movies/{id}")
    public String Movieid(Model model, @PathVariable("id") String movieId) {
        model.addAttribute("id", movieId);
        for (Movie movie : movies) {

            if (movieId.equals(movie.getId())) {
                model.addAttribute("movies", (movie));
                return "pages/single-film";
            }

        }

        return "pages/notFound";
    }

    @RequestMapping("songs/{id}")
    public String Songsid(Model model, @PathVariable("id") String songId) {
        model.addAttribute("id", songId);
        for (Song song : songs) {

            if (songId.equals(song.getId())) {
                model.addAttribute("songs", (song));
                return "pages/single-song";
            }

        }
        return "pages/not-found";
    }

}
