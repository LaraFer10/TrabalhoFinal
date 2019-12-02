package com.example.trabalhoum;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class UsuariosActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<Usuario> usuariosCadastrados;
    private UsuarioDAO userDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuarios);
        this.recyclerView = findViewById(R.id.rv_list);
        this.popularUsuarios();
        UsuariosAdapter adapter = new UsuariosAdapter(this.usuariosCadastrados);

        RecyclerView.LayoutManager layout = new LinearLayoutManager(this);
        this.recyclerView.setLayoutManager(layout);
        this.recyclerView.setHasFixedSize(true);
        this.recyclerView.setAdapter(adapter);

    }

    public void popularUsuarios(){
        this.userDAO = new UsuarioDAO(this);
        this.usuariosCadastrados = this.userDAO.buscaUsuarios();
    }
}
