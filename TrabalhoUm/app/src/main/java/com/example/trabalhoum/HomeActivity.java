package com.example.trabalhoum;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton btnr, btnusers;
    private ListView lista;
    private TextView user;
    private RecomendacaoDAO recDAO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getSupportActionBar().hide();
        setContentView(R.layout.activity_home);

       user = findViewById(R.id.nomeUsuario);
        btnr = findViewById(R.id.btnAddRec);
        btnusers = findViewById(R.id.btnVerUsers);
        lista = findViewById(R.id.listaRecomendacao);
        Intent itRecebe = getIntent();
        Usuario usuario = itRecebe.getExtras().getParcelable("usuario");
        recDAO = new RecomendacaoDAO(this);
        user.setText(usuario.getUser()+" | "+usuario.getProfissao()+" | "+usuario.getIdade());

        ArrayAdapter recomendacoes = new ArrayAdapter(this, android.R.layout.simple_list_item_1, recDAO.buscaRecomendacoesDoUsuario(usuario.getId()));
        lista.setAdapter(recomendacoes);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == btnr.getId()){
            Intent it = new Intent(this, CadRecomendaActivity.class);
            it.putExtra("usuario", (Parcelable) user);
            startActivity(it);
        }else if(view.getId() == btnusers.getId()){
            Intent it2 = new Intent(this, UsuariosActivity.class);
            startActivity(it2);
        }
    }
}
