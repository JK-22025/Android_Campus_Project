package com.example.final_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.auth.FirebaseAuth;

public class Forget_Password extends AppCompatActivity {
        Button SendlinkBtn;
        EditText email;
        FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_forget_password);

        SendlinkBtn = findViewById(R.id.SendLink);
        email = findViewById(R.id.edEmail);
        firebaseAuth = FirebaseAuth.getInstance();


//        SendlinkBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(Forget_Password.this, Login.class);
//                Toast.makeText(this, "Password sent to email", Toast.LENGTH_SHORT).show();
//                return;
//            }
//        });


    }
}