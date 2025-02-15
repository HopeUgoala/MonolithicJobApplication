package com.application.FirstJobApplication.reviews;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies/{companyId}")
public class ReviewController {

    private final ReviewService reviewService;


    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;

    }


    @GetMapping("/reviews")
    public ResponseEntity <List<Review>> getAllReview(@PathVariable Long companyId){
        return new ResponseEntity<>(reviewService.getAllReviews(companyId), HttpStatus.OK);
    }


    @PostMapping("/reviews")
    public ResponseEntity<String> addReview(@RequestBody Review review,
                                            @PathVariable Long companyId){
       boolean isReviewSaved = reviewService.addReview(review, companyId);
       if (isReviewSaved)
           return new ResponseEntity<>("Review was added successfully", HttpStatus.OK);
        else
           return new ResponseEntity<>("Review was not saved", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/reviews/{reviewId}")
    public ResponseEntity<Review> getReview(@PathVariable Long companyId,
                                            @PathVariable Long reviewId){
        return new ResponseEntity<>(reviewService.getReview(companyId, reviewId), HttpStatus.OK);
    }

    @PutMapping("/reviews/{reviewId}")
    public ResponseEntity<String> updateReview(@PathVariable Long companyId,
                                               @PathVariable Long reviewId,
                                               @RequestBody Review review){
        boolean isUpdated = reviewService.updateReview(companyId, reviewId, review);
        if (isUpdated)
            return new ResponseEntity<>("Review updated Successfully", HttpStatus.OK);
        else
            return new ResponseEntity<>("Review not updated",HttpStatus.NOT_FOUND);

    }

    @DeleteMapping("/reviews/{reviewId}")
    public ResponseEntity<String> deleteReview(@PathVariable Long companyId,
                                               @PathVariable Long reviewId){
        boolean isDeleted = reviewService.deletedReview(companyId, reviewId);
        if(isDeleted)
            return  new ResponseEntity<>("Review was deleted successfully", HttpStatus.OK);
        else
            return new ResponseEntity<>("Review was not deleted", HttpStatus.NOT_FOUND);

    }


}
