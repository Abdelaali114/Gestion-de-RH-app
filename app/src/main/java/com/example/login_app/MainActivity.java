package com.example.login_app;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity {
    Button login_button;
    EditText username_input ,password_input;
    dbHelper dbHelper;
    TextView creat;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHelper = new dbHelper(this);
        password_input=findViewById(R.id.password_input);
        username_input=findViewById(R.id.username_input);
        creat = findViewById(R.id.create);
        login_button= findViewById(R.id.login_button);
        creat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Sign_up.class);
                startActivity(intent);
            }
        });
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Home.class);
                startActivity(intent);

            }
        });

    }


}