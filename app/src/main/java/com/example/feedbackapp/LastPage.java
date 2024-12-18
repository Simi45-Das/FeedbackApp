package com.example.feedbackapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.security.acl.LastOwnerException;

public class LastPage extends AppCompatActivity {

    TextView next;
    SessionManager sessionManager;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last_page);
         next = findViewById(R.id.textView11);

         next.setOnClickListener(v -> {
             Intent intent = new Intent(LastPage.this,ChooseSub.class);
             startActivity(intent);
         });
    }

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.activity_main_menu,menu);
        return true;
    }


    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.item1:
                Intent intent = new Intent(LastPage.this, PrivacyStatement.class);
                startActivity(intent);
                return true;

            case R.id.item2:
                Intent i = new Intent(LastPage.this, AboutUs.class);
                startActivity(i);
                return true;

            case R.id.item3:
                Intent intent1 = new Intent(LastPage.this, Rules.class);
                startActivity(intent1);
                return true;

            case R.id.item4:
                Intent intent2 = new Intent(LastPage.this, ProfileUpdate.class);
                startActivity(intent2);
                return true;

            case R.id.item5:
                Toast.makeText(this, "hii", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.item6:

                Intent intent3 = new Intent(LastPage.this, MyProfile.class);
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