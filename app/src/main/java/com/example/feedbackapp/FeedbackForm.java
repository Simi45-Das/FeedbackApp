package com.example.feedbackapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class FeedbackForm extends AppCompatActivity {

//    private Spinner facultyID;
    private ImageView image;
    TextView  roll,roll_sub,subject;

    private final int MAX_QUESTION_COUNT = 11;

    TextView tv_question01;
    RadioGroup rg_question01;
    RadioButton bt1_q1, bt2_q1, bt3_q1;

    TextView tv_question02;
    RadioGroup rg_question02;
    RadioButton bt1_q2, bt2_q2, bt3_q2, bt4_q2, bt5_q2;

    TextView tv_question03;
    RadioGroup rg_question03;
    RadioButton bt1_q3, bt2_q3, bt3_q3;

    TextView tv_question04;
    RadioGroup rg_question04;
    RadioButton bt1_q4, bt2_q4, bt3_q4;

    TextView tv_question05;
    EditText ml_tv;

    TextView tv_question06;
    RadioGroup rg_question06;
    RadioButton bt1_q6, bt2_q6, bt3_q6;

    TextView tv_question07;
    RadioGroup rg_question07;
    RadioButton bt1_q7, bt2_q7, bt3_q7, bt4_q7, bt5_q7;

    TextView tv_question08;
    RadioGroup rg_question08;
    RadioButton bt1_q8, bt2_q8, bt3_q8, bt4_q8, bt5_q8;

    TextView tv_question09;
    RadioGroup rg_question09;
    RadioButton bt1_q9, bt2_q9, bt3_q9;

    TextView tv_question10;
    RadioGroup rg_question10;
    RadioButton bt1_q10, bt2_q10, bt3_q10;

    EditText ml_tv2;


    Button bt_formSubmit;


    HashMap<String, String> hashMap;
    long maxid = 0;
    DatabaseReference reference;
    SessionManager sessionManager;

    int count = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback_form);

       subject = findViewById(R.id.tvsubName);

        Intent i1 = getIntent();
        String su1 = i1.getStringExtra("sub1");
        subject.setText(su1);

//        Intent i2 = getIntent();
//        String s2 = i2.getStringExtra("sub2");
//        tv.setText(s2);
//
//        Intent i3 = getIntent();
//        String s3 = i3.getStringExtra("sub3");
//        tv.setText(s3);


        image = findViewById(R.id.imageView);
        image.setImageResource(R.drawable.logo);
//        subject= findViewById(R.id.textView);
        roll = findViewById(R.id.rolln);
        roll_sub = findViewById(R.id.rollid);


        sessionManager = new SessionManager(getApplicationContext());

//        String rolll =   sessionManager.getrollNo();
//        roll.setText(rolll);

