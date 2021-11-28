package com.ezgidogan.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Arrays {
    public static void main(String[] args){

        //Array

        String[] myStringArray= new String[3];

        myStringArray[0]= "Ezgi";
        myStringArray[1]= "Dogan";
        myStringArray[2]= "Can";

        System.out.println(myStringArray [0]);

        int[] myİntArray= new int[3];

        myİntArray[0]= 20;
        myİntArray[1]= 19;
        myİntArray[2]= 21;

        System.out.println(myİntArray[0]);

        int[] myNumberArray= {1,2,3,4,5,6,7};
        System.out.println(myNumberArray[3]);

        //List

        ArrayList<String> myMusicians= new ArrayList<String>();

        myMusicians.add("Ezgi");
        myMusicians.add("Dogan");
        myMusicians.add(1,"Can");
        myMusicians.add("Akgün");


        System.out.println(myMusicians.get(0));
        System.out.println(myMusicians.get(1));
        System.out.println(myMusicians.get(2));
        System.out.println(myMusicians.get(3));

        System.out.println(myMusicians.size());

        //Set


        HashSet<String> mySet = new HashSet<String>();

        mySet.add("Ezgi");
        mySet.add("Ezgi");

        System.out.println(mySet.size());

        //HashMap

        HashMap<String, String> myHashMap = new HashMap<String, String>();

        myHashMap.put("name","Ezgi");
        myHashMap.put("instrument","Guitar");

        System.out.println(myHashMap.get("name"));
        System.out.println(myHashMap.get("instrument"));

        HashMap<String, Integer> mySecondMap= new HashMap<String, Integer>();

        mySecondMap.put("run",100);
        mySecondMap.put("basketball",200);

        System.out.println(mySecondMap.get ("run") );

    }
}
