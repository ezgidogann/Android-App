package com.ezgidogan.oopproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       /* User myUser = new User();
        myUser.name = "Ezgi";
        myUser.job = "Devoloper";

        User newUser = new User();
        newUser.name = "Can";
        newUser.job = "Student";
      */

        User myUser = new User("Ezgi","Developer");
        System.out.println(myUser.name);

        //Encapsulation
        Musician james = new Musician("James","Guitar",50);
        System.out.println(james.getName());
        james.setAge(60,"Ezgi");
        System.out.println(james.getAge());

        //Inheritance
        SuperMusician lars = new SuperMusician("Lars","Drums",55);
        System.out.println(lars.sing());
        System.out.println(lars.getAge());

        //Static Polymorphism

        Mathematic mathematic = new Mathematic();
        System.out.println(mathematic.sum());
        System.out.println(mathematic.sum(5,3));
        System.out.println(mathematic.sum(5,3,4));

        Animal myAnimal = new Animal();
        myAnimal.sing();

        Dog barley = new Dog();
        barley.test();
        barley.sing();



    }
}