package com.ezgidogan.methodsandclass;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    String userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        testMethod();
        System.out.println(math(3,5));
        System.out.println(newMethod("Ezgi"));

        userName = "Ezgi";
        makeSimpsons();
    }

    public void makeSimpsons(){
    Simpsons homer = new Simpsons("Homer",20 ,"developer");
    homer.age = 21;
    System.out.println();
    }



    public void  makeMusicians(){
        Musicians Ezgi = new Musicians("Ezgi","Guitar",20);

    }

 public void testMethod(){
        userName = "Can";
        int x =4+4;
     System.out.println("value of x:"+x);
 }

 public int math(int a, int b){
        userName = "Buse";
        return a+b;

 }
 public String newMethod(String string){
        userName = "Berkay";
        return string + " " +"new Method";
 }




    @Override
    protected  void onResume(){
        super.onResume();
    }

    @Override
    protected void onStop(){
        super.onStop();
    }

        protected void onPause(){
        super.onPause();
    }
}