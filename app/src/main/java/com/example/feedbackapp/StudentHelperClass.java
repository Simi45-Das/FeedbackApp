package com.example.feedbackapp;


public class StudentHelperClass {

    String userName,EmailId,Password,rollNumber,Roll_pass,phone,sub1,sub2,sub3,dept;

    public StudentHelperClass(){

    }

    public StudentHelperClass(String Uname, String RollNumber,String Sub1,String Sub2,String Sub3,String emailId,
                              String password,String Dept,String Phone,
                              String roll_pass){
        userName = Uname;
        EmailId = emailId;
        Password = password;
        rollNumber = RollNumber;
        phone = Phone;
        dept = Dept;
        sub1 = Sub1;
        sub2 = Sub2;
        sub3 = Sub3;
        Roll_pass = roll_pass;
    }

    public String getUname() {
        return userName;
    }
    public void setUname(String Uname)
    {
        userName = Uname;
    }

    public String getRollNumber() {
        return rollNumber;
    }
    public void setRollNumber(String RollNumber) {
        rollNumber = RollNumber;
    }

    public String getSub1() {
        return sub1;
    }
    public void setSub1(String Sub1) {
        sub1 = Sub1;
    }

    public String getSub2() {
        return sub2;
    }
    public void setSub2(String Sub2) {
        sub2 = Sub2;
    }

    public String getSub3() {
        return sub3;
    }
    public void setSub3(String Sub3) {
        sub3 = Sub3;
    }

    public String getEmailId() {
        return EmailId;
    }

    public void setEmailId(String emailId) {
        EmailId = emailId;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getDept() {
        return dept;
    }
    public void setDept(String Dept)
    {
        dept = Dept;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String Phone) {
        phone = Phone;
    }


    public String getRoll_pass() {
        return Roll_pass;
    }
    public void setRoll_pass(String roll_pass)
    {
        Roll_pass = roll_pass;
    }


}
