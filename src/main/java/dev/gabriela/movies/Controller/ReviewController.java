package dev.gabriela.movies.Controller;

import dev.gabriela.movies.Entity.Review;
import dev.gabriela.movies.Service.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/reviews")
@AllArgsConstructor
@CrossOrigin
public class ReviewController {
    private final ReviewService reviewService;

    @PostMapping
    public ResponseEntity<Review> createReview (@RequestBody Map<String, String> payload) {
        return new ResponseEntity<Review>(reviewService.createReview(payload.get("reviewBody"), payload.get("imdbId"))
                , HttpStatus.CREATED);
    }
}
