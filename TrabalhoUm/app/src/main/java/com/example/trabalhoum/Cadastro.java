package com.example.trabalhoum;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class Cadastro extends AppCompatActivity implements View.OnClickListener {

    Button btnCad, btnLog;
    EditText edtUser, edtSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_cadastro);



        btnCad = findViewById(R.id.btnCad1);
        btnLog = findViewById(R.id.btnLogin1);
        edtSenha = findViewById(R.id.edtSenha1);
        edtUser = findViewById(R.id.edtUser1);


    }

    @Override
    public void onClick(View view) {
        Intent itRecebe = new Intent();
        itRecebe = getIntent();
        ArrayList<Usuario> usuarios = itRecebe.getParcelableArrayListExtra("usuarios");
        if(view.getId() == btnCad.getId()){
            Usuario usuario = new Usuario();
            usuario.setSenha(String.valueOf(edtSenha));
            usuario.setUser(String.valueOf(edtUser));
            usuarios.add(usuario);
            Toast.makeText(this, "Usuário Cadastrado!", Toast.LENGTH_SHORT).show();
            Intent it = new Intent(this, Login.class);
            it.putParcelableArrayListExtra("usuarios", usuarios);
            startActivity(it);
        }else if(view.getId() == btnLog.getId()){
            Intent it = new Intent(this, Login.class);
            it.putParcelableArrayListExtra("usuarios", usuarios);
            startActivity(it);
        }
    }
}
