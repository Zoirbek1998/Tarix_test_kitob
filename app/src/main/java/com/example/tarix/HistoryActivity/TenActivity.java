package com.example.tarix.HistoryActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tarix.R;

public class TenActivity extends AppCompatActivity {
    ImageView BtnImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ten);
        BtnImage = findViewById(R.id.btnImage);

        BtnImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TenActivity.super.onBackPressed();
            }
        });

    }

    public void reading_jahon(View view) {
        startActivity(new Intent(TenActivity.this, TenJahonActivity.class));
    }

    public void reading_uzb(View view) {
        startActivity(new Intent(TenActivity.this, TenUzbActivity.class));
    }
}