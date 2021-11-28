package com.ezgidogan.landmarkbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listView);

        //Data
       final  ArrayList<String> landmarkNames = new ArrayList<>();
        landmarkNames.add("Pisa");
        landmarkNames.add("Eifel");
        landmarkNames.add("Colleseo");
        landmarkNames.add("London Bridge");

        final ArrayList<String> countryNames = new ArrayList<>();
        countryNames.add("Italy");
        countryNames.add("France");
        countryNames.add("Italy");
        countryNames.add("United Kindom");

        Bitmap pisa = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.pisa);
        Bitmap eifel = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.eifel);
        Bitmap colleseo = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.colleseo);
        Bitmap londonBridge = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.london);

       final ArrayList<Bitmap> landmarkImages = new ArrayList<>();
        landmarkImages.add(pisa);
        landmarkImages.add(eifel);
        landmarkImages.add(colleseo);
        landmarkImages.add(londonBridge);

        //ListView

        ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,landmarkNames);

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               // System.out.println(landmarkNames.get(i));
               // System.out.println(countryNames.get(i));

                Intent intent = new Intent(getApplicationContext(),DetailActivity.class);
                intent.putExtra("name",landmarkNames.get(i));
                intent.putExtra("country",countryNames.get(i));

               // singleton.getChosenImage(landmarkImages.get(i));
                Singleton singleton = Singleton.getInstance();
                singleton.setChosenImage(landmarkImages.get(i));


                startActivity(intent);
            }
        });
    }
}