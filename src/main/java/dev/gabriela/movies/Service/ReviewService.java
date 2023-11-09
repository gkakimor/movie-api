package dev.gabriela.movies.Service;

import dev.gabriela.movies.Entity.Movie;
import dev.gabriela.movies.Entity.Review;
import dev.gabriela.movies.Repository.ReviewRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final MongoTemplate mongoTemplate;

    public Review createReview (String reviewBody, String imdbId) {
        Review review = reviewRepository.insert(new Review(reviewBody));

        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("reviewIds").value(review))
                .first();

        return review;
    }
}
