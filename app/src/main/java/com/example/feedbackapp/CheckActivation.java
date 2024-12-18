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

public class CheckActivation extends AppCompatActivity {

    TextView PhoneNumber;
    TextView Check;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_activation);

        PhoneNumber = findViewById(R.id.editTextPhone);
        Check = findViewById(R.id.check_data);

        DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
        reference = rootRef.child("VerificationData");

        Intent i = getIntent();
        String pn = i.getStringExtra("mobile");
        PhoneNumber.setText(pn);


        Check.setOnClickListener(v -> {
            //

            reference.orderByChild("phone").equalTo(pn).addValueEventListener(new ValueEventListener() {

                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {

                    if (snapshot.getValue() != null) {
                        for (DataSnapshot ds : snapshot.getChildren()) {

                            String r = ds.getValue(StudentHelperClass.class).getRollNumber();

                            String d = ds.getValue(StudentHelperClass.class).getDept();

                           String n = ds.getValue(StudentHelperClass.class).getUname();
                           String s1 = ds.getValue(StudentHelperClass.class).getSub1();
                           String s2 = ds.getValue(StudentHelperClass.class).getSub2();
                           String s3 = ds.getValue(StudentHelperClass.class).getSub3();

                            String p = ds.getValue(StudentHelperClass.class).getPhone();

                            Toast.makeText(CheckActivation.this, "matched" + ds, Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(CheckActivation.this, StudentRegistration.class);
                            i.putExtra("Roll", r);
                            i.putExtra("dept", d);
                            i.putExtra("name", n);
                            i.putExtra("sub1",s1);
                            i.putExtra("sub2",s2);
                            i.putExtra("sub3",s3);
                            i.putExtra("Phone",p);
                            startActivity(i);

                        }
                    } else {
                        Toast.makeText(CheckActivation.this,"This phone number is not activated",Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        });
    }

}