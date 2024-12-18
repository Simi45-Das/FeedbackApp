package com.example.feedbackapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class NewEnRequest extends AppCompatActivity {

    EditText name,department,semester,rollNumber,phoneNumber;
    Button submit;

    long maxid = 0;
    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_en_request);

        name = findViewById(R.id.editTextName);
        department = findViewById(R.id.editTextDept);
        semester = findViewById(R.id.editTextSem);
        rollNumber = findViewById(R.id.editTextRollNum);
        phoneNumber = findViewById(R.id.editTextPhone2);

        submit = findViewById(R.id.button4);

        DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
        reference = rootRef.child("NewRequestFormStudent");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    maxid = (snapshot.getChildrenCount());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        submit.setOnClickListener(v -> {

            String Name = name.getText().toString();
            String RollNumber = rollNumber.getText().toString();
            String Dept = department.getText().toString();
            String Sem = semester.getText().toString();
            String PhoneNumber = phoneNumber.getText().toString();


            EnReqstHelperClass helperClass = new EnReqstHelperClass( Name,Dept,Sem,RollNumber,PhoneNumber);
            reference.child(String.valueOf(maxid+1)).setValue(helperClass);

            Toast.makeText(NewEnRequest.this, "we will notify you", Toast.LENGTH_SHORT).show();
            name.setText("");
            department.setText("");
            rollNumber.setText("");
            phoneNumber.setText("");
            Intent i = new Intent(NewEnRequest.this, MainActivity.class);
            startActivity(i);

        });



    }
}