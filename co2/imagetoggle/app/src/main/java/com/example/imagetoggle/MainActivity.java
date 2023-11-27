package com.example.imagetoggle;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView img11,img22;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img11 = findViewById(R.id.img1);
        img22 =findViewById(R.id.img2);
        img11.setOnClickListener(this::onClick);
        img22.setOnClickListener(this::onClick);

    }
    protected void onClick(View view){
        if (view.getId()==R.id.img2){
            img22.setVisibility(view.GONE);
            img11.setVisibility(view.VISIBLE);


        }else{
            img11.setVisibility(view.GONE);
            img22.setVisibility(view.VISIBLE);

        }

    }
}