package com.example.trabalhoum;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ArrayList<Usuario> usuarios = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mostraLogin();
            }
        }, 2000);
    }

    public void mostraLogin(){
        Intent it = new Intent(this, Login.class);
        it.putParcelableArrayListExtra("usuarios", usuarios);
        startActivity(it);
    }
}
