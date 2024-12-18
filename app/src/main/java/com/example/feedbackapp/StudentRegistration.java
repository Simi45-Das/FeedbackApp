package com.example.feedbackapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class StudentRegistration extends AppCompatActivity {

    TextView userName;
    EditText EmailId;
    EditText Password;
    TextView rollNumber, sub1, sub2, sub3;
    Button register;
    long maxid = 0;
    DatabaseReference reference;
    SessionManager sessionManager;
    TextView phone, dept;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_registration);

        userName = findViewById(R.id.tvPersonName);
        Intent iname = getIntent();
        String na = iname.getStringExtra("name");
        userName.setText(na);

        EmailId = findViewById(R.id.editTextTextEmailAddress);

        Password = findViewById(R.id.editTextTextPassword);

        sub1 = findViewById(R.id.tv_sub1);
        Intent i1 = getIntent();
        String s1 = i1.getStringExtra("sub1");
        sub1.setText(s1);

        sub2 = findViewById(R.id.tv_sub2);
        Intent i2 = getIntent();
        String s2 = i2.getStringExtra("sub2");
        sub2.setText(s2);

        sub3 = findViewById(R.id.tv_sub3);
        Intent i3 = getIntent();
        String s3 = i3.getStringExtra("sub3");
        sub3.setText(s3);

        rollNumber = findViewById(R.id.tv_roll);
        Intent innn = getIntent();
        String r = innn.getStringExtra("Roll");
        rollNumber.setText(r);

        register = findViewById(R.id.btn_next);

        phone = findViewById(R.id.tv_phone);
        Intent intent = getIntent();
        String p = intent.getStringExtra("Phone");
        phone.setText(p);


        dept = findViewById(R.id.tv_dept);
        Intent in = getIntent();
        String d = in.getStringExtra("dept");
        dept.setText(d);


        sessionManager = new SessionManager(getApplicationContext());
        if (sessionManager.CheckedLogin()) {
            finish();
        }

        DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
        reference = rootRef.child("stuDetails");

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

    }

    public void InsertRecord(View view) {
        if (!validateEmail() | !validatePassword()) {
            return;
        }


        String emailId = EmailId.getText().toString();
        String password = Password.getText().toString();

        String Uname = userName.getText().toString();
        String RollNumber = rollNumber.getText().toString();

        String Dept = dept.getText().toString();

        String Sub1 = sub1.getText().toString();
        String Sub2 = sub2.getText().toString();
        String Sub3 = sub3.getText().toString();

        String Phone = phone.getText().toString();

        final String Roll_pass = RollNumber + "_" + password;


        StudentHelperClass helperClass = new StudentHelperClass(Uname, RollNumber, Sub1, Sub2, Sub3, emailId, password, Dept, Phone, Roll_pass);
        reference.child(String.valueOf(maxid + 1)).setValue(helperClass);

        Toast.makeText(StudentRegistration.this, "Completed", Toast.LENGTH_SHORT).show();

        userName.setText("");
        dept.setText("");
        sub1.setText("");
        sub2.setText("");
        sub3.setText("");
        rollNumber.setText("");
        EmailId.setText("");
        Password.setText("");

        Intent i = new Intent(StudentRegistration.this, ChooseDept.class);
        startActivity(i);
    }




    private boolean validateEmail () {
        String emailInput = EmailId.getText().toString().trim();
        if (emailInput.isEmpty()) {
            EmailId.setError("Field can't be empty");
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
            EmailId.setError("please enter a valid email address");
            return false;
        } else {
            EmailId.setError(null);
            return true;
        }
    }

    private boolean validatePassword () {
        String passwordInput = Password.getText().toString().trim();
        if (passwordInput.isEmpty()) {
            Password.setError("Field can't be empty");
            return false;
        } else {
            Password.setError(null);
            return true;
        }
    }

}