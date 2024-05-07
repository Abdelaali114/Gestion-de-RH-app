package com.example.login_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class employers extends AppCompatActivity {
    ImageView logout,employeurs,add,delete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employers);
        logout = findViewById(R.id.logout);
        delete = findViewById(R.id.delete);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(employers.this,deleteemployeur.class);
                startActivity(intent);
            }
        });
        add = findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(employers.this,ajouteremplyeur.class);
                startActivity(intent);
            }
        });
        employeurs=findViewById(R.id.employeurs);
        employeurs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(employers.this,listemployeurs.class);
                startActivity(intent);
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(employers.this,SplashActivity.class);
                startActivity(intent);
            }
        });
    }
}