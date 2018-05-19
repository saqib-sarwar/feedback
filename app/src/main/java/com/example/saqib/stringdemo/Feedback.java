package com.example.saqib.stringdemo;

/**
 * Created by Saqib on 19-05-2018.
 */

public class Feedback {

    private Question question;
    private String review;
    private float rating;

    public float getRating() {
        return rating;
    }

    public String getReview() {
        return review;
    }

    public Question getQuestion() {
        return question;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
