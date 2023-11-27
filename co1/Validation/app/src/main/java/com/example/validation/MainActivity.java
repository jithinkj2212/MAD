package com.example.validation;
import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private EditText nameEditText, passwordEditText, phoneEditText, emailEditText, dobEditText, addressEditText;
    private RadioGroup radioGroup;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find all the UI elements by their IDs
        nameEditText = findViewById(R.id.name);
        passwordEditText = findViewById(R.id.password);
        phoneEditText = findViewById(R.id.phone);
        emailEditText = findViewById(R.id.email);
        dobEditText = findViewById(R.id.dob);
        addressEditText = findViewById(R.id.address);
        radioGroup = findViewById(R.id.radioGroup);
        submitButton = findViewById(R.id.button);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the selected radio button
                int selectedRadioButtonId = radioGroup.getCheckedRadioButtonId();
                RadioButton selectedRadioButton = findViewById(selectedRadioButtonId);
                String selectedGender = selectedRadioButton.getText().toString();

                // Get the text from the EditText fields
                String name = nameEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();
                String phone = phoneEditText.getText().toString().trim();
                String email = emailEditText.getText().toString().trim();
                String dob = dobEditText.getText().toString().trim();
                String address = addressEditText.getText().toString().trim();

                // Perform validation
                if (TextUtils.isEmpty(name) || TextUtils.isEmpty(password) || TextUtils.isEmpty(phone) ||
                        TextUtils.isEmpty(email) || TextUtils.isEmpty(dob) || TextUtils.isEmpty(address) ||
                        selectedRadioButtonId == -1) {
                    // Display an error message if any field is empty or if no radio button is selected
                    Toast.makeText(MainActivity.this, "All fields are required", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Form Valid", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}