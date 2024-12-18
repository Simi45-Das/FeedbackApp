package com.example.feedbackapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MyProfile extends AppCompatActivity {

    TextView userName;
    TextView Email;
    TextView RollNum;
    TextView mobileNumber;

    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);

        userName = findViewById(R.id.tv_name);
        RollNum = findViewById(R.id.tv_rollno);
        Email = findViewById(R.id.tv_email);
        mobileNumber = findViewById(R.id.tv_mobile);

        sessionManager = new SessionManager(getApplicationContext());

        String pn =   sessionManager.getUName();
        userName.setText(pn);

        String roll =   sessionManager.getrollNo();
        RollNum.setText(roll);

        String email =   sessionManager.getEmail();
        Email.setText(email);

        String mobile =   sessionManager.getPhoneNumber();
        mobileNumber.setText(mobile);



    }
}