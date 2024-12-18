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

public class StudentLogin extends AppCompatActivity {

    EditText RollNumber;
    EditText Password;
    Button login;
    SessionManager sessionManager;
    //    DatabaseReference reference;
    FirebaseDatabase rootRef = FirebaseDatabase.getInstance();

    DatabaseReference reference = rootRef.getReference("stuDetails");



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login);

        RollNumber =  findViewById(R.id.editTextRollNumber);
        Password = findViewById(R.id.editTextTextPersonName2);
        login = findViewById(R.id.button3);
        sessionManager = new SessionManager(getApplicationContext());
        if(sessionManager.CheckedLogin()){
            finish();
        }

        login.setOnClickListener(v -> {

            if (RollNumber.getText().toString().length() > 0 && Password.getText().toString().length() > 0) {

                final String x = RollNumber.getText().toString();
                final String y = Password.getText().toString();
                final String userPass = x + "_" + y;

                reference.orderByChild("roll_pass").equalTo(userPass).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (snapshot.getValue() != null) {
                            for (DataSnapshot ds : snapshot.getChildren()) {

                                String token = ds.getKey();
                                String u = ds.getValue(StudentHelperClass.class).getUname();

                                String r = ds.getValue(StudentHelperClass.class).getRollNumber();
                                String p = ds.getValue(StudentHelperClass.class).getPassword();
                               String e = ds.getValue(StudentHelperClass.class).getEmailId();

                               String phn = ds.getValue(StudentHelperClass.class).getPhone();
                               String d = ds.getValue(StudentHelperClass.class).getDept();

                               String s1 = ds.getValue(StudentHelperClass.class).getSub1();
                               String s2 = ds.getValue(StudentHelperClass.class).getSub2();
                               String s3 = ds.getValue(StudentHelperClass.class).getSub3();



                                   sessionManager.CreatelogInId(token, u, r, d, p, e, phn, s1, s2, s3);
                                   sessionManager.writeLoginSession();
                                   Toast.makeText(StudentLogin.this, "login successful", Toast.LENGTH_SHORT).show();

                                   Intent intent = new Intent(StudentLogin.this, ChooseDept.class);
                                   startActivity(intent);
                            }

                        } else {
                            Toast.makeText(StudentLogin.this, "Invalid data", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }

        } );

    }

}
