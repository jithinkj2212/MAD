package com.example.facebooklogin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    private TextView usernameTextview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        usernameTextview=findViewById(R.id.textview);

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            String username=extras.getString("username");
            usernameTextview.setText(username);
        }
    }
}