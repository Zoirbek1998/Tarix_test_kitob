package com.example.tarix.HistoryActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.tarix.R;

public class SevenActivity extends AppCompatActivity {
ImageView btnImage;
ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seven);

        btnImage = findViewById(R.id.btnImage);


        btnImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SevenActivity.super.onBackPressed();
            }
        });



    }

    public void reading_a_book(View view) {
        startActivity(new Intent(SevenActivity.this, SevenUzbActivity.class));


    }

    public void reading_seven(View view) {
        startActivity(new Intent(SevenActivity.this, SevenJohonActivity.class));
    }
}