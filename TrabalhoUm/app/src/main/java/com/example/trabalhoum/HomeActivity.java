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

import java.io.Serializable;
import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton btnr, btnusers;
    private ListView lista;
    private TextView user;
    private RecomendacaoDAO recDAO;
    private Usuario usuario;
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
        this.usuario = itRecebe.getExtras().getParcelable("usuario");
        recDAO = new RecomendacaoDAO(this);
        user.setText(usuario.getUser());

        ArrayList<Recomendacao> recomendacao = recDAO.buscaRecomendacoesDoUsuario(usuario.getId());

        ArrayList<String> nomeRecs = new ArrayList<>();
        for (int i=0;i<recomendacao.size();i++){
            nomeRecs.add(recomendacao.get(i).getNome());
        }

        ArrayAdapter<String> recomendacoes = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, android.R.id.text1,
                nomeRecs);
        lista.setAdapter(recomendacoes);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == btnr.getId()){
            Intent it = new Intent(this, CadRecomendaActivity.class);
            it.putExtra("usuario", (Parcelable) usuario);
            startActivity(it);
        }else if(view.getId() == btnusers.getId()){
            Intent it2 = new Intent(this, UsuariosActivity.class);
            startActivity(it2);
        }
    }
}
