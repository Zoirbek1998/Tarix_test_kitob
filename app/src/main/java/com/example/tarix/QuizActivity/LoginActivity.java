package com.example.tarix.QuizActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.tarix.Class.DbQuery;
import com.example.tarix.Class.MyComplectListener;
import com.example.tarix.R;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

public class LoginActivity extends AppCompatActivity {
    TextView forgetyPas;
    MaterialButton LoginBtn, GoogleBtn;
    Button siginUp;
    EditText email, passvord;
    private GoogleSignInClient mGoogleSignInClient;
    private final static int RC_SIGN_IN = 123;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initVievs();

        creatRequest();
        mAuth = FirebaseAuth.getInstance();

        LoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validataBase()) {
                    login();
                }
            }
        });

        siginUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, LoginUpActivity.class));
            }
        });

        Button gog = findViewById(R.id.google);
        gog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();
            }
        });
    }


    private void initVievs() {
        forgetyPas = findViewById(R.id.forget_password);
        LoginBtn = findViewById(R.id.logo_btn);
        siginUp = findViewById(R.id.sigin_Up);
        email = findViewById(R.id.email);
        passvord = findViewById(R.id.password);
        GoogleBtn = findViewById(R.id.google);


    }

    private boolean validataBase() {
        boolean status = false;
        if (email.getText().toString().isEmpty()) {
            email.setError("Enter E-Mail Id");
            return false;
        }
        if (passvord.getText().toString().isEmpty()) {
            passvord.setError("Enter Passvord");
            return false;
        }
        return true;
    }

    private void login() {

        mAuth.signInWithEmailAndPassword(email.getText().toString().trim(), passvord.getText().toString().trim())
                .addOnCompleteListener(this, (task) -> {

                    if (task.isSuccessful()) {
                        Toast.makeText(this, "Login Success", Toast.LENGTH_SHORT).show();

                        DbQuery.loadData(new MyComplectListener() {
                            @Override
                            public void onSuccess() {
                                startActivity(new Intent(LoginActivity.this, ExzamActivity.class));
                                finish();

                            }

                            @Override
                            public void onFailere() {
                                Toast.makeText(LoginActivity.this, "Sorry auth", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                    else{
                        Toast.makeText(LoginActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void creatRequest() {
        // Configure Google Sign In
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        // Build a GoogleSignInClient with the options specified by gso.
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
    }

    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                // Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = task.getResult(ApiException.class);
                firebaseAuthWithGoogle(account);
            } catch (ApiException e) {
                // Google Sign In failed, update UI appropriately
                Toast.makeText(this, "" + e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void firebaseAuthWithGoogle(GoogleSignInAccount account) {

        AuthCredential credential = GoogleAuthProvider.getCredential(account.getIdToken(), null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser user = mAuth.getCurrentUser();
                            if (task.getResult().getAdditionalUserInfo().isNewUser()) {
                                DbQuery.creatUserData(user.getEmail(), user.getDisplayName(), new MyComplectListener() {
                                    @Override
                                    public void onSuccess() {

                                        DbQuery.loadData(new MyComplectListener() {
                                            @Override
                                            public void onSuccess() {
                                                startActivity(new Intent(getApplicationContext(), ExzamActivity.class));
                                                finish();
                                            }

                                            @Override
                                            public void onFailere() {
                                                Toast.makeText(LoginActivity.this, "Sorry auth", Toast.LENGTH_SHORT).show();
                                            }
                                        });

                                    }

                                    @Override
                                    public void onFailere() {
                                        Toast.makeText(LoginActivity.this, "Sorry auth", Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }
                            else {
                                DbQuery.loadData(new MyComplectListener() {
                                    @Override
                                    public void onSuccess() {
                                        startActivity(new Intent(getApplicationContext(), ExzamActivity.class));
                                        finish();
                                    }

                                    @Override
                                    public void onFailere() {
                                        Toast.makeText(LoginActivity.this, "Sorry auth", Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }

                        } else {
                            Toast.makeText(LoginActivity.this, "Sorry auth", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
    }


    @Override
    protected void onStart() {
        super.onStart();

        FirebaseUser user = mAuth.getCurrentUser();
        if (user != null) {
            startActivity(new Intent(getApplicationContext(), ExzamActivity.class));
        }
    }

}