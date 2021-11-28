package com.ezgidogan.sqlitedatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {

            SQLiteDatabase database = this.openOrCreateDatabase("Musicians",MODE_PRIVATE,null);
            database.execSQL("CREATE TABLE IF NOT EXISTS musicians(id INTEGER PRIMARY KEY,name VARCHAR,age INTEGER)");

            //database.execSQL("INSERT INTO musicians(name,age) VALUES('Ezgi',20)");
           // database.execSQL("INSERT INTO musicians(name,age) VALUES('Can',22)");

            //database.execSQL("UPDATE musicians SET age = 21 WHERE name = 'Ezgi' " );

           // database.execSQL("DELETE FROM musicians WHERE id= 2");

           // Cursor cursor = database.rawQuery("SELECT * FROM musicians WHERE id= 2",null);
            Cursor cursor = database.rawQuery("SELECT * FROM musicians ",null);



            int nameIx = cursor.getColumnIndex("name");
            int ageIx = cursor.getColumnIndex("age");
            int idIx = cursor.getColumnIndex("id");

            while (cursor.moveToNext()) {
                System.out.println("name:"+ cursor.getString(nameIx));
                System.out.println("age:"+ cursor.getInt(ageIx));
                System.out.println("id:"+ cursor.getInt(idIx));

          }
            cursor.close();

        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}