//           sessionManager.getsem();

        DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
        reference = rootRef.child("FORM");
        DatabaseReference reference2 = rootRef.child("count");


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





        bt_formSubmit = findViewById(R.id.bt_submit);
        bt_formSubmit.setOnClickListener(v -> {
            submitApplication();


        });

        hashMap = new HashMap<>();



        String rolll =   sessionManager.getrollNo();
        roll.setText(rolll);


        // repeat
        rg_question01 = findViewById(R.id.RadioGroup1);
        tv_question01 = findViewById(R.id.textView_q1);
        bt1_q1 = findViewById(R.id.bt1_q1);
        bt2_q1 = findViewById(R.id.bt2_q1);
        bt3_q1 = findViewById(R.id.bt3_q1);

        tv_question02 = findViewById(R.id.textView_q2);
        rg_question02 = findViewById(R.id.RadioGroup2);
        bt1_q2 = findViewById(R.id.bt1_q2);
        bt2_q2 = findViewById(R.id.bt2_q2);
        bt3_q2 = findViewById(R.id.bt3_q2);
        bt4_q2 = findViewById(R.id.bt4_q2);
        bt5_q2 = findViewById(R.id.bt4_q2);

        tv_question03 = findViewById(R.id.textView_q3);
        rg_question03 = findViewById(R.id.RadioGroup3);
        bt1_q3 = findViewById(R.id.bt1_q3);
        bt2_q3 = findViewById(R.id.bt2_q3);
        bt3_q3 = findViewById(R.id.bt3_q3);


        tv_question04 = findViewById(R.id.textView_q4);
        rg_question04 = findViewById(R.id.RadioGroup4);
        bt1_q4 = findViewById(R.id.bt1_q4);
        bt2_q4 = findViewById(R.id.bt2_q4);
        bt3_q4 = findViewById(R.id.bt3_q4);

        tv_question05 = findViewById(R.id.textView_q5);
        ml_tv = findViewById(R.id.editTextTextMultiLine);

        tv_question06 = findViewById(R.id.textView_q6);
        rg_question06 = findViewById(R.id.RadioGroup6);
        bt1_q6 = findViewById(R.id.bt1_q6);
        bt2_q6 = findViewById(R.id.bt2_q6);
        bt3_q6 = findViewById(R.id.bt3_q6);

        tv_question07 = findViewById(R.id.textView_q7);
        rg_question07 = findViewById(R.id.RadioGroup7);
        bt1_q7 = findViewById(R.id.bt1_q7);
        bt2_q7 = findViewById(R.id.bt3_q7);
        bt3_q7 = findViewById(R.id.bt3_q7);
        bt4_q7 = findViewById(R.id.bt4_q7);
        bt5_q7 = findViewById(R.id.bt5_q7);


        tv_question08 = findViewById(R.id.textView_q8);
        rg_question08 = findViewById(R.id.RadioGroup8);
        bt1_q8 = findViewById(R.id.bt1_q8);
        bt2_q8 = findViewById(R.id.bt2_q8);
        bt3_q8 = findViewById(R.id.bt3_q8);
        bt4_q8 = findViewById(R.id.bt4_q8);
        bt5_q8 = findViewById(R.id.bt5_q8);


        tv_question09 = findViewById(R.id.textView_q9);
        rg_question09 = findViewById(R.id.RadioGroup9);
        bt1_q9 = findViewById(R.id.bt1_q9);
        bt2_q9 = findViewById(R.id.bt2_q9);
        bt3_q9 = findViewById(R.id.bt3_q9);

        tv_question10 = findViewById(R.id.textView_q10);
        rg_question10 = findViewById(R.id.RadioGroup10);
        bt1_q10 = findViewById(R.id.bt1_q10);
        bt2_q10 = findViewById(R.id.bt2_q10);
        bt3_q10 = findViewById(R.id.bt3_q10);

        ml_tv2 = findViewById(R.id.editTextTextMultiLine2);


    }

    void save(RadioGroup radioGroup, TextView textView) {
        int id = radioGroup.getCheckedRadioButtonId();
        RadioButton radioButton = radioGroup.findViewById(id);
        if (radioButton != null && !radioButton.getText().toString().isEmpty()) {
            hashMap.put(textView.getText().toString(), radioButton.getText().toString());
        }
    }

    void validateForm() {
        save(rg_question01, tv_question01);
        save(rg_question02, tv_question02);
        save(rg_question03, tv_question03);
        save(rg_question04, tv_question04);
        save(rg_question06, tv_question06);
        save(rg_question07, tv_question07);
        save(rg_question08, tv_question08);
        save(rg_question09, tv_question09);
        save(rg_question10, tv_question10);

        if (ml_tv != null && !ml_tv.getText().toString().isEmpty()) {
            hashMap.put(tv_question05.getText().toString(), ml_tv.getText().toString());
        }

        if (ml_tv2 != null && !ml_tv2.getText().toString().isEmpty()) {
            hashMap.put("Optional Question", ml_tv2.getText().toString());
        }


    }

    void submitApplication() {
        validateForm();
        Log.d("TAG", "submitApplication: " + hashMap.size());
        if (hashMap.size() == MAX_QUESTION_COUNT) {
            for (String s : hashMap.keySet()) {
                Log.i("TAG", s + " : " + hashMap.get(s));

            }

            int radioId1 = rg_question01.getCheckedRadioButtonId();
            bt1_q1 = findViewById(radioId1);
            String rg_Question01 = bt1_q1.getText().toString();

            int radioId2 = rg_question02.getCheckedRadioButtonId();
            bt1_q2 = findViewById(radioId2);
            String rg_Question02 = bt1_q2.getText().toString();

            int radioId3 = rg_question03.getCheckedRadioButtonId();
            bt1_q3 = findViewById(radioId3);
            String rg_Question03 = bt1_q3.getText().toString();

            int radioId4 = rg_question04.getCheckedRadioButtonId();
            bt1_q4 = findViewById(radioId4);
            String rg_Question04 = bt1_q4.getText().toString();

            String mL_tv = ml_tv.getText().toString();

            int radioId6 = rg_question06.getCheckedRadioButtonId();
            bt1_q6 = findViewById(radioId6);
            String rg_Question06 = bt1_q6.getText().toString();

            int radioId7 = rg_question07.getCheckedRadioButtonId();
            bt1_q7 = findViewById(radioId7);
            String rg_Question07 = bt1_q7.getText().toString();

            int radioId8 = rg_question08.getCheckedRadioButtonId();
            bt1_q8 = findViewById(radioId8);
            String rg_Question08 = bt1_q8.getText().toString();

            int radioId9 = rg_question09.getCheckedRadioButtonId();
            bt1_q9 = findViewById(radioId9);
            String rg_Question09 = bt1_q9.getText().toString();

            int radioId10 = rg_question10.getCheckedRadioButtonId();
            bt1_q10 = findViewById(radioId10);
            String rg_Question10 = bt1_q10.getText().toString();


            String Ml_tv2 = ml_tv2.getText().toString();
//
//
            String Roll = roll.getText().toString();
//
            String Subject = subject.getText().toString();
//
//
            final String Roll_Sub = Roll + "_" + Subject;
            roll_sub.setText(Roll_Sub);



                FormHelperClass helperClass = new FormHelperClass(rg_Question01, Subject, rg_Question02,
                        rg_Question03, rg_Question04, mL_tv, rg_Question06, rg_Question07,
                        rg_Question08, rg_Question09, rg_Question10, Ml_tv2, Roll, Roll_Sub);


                reference.child(Roll_Sub).setValue(helperClass);


                Intent i = new Intent(FeedbackForm.this, LastPage.class);
                startActivity(i);

                Toast.makeText(FeedbackForm.this, "submitted", Toast.LENGTH_SHORT).show();

        }else{

                Toast.makeText(FeedbackForm.this, "Fill up all the questions", Toast.LENGTH_SHORT).show();
            }


    }







