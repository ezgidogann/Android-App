package com.ezgidogan.falapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Random;

public class MainActivity2 extends AppCompatActivity {
   TextView textView;


  public  String yanitlar [] = {
           "Küçük küçük çıtalar çıkmış. Sanki yapılacak uçurtmanın malzemeleri gibi duruyorlar. Güzel hayaerin var , uzaklarda veya yakınlarda  fark etmez, büyük başarılara ismin duyulsun istiyorsun.Ancak korkuların ve endişelerin galip geliyor ve kenara çekiliyorsun. ",
           "Birbirine sarılmış 8 rakamını meydana getiren yılanlar görüyorum telvelerinde.Yılan güç, zeka ve bilgeliği simgeliyor. Sekiz sayısı ise hem maddi başarılari gösteriyor hemde sonsuzluğa atıfta bulunuyor. ",
           "Heyecan verici haberler görüyorum hepsi birnirine bağlanmış. Yaklaşmakta olan büyük bir olay var. İstediğiniz alanda çok hızlı bir ilerleme kat edeceksiniz. Yapılacak kısa ama ruhen motive edici yolculuklarınız var. Daha mutlu haberlerle, başka kahve molalarınızda tekrar görüşmek dileğiyle..."

   };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textView = findViewById(R.id.textView);
        Random random= new Random();
        int num = random.nextInt(yanitlar.length);
        textView.setText(yanitlar[num]);

        Toast toast = new Toast(getApplicationContext());
        Toast.makeText(MainActivity2.this,"Falınız Geldi",Toast.LENGTH_LONG).show();

    }




}