package com.example.login_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Sign_up extends AppCompatActivity {
    EditText editText1,editText2,editText3,editText4;
    Button button1;
    dbHelper mydb;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        // Initialize UI elements
        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        editText3 = findViewById(R.id.editText3);
        editText4 = findViewById(R.id.editText4);
        button1=findViewById(R.id.button1);
        mydb = new dbHelper(this);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user =editText1.getText().toString();
                String mail =editText2.getText().toString();
                String pass =editText3.getText().toString();
                String rpass =editText4.getText().toString();
                if(user.equals("")|| mail.equals("")|| pass.equals("")|| rpass.equals("")){
                    Toast.makeText(Sign_up.this, "Fall all the fields ", Toast.LENGTH_SHORT).show();
                }
                else{
                    if (pass.equals(rpass)){
                        boolean checkusername = mydb.checkusername(user);
                        if(checkusername==false){
                            boolean insertdb = mydb.insertusersdb(user,mail,pass,rpass);
                            if (insertdb==true) {
                                Toast.makeText(Sign_up.this, "Regestred successful", Toast.LENGTH_SHORT).show();
                            }
                            else{
                                Toast.makeText(Sign_up.this, "Regestration fieled", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(Sign_up.this, "incorrect user name! \n please Sign Up", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(Sign_up.this, "password not matching", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


    }
}