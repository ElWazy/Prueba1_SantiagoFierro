package com.lutrias.prueba1_santiagofierro.context.shared.infrastructure;

import android.widget.RatingBar;

import com.lutrias.prueba1_santiagofierro.context.shared.domain.Rater;

public final class MyRatingBar implements Rater {

    private RatingBar ratingBar;

    public MyRatingBar(RatingBar ratingBar) {
        this.ratingBar = ratingBar;
    }

    @Override
    public void rate(int value) {
        ratingBar.setRating(value);
    }
}
