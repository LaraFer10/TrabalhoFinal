package com.example.trabalhoum;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Home extends AppCompatActivity implements View.OnClickListener {

        Button btnr;
        ListView lista;
    TextView user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_home);

       user = findViewById(R.id.nomeUsuario);
        btnr = findViewById(R.id.btnRec);
        lista = findViewById(R.id.listaRecomendacao);
        Intent itRecebe = new Intent();
        itRecebe = getIntent();
        ArrayList<Usuario> usuarios = itRecebe.getParcelableArrayListExtra("usuarios");
       user.setText(usuarios.get(0).getUser());
        ArrayAdapter recomendacoes = new ArrayAdapter(this, android.R.layout.simple_list_item_1, usuarios.get(0).recomendacoes);
        lista.setAdapter(recomendacoes);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == btnr.getId()){

        }
    }
}
