package com.example.feedbackapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ChooseSub extends AppCompatActivity {

    TextView sub1,sub2,sub3;
    Button sbtn1,sbtn2,sbtn3;
    SessionManager sessionManager;
    DatabaseReference reference,reference2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_sub);


        DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
        reference = rootRef.child("stuDetails");


        sessionManager = new SessionManager(getApplicationContext());


        sub1 = findViewById(R.id.tvsub1);
        String s1 =   sessionManager.getSubj1();
        sub1.setText(s1);

        sub2 = findViewById(R.id.tvsub2);
        String s2 =   sessionManager.getSubj2();
        sub2.setText(s2);

        sub3 = findViewById(R.id.tvsub3);
        String s3 =   sessionManager.getSubj3();
        sub3.setText(s3);

        sbtn1 = findViewById(R.id.button6);
        sbtn2 = findViewById(R.id.button7);
        sbtn3 = findViewById(R.id.button8);

        sbtn1.setOnClickListener(v -> {

//
            reference.orderByChild("sub1").equalTo(s1).addValueEventListener(new ValueEventListener() {

                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {

                    if (snapshot.getValue() != null) {
                        for (DataSnapshot ds : snapshot.getChildren()) {

                            String s1 = ds.getValue(StudentHelperClass.class).getSub1();


                            Intent i = new Intent(ChooseSub.this, FeedbackForm.class);

                            i.putExtra("sub1",s1);
                            startActivity(i);

                        }
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });

    });

        sbtn2.setOnClickListener(v -> {
            Intent i = new Intent(ChooseSub.this, FeedbackForm.class);
            i.putExtra("sub2",s2);
            startActivity(i);
        });

        sbtn3.setOnClickListener(v -> {
            Intent i = new Intent(ChooseSub.this, FeedbackForm.class);
            i.putExtra("sub3",s3);
            startActivity(i);
        });

    }
}