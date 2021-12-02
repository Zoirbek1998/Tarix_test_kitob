package com.example.tarix.HistoryActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tarix.R;

public class EightActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eight);
    }

    public void reading_eight8(View view) {
        startActivity(new Intent(EightActivity.this, EightReadingActivity.class));
    }

    public void reading_uzb8(View view) {
        startActivity(new Intent(EightActivity.this, EightUzbActivity.class));
    }
}