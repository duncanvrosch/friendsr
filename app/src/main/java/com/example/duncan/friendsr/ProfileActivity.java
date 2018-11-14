package com.example.duncan.friendsr;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Intent intent = getIntent();
        final Friend retrievedFriend = (Friend) intent.getSerializableExtra("clicked_friend");

        TextView name = findViewById(R.id.naam);
        name.setText(retrievedFriend.getName());

        TextView bio = findViewById(R.id.biografie);
        bio.setText(retrievedFriend.getBio());

        ImageView photo = findViewById(R.id.avatar);
        photo.setImageResource(retrievedFriend.getDrawableId());

        RatingBar ratingbar = findViewById(R.id.ratingBar);

        SharedPreferences prefs = getSharedPreferences("settings", MODE_PRIVATE);
        float rating = prefs.getFloat("ratingBar"+retrievedFriend.getName(), 0);
        ratingbar.setRating(rating);

        ratingbar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                SharedPreferences prefs = getSharedPreferences("settings", MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putFloat("ratingBar"+retrievedFriend.getName(), rating);
                editor.apply();
                retrievedFriend.setRating(rating);
            }
        });

    }
}