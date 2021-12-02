package com.example.tarix.HistoryActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.tarix.R;

public class NeinActivity extends AppCompatActivity {
    ImageView BtnImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nein);

        BtnImage=findViewById(R.id.btnImage);

        BtnImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NeinActivity.super.onBackPressed();
            }
        });

    }

    public void reading_Jahon9(View view) {
        startActivity(new Intent(NeinActivity.this, NeinJahonActivity.class));
    }

    public void reading_Uzb9(View view) {
        startActivity(new Intent(NeinActivity.this, NeinUzbActivity.class));
    }
}