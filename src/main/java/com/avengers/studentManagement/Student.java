package com.avengers.studentManagement;

public class Student {
    private String name;
    private int age;
    private int rollNo;
    private String state;
    private String country;

    public Student(String name, int age, int rollNo, String state, String country) {
        this.name = name;
        this.age = age;
        this.rollNo = rollNo;
        this.state = state;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
