package com.example.tarix.HistoryActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.tarix.R;

public class FifthActivity extends AppCompatActivity {

    ImageView BtnImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth);
        BtnImage = findViewById(R.id.btnImage);

        BtnImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FifthActivity.super.onBackPressed();
            }
        });
    }

    public void reading_a_book(View view) {
        startActivity(new Intent(this, ReadingActivity.class));
    }
}