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



        this.btnCad1 = findViewById(R.id.btnCad1);
        this.btnLog1 = findViewById(R.id.btnLogin1);
        this.edtSenha1 = findViewById(R.id.edtSenha1);
        this.edtUser1 = findViewById(R.id.edtUser1);
        this.edtIdade1 = findViewById(R.id.edtIdade1);
        this.edtProf1 = findViewById(R.id.edtProf1);

        userDAO = new UsuarioDAO(this);

    }

    @Override
    public void onClick(View view) {

        if(view.getId() == this.btnCad1.getId()){
            Usuario usuario = new Usuario();
            usuario.setSenha(this.edtSenha1.getText().toString());
            usuario.setUser(this.edtUser1.getText().toString());
            usuario.setIdade(Integer.parseInt(this.edtIdade1.getText().toString()));
            usuario.setProfissao(this.edtProf1.getText().toString());
            userDAO.cadastrar(usuario);
            Toast.makeText(this, "Usuário Cadastrado!", Toast.LENGTH_SHORT).show();
            Intent it1 = new Intent(this, Login.class);
            startActivity(it1);
        }else if(view.getId() == btnLog1.getId()){
            Intent it = new Intent(this, Login.class);
            startActivity(it);
        }
    }
}
