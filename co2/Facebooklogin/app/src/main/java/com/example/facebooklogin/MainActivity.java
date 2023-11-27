package com.example.facebooklogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText user,pass;
    Button Login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user=findViewById(R.id.username);
        pass=findViewById(R.id.password);
        Login = findViewById(R.id.login);

        Login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String uservariable=user.getText().toString();
                String passvariable=pass.getText().toString();
                if (passvariable.equals("1234")) {
                    opennext(uservariable);
                } else {
                    Toast.makeText(MainActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
    private void opennext(String username){
        Intent send=new Intent(MainActivity.this, MainActivity2.class);
        send.putExtra("username",username);
        startActivity(send);
    }
}