package com.example.tarix.QuizActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.tarix.Class.DbQuery;
import com.example.tarix.Class.MyComplectListener;
import com.example.tarix.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginUpActivity extends AppCompatActivity {
    EditText name, email, pass, confirimpass;
    ImageView backBtnl;
    MaterialButton siginUpBtn;
    FirebaseAuth mAuth;
    String emailStr, passStr, confirmStr, nameStr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_up);

        name = findViewById(R.id.fish_edit);
        email = findViewById(R.id.email_edit);
        pass = findViewById(R.id.parol_edit);
        confirimpass = findViewById(R.id.tas_parol_edit);
        backBtnl = findViewById(R.id.backBtn);
        siginUpBtn = findViewById(R.id.sign_btn);

        mAuth = FirebaseAuth.getInstance();

        backBtnl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        siginUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (validate())
                    singUpNewUser();
            }
        });
    }

    private boolean validate() {
        nameStr = name.getText().toString().trim();
        passStr = pass.getText().toString().trim();
        emailStr = email.getText().toString().trim();
        confirmStr = confirimpass.getText().toString().trim();

        if (nameStr.isEmpty()) {
            name.setError("Ismingizni Kiriting");
            return false;
        }
        if (passStr.isEmpty()) {
            pass.setError("Parolni kiriting");
            return false;
        }
        if (emailStr.isEmpty()) {
            email.setError("E-Mailni kiriting");
            return false;
        }
        if (confirmStr.isEmpty()) {
            confirimpass.setError(" Tasdiqlash Parolni kiriting");
            return false;
        }
        if (passStr.compareTo(confirmStr) != 0) {
            Toast.makeText(this, "Parolni va Tasdiqlash parol bir xil bo'lishi kerak !", Toast.LENGTH_SHORT).show();
        }

        return true;
    }

    private void singUpNewUser() {

        mAuth.createUserWithEmailAndPassword(emailStr, passStr)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            Toast.makeText(LoginUpActivity.this, "Ro'yhatdan o'tish muvoffaqiyatli yakunlandi", Toast.LENGTH_SHORT).show();
                            DbQuery.creatUserData(emailStr,nameStr, new MyComplectListener() {
                                @Override
                                public void onSuccess() {

                                    DbQuery.loadData(new MyComplectListener() {
                                        @Override
                                        public void onSuccess() {
                                            startActivity(new Intent(LoginUpActivity.this, ExzamActivity.class));
                                            finish();
                                        }

                                        @Override
                                        public void onFailere() {
                                            Toast.makeText(LoginUpActivity.this, "Hatolik yuz berdi iltimos keyinroq urinib ko'ring", Toast.LENGTH_SHORT).show();

                                        }
                                    });

                                }

                                @Override
                                public void onFailere() {
                                    Toast.makeText(LoginUpActivity.this, "Hatolik yuz berdi iltimos keyinroq urinib ko'ring", Toast.LENGTH_SHORT).show();

                                }
                            });
                          
                        } else {
                            Toast.makeText(LoginUpActivity.this, "8 tadan oshiq kod kiriting",
                                    Toast.LENGTH_SHORT).show();
                        }

                    }
                });
    }


}