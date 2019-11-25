package com.example.trabalhoum;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class CadastroActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnCad1, btnLog1;
    private EditText edtUser1, edtSenha1, edtIdade1, edtProf1;

    private UsuarioDAO userDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getSupportActionBar().hide();
        setContentView(R.layout.activity_cadastro);



        btnCad1 = findViewById(R.id.btnCad1);
        btnLog1 = findViewById(R.id.btnLogin1);
        edtSenha1 = findViewById(R.id.edtSenha1);
        edtUser1 = findViewById(R.id.edtUser1);
        edtIdade1 = findViewById(R.id.edtIdade1);
        edtProf1 = findViewById(R.id.edtProf1);

        userDAO = new UsuarioDAO(this);

    }

    @Override
    public void onClick(View view) {

        if(view.getId() == btnCad1.getId()){
            Usuario usuario = new Usuario();
            usuario.setSenha(String.valueOf(edtSenha1));
            usuario.setUser(String.valueOf(edtUser1));
            usuario.setIdade(Integer.parseInt(String.valueOf(edtIdade1)));
            usuario.setProfissao(String.valueOf(edtProf1));
            userDAO.cadastrar(usuario);
            Toast.makeText(this, "Usuário Cadastrado!", Toast.LENGTH_SHORT).show();
            Intent it = new Intent(this, Login.class);
            startActivity(it);
        }else if(view.getId() == btnLog1.getId()){
            Intent it = new Intent(this, Login.class);
            startActivity(it);
        }
    }
}
