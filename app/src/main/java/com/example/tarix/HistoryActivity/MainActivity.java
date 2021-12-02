package com.example.tarix.HistoryActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tarix.QuizActivity.SplashActivity;
import com.example.tarix.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView imageView;
    ImageView btnimage2;
    ImageView btnimage3;
    ImageView btnimage4;
    ImageView btnimage5;
    ImageView btnimage6;
    ImageView btnimage7;

    LinearLayout layout;
    Boolean clik = false;
    MaterialButton btn,testBtn;
    ExtendedFloatingActionButton extendedFAB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        btnimage2 = findViewById(R.id.btnimage2);
        btnimage3 = findViewById(R.id.btnimage3);
        btnimage4 = findViewById(R.id.btnimage4);
        btnimage5 = findViewById(R.id.btnimage5);
        btnimage6 = findViewById(R.id.btnimage6);
        btnimage7 = findViewById(R.id.btnimage7);

        layout = findViewById(R.id.layout_bottom_sheet);
        btn = findViewById(R.id.btn_clik);
        testBtn = findViewById(R.id.test_id);

        extendedFAB = findViewById(R.id.extFab);
        extendedFAB.setOnClickListener(this);


        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, FifthActivity.class));
            }
        });

        btnimage2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SixActivity.class));
            }
        });

        btnimage3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SevenActivity.class));
            }
        });

        btnimage4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, EightActivity.class));
            }
        });

        btnimage5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, NeinActivity.class));
            }
        });

        btnimage6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, TenActivity.class));
            }
        });

        btnimage7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ElevinActivity.class));
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clik) {
                    layout.setVisibility(View.INVISIBLE);
                    clik = false;
                } else {
                    layout.setVisibility(View.VISIBLE);
                    clik = true;
                }
            }
        });

        testBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SplashActivity.class));
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.extFab:
                if (extendedFAB.isExtended()) {
                    extendedFAB.shrink();
                } else {
                    extendedFAB.extend();
                }
                break;
        }
    }
}