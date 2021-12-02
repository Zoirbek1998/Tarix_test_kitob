package com.example.tarix.QuizActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tarix.Class.DbQuery;
import com.example.tarix.Class.MyComplectListener;
import com.example.tarix.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class SplashActivity extends AppCompatActivity {
    TextView appText;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash2);

        appText = findViewById(R.id.examText);


        Animation anim = AnimationUtils.loadAnimation(this, R.anim.exam_anim_layout);
        appText.setAnimation(anim);

        auth=FirebaseAuth.getInstance();

        DbQuery.g_firstore = FirebaseFirestore.getInstance();

        new Thread() {
            @Override
            public void run() {
                try {
                    sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (auth.getCurrentUser() != null) {
                    DbQuery.loadData(new MyComplectListener() {
                        @Override
                        public void onSuccess() {
                            startActivity(new Intent(SplashActivity.this, ExzamActivity.class));
                            finish();
                        }

                        @Override
                        public void onFailere() {
                            Toast.makeText(SplashActivity.this, "Hatolik yuz berdi iltimos keyinroq urinib ko'ring", Toast.LENGTH_SHORT).show();

                        }
                    });

                } else {
                    startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                    finish();
                }
            }
        }.start();

    }
}