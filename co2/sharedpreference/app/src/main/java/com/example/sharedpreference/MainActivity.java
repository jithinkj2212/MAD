package com.example.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText nameEditText, passwordEditText, phoneEditText, emailEditText, dobEditText, addressEditText;
    private RadioGroup genderradioGroup;
    private Button submitButton;
       
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEditText = findViewById(R.id.name);
        phoneEditText = findViewById(R.id.phone);
        emailEditText = findViewById(R.id.email);
        dobEditText = findViewById(R.id.dob);
        addressEditText = findViewById(R.id.address);
        passwordEditText = findViewById(R.id.password);
        genderradioGroup = findViewById(R.id.radioGroup);
        submitButton = findViewById(R.id.button);

        submitButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String passvariable=passwordEditText.getText().toString();
                if (passvariable.equals("1234")) {
                    Toast.makeText(MainActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
    protected void onPause() {
        super.onPause();
        // Creating a shared pref object with a file name "MySharedPref" in private mode
        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        SharedPreferences.Editor myEdit = sharedPreferences.edit();

        // write all the data entered by the user in SharedPreference and apply
        myEdit.putString("name", nameEditText.getText().toString());
        myEdit.putString("phone", phoneEditText.getText().toString());
        myEdit.putString("email",emailEditText.getText().toString());
        myEdit.putInt("gender",genderradioGroup.getCheckedRadioButtonId());
        myEdit.putString("date",dobEditText.getText().toString());
        myEdit.putString("address",addressEditText.getText().toString());
        myEdit.putString("password",passwordEditText.getText().toString());


        myEdit.apply();
    }


    protected void onResume() {
        super.onResume();
        // Fetching the stored data from the SharedPreference
        // Setting the fetched data in the EditTexts
        SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        nameEditText.setText(sh.getString("name", ""));
        phoneEditText.setText(sh.getString("phone",""));
        emailEditText.setText(sh.getString("email",""));
        genderradioGroup.check(sh.getInt("gender",-1));
        dobEditText.setText(sh.getString("date",""));
        addressEditText.setText(sh.getString("address",""));
        passwordEditText.setText(sh.getString("password",""));
    }


}