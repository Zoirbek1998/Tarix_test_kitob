package com.example.tarix.HistoryActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.tarix.R;

public class SixActivity extends AppCompatActivity {
    ImageView BtnImage;
    ImageView SixImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_six);

        BtnImage = findViewById(R.id.btnImage);
        SixImage = findViewById(R.id.Siximage);

        BtnImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SixActivity.super.onBackPressed();
            }
        });

        SixImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SixActivity.this, SixReadingActivity.class));
            }
        });
    }
    }
