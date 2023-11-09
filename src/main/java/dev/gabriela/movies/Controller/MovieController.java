package dev.gabriela.movies.Controller;

import dev.gabriela.movies.Entity.Movie;
import dev.gabriela.movies.Service.MovieService;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/movies")
@AllArgsConstructor
@CrossOrigin
public class MovieController {

    private final MovieService movieService;
    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies() {
        return new ResponseEntity<List<Movie>>(movieService.getAllMovies(), HttpStatus.OK);
    }

    @GetMapping("/{imdbId}")
    public ResponseEntity<Optional<Movie>> getMovie (@PathVariable String imdbId) {
        return new ResponseEntity<Optional<Movie>>(movieService.getMovie(imdbId), HttpStatus.OK);
    }
}
