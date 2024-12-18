package com.example.feedbackapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

public class SessionManager {

    SharedPreferences preferences;
    SharedPreferences.Editor editor ;
    Context c;
    int Private_Mode = 0;
    private static final String Preference_Name = "FeedbackApp";
    private static final String isLogin = "isLogedIn";

    public SessionManager(Context c){
        this.c = c;
        preferences = c.getSharedPreferences(Preference_Name,Private_Mode);
        editor = preferences.edit();
    }

    public void writeLoginSession(){
        editor.putBoolean(isLogin,true);
        editor.commit();
    }

    public void CreatelogInId(String key,String UName,String rollNumber,String Dept,String password,String email,
                              String phoneNumber,String Subj1,String Subj2,String Subj3){

        editor.putString("token",key);
        editor.putString("name",UName);
        editor.putString("roll",rollNumber);
        editor.putString("dept",Dept);
        editor.putString("paaW",password);
       editor.putString("Email",email);
       editor.putString("PhoneNumber",phoneNumber);
       editor.putString("sub1",Subj1);
       editor.putString("sub2",Subj2);
       editor.putString("sub3",Subj3);
        editor.commit();

    }
    public  String getKey(){
        return preferences.getString("token",null);
    }

    public  String getUName(){
        return preferences.getString("name",null);
    }

    public  String getrollNo(){
        return preferences.getString("roll",null);
    }

    public  String getDept(){
        return preferences.getString("dept",null);
    }


    public  String getpassW(){
        return preferences.getString("paaW",null);
    }

    public  String getEmail(){
        return preferences.getString("Email",null);
    }

    public  String getPhoneNumber(){
        return preferences.getString("PhoneNumber",null);
    }

    public  String getSubj1(){
        return preferences.getString("sub1",null);
    }

    public  String getSubj2(){
        return preferences.getString("sub2",null);
    }

    public  String getSubj3(){
        return preferences.getString("sub3",null);
    }



    public boolean isLogedIn(){
        return preferences.getBoolean(isLogin,false);
    }

    public boolean CheckedLogin(){
        if(this.isLogedIn()){
            Intent i = new Intent(c,ChooseDept.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            c.startActivity(i);
            return true;
        }
        return false;
    }


    public void LogOut(){
        editor.clear();
        editor.commit();

        Intent i = new Intent(c,StudentLogin.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        c.startActivity(i);
    }
}


