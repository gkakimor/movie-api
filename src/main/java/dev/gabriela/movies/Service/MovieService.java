package dev.gabriela.movies.Service;

import dev.gabriela.movies.Entity.Movie;
import dev.gabriela.movies.Repository.MovieRepository;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;
    public List<Movie> getAllMovies(){
        return movieRepository.findAll();
    }

    public Optional<Movie> getMovie(String imdbId) {
        return movieRepository.findMovieByImdbId(imdbId);
    }
}
