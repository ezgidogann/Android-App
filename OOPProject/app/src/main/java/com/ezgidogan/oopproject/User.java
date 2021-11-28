package com.ezgidogan.oopproject;

public class User {

     //Property

    String name;
    String job;

    //Constructer

    public User(String nameInput, String jobInput) {
        this.name = nameInput;
        this.job = jobInput;

        System.out.println("User Created");
    }


}
