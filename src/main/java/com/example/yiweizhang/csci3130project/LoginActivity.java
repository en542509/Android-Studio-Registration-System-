package com.example.yiweizhang.csci3130project;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class LoginActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private EditText userEnterEmail, userEnterPassword;
    private Button studentClickSignIn;
    private Button professorClickSignIn;
    private Button signupButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();

        userEnterEmail = findViewById(R.id.userEnteredEmail);
        userEnterPassword = findViewById(R.id.userEnteredPassword);
        studentClickSignIn = findViewById(R.id.studentClickSignIn);
        professorClickSignIn=findViewById(R.id.professorClickSignIn);
        signupButton = findViewById(R.id.signup);

        professorClickSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                professorSignIn();
            }
        });
        studentClickSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                studentSignIn();
            }
        });
        signupButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                signupEvent();
            }
        });
    }

    private void professorSignIn(){ 
        final String userEmail = userEnterEmail.getText().toString();
        String userPassword = userEnterPassword.getText().toString();

        mAuth.signInWithEmailAndPassword(userEmail, userPassword)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(LoginActivity.this, "sign in success.",
                            Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(LoginActivity.this, AccountActivity.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(LoginActivity.this, "sign in failed.",
                                    Toast.LENGTH_SHORT).show();

                        }

                    }
                });
    }


    private void studentSignIn(){
        final String userEmail = userEnterEmail.getText().toString();
        String userPassword = userEnterPassword.getText().toString();

        mAuth.signInWithEmailAndPassword(userEmail, userPassword)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(LoginActivity.this, "sign in success.",
                                    Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(LoginActivity.this, StudentAccountActivity.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(LoginActivity.this, "sign in failed.",
                                    Toast.LENGTH_SHORT).show();
                        }

                    }
                });
    }

    private void signupEvent(){
        final String userEmail = userEnterEmail.getText().toString();
        String userPassword = userEnterPassword.getText().toString();

        mAuth.createUserWithEmailAndPassword(userEmail, userPassword)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(LoginActivity.this, "sign up success.",
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(LoginActivity.this, "sign up failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
