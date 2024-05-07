package com.example.login_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ajouteremplyeur extends AppCompatActivity {
    EditText name,email,age,gender,Post;
    Button regester;
    dbHelper mydb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajouteremplyeur);
        name = findViewById(R.id.name);
        email=findViewById(R.id.email);
        age=findViewById(R.id.age);
        gender=findViewById(R.id.Gender);
        Post=findViewById(R.id.Post);
        mydb = new dbHelper(this);
        regester = findViewById(R.id.ajouter);
        regester.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user =name.getText().toString();
                String mail =email.getText().toString();
                String l3mer =age.getText().toString();
                String naw3=gender.getText().toString();
                String post =Post.getText().toString();
                if(user.equals("")|| mail.equals("")|| l3mer.equals("")|| naw3.equals("") || post.equals("")){
                    Toast.makeText(ajouteremplyeur.this, "Fall all the fields ", Toast.LENGTH_SHORT).show();
                }
                else{
                    boolean  insertingemployers = mydb.insertemployeursdb(user,mail ,l3mer,naw3,post);
                    if (insertingemployers == true){
                        Toast.makeText(ajouteremplyeur.this, "regestred Successfully", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(ajouteremplyeur.this, "regestration failled", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });
    }
}