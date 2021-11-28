package com.ezgidogan.falapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SingUpActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    EditText emailText,passwordText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singup);

    firebaseAuth = FirebaseAuth.getInstance();
    emailText = findViewById(R.id.emailText);
    passwordText = findViewById(R.id.passwordText);


    emailText.setTextColor(Color.parseColor("#8E24AA"));
    passwordText.setTextColor(Color.parseColor("#8E24AA"));

    //Daha önceden kullanıcı girişi olduysa uygulama açıldığında kullanıcı girişi istemeden MainActivity yönlendirir.
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();

        if ( firebaseUser != null){
            Intent intent = new Intent(SingUpActivity.this,MainActivity.class);
            startActivity(intent);
            finish();
        }

    }


    public void  singInClicked (View view){
        String email = emailText.getText().toString();
        String password = passwordText.getText().toString();

        firebaseAuth.signInWithEmailAndPassword(email,password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                //Kullanıcı girişi sağlandığında Main activite ye git
                Intent intent = new Intent(SingUpActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
            Toast.makeText(SingUpActivity.this,e.getLocalizedMessage().toString(),Toast.LENGTH_LONG).show();
            }
        });
    }



    public <SignUpActivity> void singUpClicked (View view){

        String email = emailText.getText().toString();
        String password = passwordText.getText().toString();

        //Kullanıcı oluşturmak ve daha önce oluşturulmuşmu diye kontrol etmek için
       //başarılı olursa succes kod bloğu çalışacak
        firebaseAuth.createUserWithEmailAndPassword(email,password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Toast.makeText(SingUpActivity.this,"User Created",Toast.LENGTH_LONG).show();

                Intent intent = new Intent(SingUpActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
            //başarısız olursa failure kod bloğu çalışacak
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(SingUpActivity.this,e.getLocalizedMessage().toString(),Toast.LENGTH_LONG).show();

            }
        });


    }



}