package com.example.feedbackapp;

public class EnReqstHelperClass {

    String name,department,semester,rollNumber,phoneNumber;

    public EnReqstHelperClass(){

    }

    public EnReqstHelperClass(String Name,String Dept,String Sem,String RollNumber,String Phone){
        name = Name;
        department = Dept;
        semester = Sem;
        rollNumber = RollNumber;
        phoneNumber = Phone;

    }

    public String getName() {
        return name;
    }
    public void setName(String Name)
    {
        name = Name;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String RollNumber) {
        rollNumber = RollNumber;
    }

    public String getDept() {
        return department;
    }
    public void setDept(String Dept)
    {
        department = Dept;
    }

    public String  getSem() {
        return semester;
    }

    public void setSem(String Sem) {
        semester = Sem;
    }

    public String getPhone() {
        return phoneNumber;
    }

    public void setPhone(String Phone) {
        phoneNumber = Phone;
    }

}
