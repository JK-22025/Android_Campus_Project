package com.example.final_project;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Signup extends AppCompatActivity {
    EditText emailEditText, passwordEditText, confirmPassEditText, FullnameEditText;
    ImageButton Backbtn, Sellbtn, Buybtn;
    Button BtnSignup, BtnLogin;

    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_signup);

        emailEditText = findViewById(R.id.emailSignup);
        passwordEditText = findViewById(R.id.PasswordSignup);
        confirmPassEditText = findViewById(R.id.confrimationPassword);
        FullnameEditText = findViewById(R.id.edFullnameSignup);
        Backbtn = findViewById(R.id.btnBack);
        Sellbtn = findViewById(R.id.btnSeller);
        Buybtn = findViewById(R.id.btnBuyer);

        BtnSignup = findViewById(R.id.btnCreateAccount);
        BtnLogin = findViewById(R.id.btnLogin);

        firebaseAuth = FirebaseAuth.getInstance();
        BtnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Signup.this, Login.class);
                startActivity(intent);
                finish();
            }
        });

        BtnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signupUser();
            }
        });



    }

    private void signupUser(){
        String email = emailEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();
        String confirmPassword = confirmPassEditText.getText().toString().trim();
        if(TextUtils.isEmpty(email) || TextUtils.isEmpty(password) || TextUtils.isEmpty(confirmPassword)){
            Toast.makeText(this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            emailEditText.setError("Not Valid Email");
            emailEditText.requestFocus();
            return;
        }

        if(password.length()<8){
            passwordEditText.setError("Password needs to be at least 7 char");
            passwordEditText.requestFocus();
            return;
        }
        if(!password.equals(confirmPassword)){
            confirmPassEditText.setError("Passwords doesn't match");
            confirmPassEditText.requestFocus();
            return;
        }

        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(Signup.this, "Sucess", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Signup.this, MainActivity.class));
                    finish();
                }else{
                    Toast.makeText(Signup.this, "Signup Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }





}