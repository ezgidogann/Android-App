package com.ezgidogan.falapplication;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.firebase.auth.FirebaseAuth;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {



    FirebaseAuth firebaseAuth;
    Bitmap galleryImage;
    ImageView imageView;
    Button button;
    CountDownTimer countDownTimer;






    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.option_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.signout ){
            firebaseAuth.signOut();

            Intent intentToSignOut = new Intent(MainActivity.this, SingUpActivity.class);
            startActivity(intentToSignOut);
            finish();
        }


        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseAuth = FirebaseAuth.getInstance();
        imageView = findViewById(R.id.imageView);
        button = findViewById(R.id.button3);




    }

    public void send(View view){
        Toast toast = new Toast(getApplicationContext());
        Toast.makeText(MainActivity.this,"Falınız 25sn içinde hazır olacak",Toast.LENGTH_LONG).show();

        countDownTimer=new CountDownTimer(25000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
               button.setText(String.valueOf(millisUntilFinished/1000));
            }

            @Override
            public void onFinish() {
                Intent send = new Intent(MainActivity.this,MainActivity2.class);
                startActivity(send);
            }
        }.start();



    }





    public void galleryImage(View view){
        //Galeri izni varmı yokmu kontrol edilir
        //Eğer izin verilmişse galeriye git
        if (ContextCompat.checkSelfPermission(this,Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[] {Manifest.permission.READ_EXTERNAL_STORAGE},1);
        }else{
            Intent intentToGallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(intentToGallery,2);
        }
    }

    //izin yoksa istenir
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if(requestCode == 1){
            if (grantResults.length > 0 && grantResults [0] == PackageManager.PERMISSION_GRANTED){
                Intent intentToGallery = new Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intentToGallery,2);
            }
        }

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    //başlatılan activitylerin sonucu
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 2 && resultCode == RESULT_OK && data != null) {
            Uri imageData = data.getData();
            try {
                if (Build.VERSION.SDK_INT >= 28) {
                    ImageDecoder.Source source = ImageDecoder.createSource(this.getContentResolver(), imageData);
                    galleryImage = ImageDecoder.decodeBitmap(source);
                    imageView.setImageBitmap(galleryImage);
                } else {
                    galleryImage = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageData);
                    imageView.setImageBitmap(galleryImage);
                }


            } catch (IOException e) {
                e.printStackTrace();
            }


        }



    }




}