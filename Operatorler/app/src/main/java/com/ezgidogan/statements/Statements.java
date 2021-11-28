package com.ezgidogan.statements;

import java.sql.SQLOutput;

public class Statements {
    public static void main(String[] args) {
        int x = 5;
        x = x + 1;
        System.out.println(x);
        x++;
        System.out.println(x);
        x--;
        System.out.println(x);
        x = x * 5;
        System.out.println(x);

        int y = 4;
        System.out.println(x > y);
        System.out.println(y > x);

        y = 30;

        System.out.println(x >= y);
        System.out.println(x == y);
        System.out.println(x != y);

        // and &&
        // or ||

        int a = 3;
        int b = 4;
        int c = 5;
        System.out.println(a < b && b < c);
        System.out.println(b < a || b > c);

        // if statements
      /*
        if (a < b) {
            System.out.println("b is bigger");
        } else if (b < a) {
            System.out.println("a is bigger");
        } else {
            System.out.println("a=b");
        }
*/
        // Switch

        int day  = 1;
        String dayString= "";

        if(day==1){
            dayString= "Monday";
        }else if(day==2){
            dayString= "Tuesday";
        }else if(day==3){
            dayString= "Wednesday";
        }else if(day==4){
            dayString= "Thursday";
        }else if(day==5){
            dayString= "Friday";
        }else if(day==6){
            dayString= "Saturday";
        }else {
            dayString= "Mondey";
        }

        switch (day){
            case 1:
                dayString= "Mondey";
                break;
            case 2:
                dayString= "Tuesday";
                break;
            case 3:
                dayString= "Wednesday";
                break;
            case 4:
                dayString= "Thursday";
                break;
            case 5 :
                dayString= "Friday";
                break;
            case 6:
                dayString= "Saturday";
                break;
            default:
                dayString= "Sunday";
        }
        System.out.println(dayString);
    }
}



