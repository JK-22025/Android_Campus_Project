package com.example.final_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    Button Btnlogin, Btnsignup;
    TextView email;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Btnsignup = findViewById(R.id.btnSignup);
        Btnlogin = findViewById(R.id.btnSignin);
        firebaseAuth = FirebaseAuth.getInstance();
        email = findViewById(R.id.showEmail);

        FirebaseUser currentUser = firebaseAuth.getCurrentUser();
        String emailUser = "";
        if(currentUser != null){
            emailUser = currentUser.getEmail();
            email.setText(emailUser);

        }

        Btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Signup.class));
                Toast.makeText(MainActivity.this, "Signup clicked", Toast.LENGTH_SHORT).show();
            }
        });

        Btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Login.class));
                Toast.makeText(MainActivity.this, "Signin clicked", Toast.LENGTH_SHORT).show();
            }
        });

    }
}