//                FormHelperClass helperClass = new FormHelperClass(rg_Question01, Subject, rg_Question02,
//                        rg_Question03, rg_Question04, mL_tv, rg_Question06, rg_Question07,
//                        rg_Question08, rg_Question09, rg_Question10, Ml_tv2, Roll, Roll_Sub);
//
//
//                reference.child(Roll_Sub).setValue(helperClass);
//
//
//                Intent i = new Intent(FeedbackForm.this, LastPage.class);
//                startActivity(i);
//
//                Toast.makeText(FeedbackForm.this, "submitted", Toast.LENGTH_SHORT).show();
//
//
//
//        }else{
//
//                Toast.makeText(FeedbackForm.this, "Fill up all the questions", Toast.LENGTH_SHORT).show();
//            }
//
//
//
//
//    }



    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.activity_main_menu,menu);
        return true;
    }


    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.item1:
                Intent intent = new Intent(FeedbackForm.this, PrivacyStatement.class);
                startActivity(intent);
                return true;

            case R.id.item2:
                Intent i = new Intent(FeedbackForm.this, AboutUs.class);
                startActivity(i);
                return true;

            case R.id.item3:
                Intent intent1 = new Intent(FeedbackForm.this, Rules.class);
                startActivity(intent1);
                return true;

            case R.id.item4:
                Intent intent2 = new Intent(FeedbackForm.this, ProfileUpdate.class);
                startActivity(intent2);
                return true;

            case R.id.item5:
                Toast.makeText(this, "hii", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.item6:

                Intent intent3 = new Intent(FeedbackForm.this, MyProfile.class);
                startActivity(intent3);
                return true;


            case R.id.item7:

                sessionManager = new SessionManager(getApplicationContext());
                sessionManager.LogOut();
                Toast.makeText(this, "LogOut", Toast.LENGTH_SHORT).show();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}