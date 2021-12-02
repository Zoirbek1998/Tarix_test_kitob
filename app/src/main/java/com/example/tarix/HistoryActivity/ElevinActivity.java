package com.example.tarix.HistoryActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.tarix.R;

public class ElevinActivity extends AppCompatActivity {
    ImageView BtnImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elevin);
        BtnImage = findViewById(R.id.btnImage);
        BtnImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ElevinActivity.super.onBackPressed();
            }
        });

    }

    public void book_jahon(View view) {
        startActivity(new Intent(ElevinActivity.this, ElevinJahonActivity.class));
    }

    public void book_uzb(View view) {
        startActivity(new Intent(ElevinActivity.this, ElevinUzbActivity.class));
    }
}