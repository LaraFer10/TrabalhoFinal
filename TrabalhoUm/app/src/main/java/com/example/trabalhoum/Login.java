package com.example.trabalhoum;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class Login extends AppCompatActivity implements View.OnClickListener {

    EditText senha, user;
    Button btnEntrar, btnCad;
    ArrayList<Usuario> usuarios = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_login);
        senha = findViewById(R.id.edtSenha);
        user = findViewById(R.id.edtUser);
        btnCad = findViewById(R.id.btnCad);
        btnEntrar = findViewById(R.id.btnEntrar);
    }

    @Override
    public void onClick(View view) {
        Intent itRecebe = new Intent();
        itRecebe = getIntent();
        usuarios = itRecebe.getParcelableArrayListExtra("usuarios");
        String senha1 = String.valueOf(senha);
        String user1 = String.valueOf(user);
        Usuario user0 = new Usuario();
        user0.setUser("Larinha");
        Recomendacao r1 = new Recomendacao("The Good Place", "Serie","Eu gosoto muito dessa serie e ela é mais engraçada dublada!", "Netflix, Superflix");
        Recomendacao r2 = new Recomendacao("@ifyouhigh", "Instagram","Nessa conta do insta eles postam videos muito loucos que mechem com a ilusão de optica e afins. Fico horas vidrada kkkk", "Instagram");
        user0.setSenha("larinha12");
        user0.recomendacoes.add(r1);
        user0.recomendacoes.add(r2);
        usuarios.add(user0);
        if(view.getId() == btnCad.getId()){
            Intent it1 = new Intent(this, Cadastro.class);
            it1.putParcelableArrayListExtra("usuarios", usuarios);
            startActivity(it1);
        }
        if(view.getId() == btnEntrar.getId()){
                    Intent it2 = new Intent(this, Home.class);
                    it2.putParcelableArrayListExtra("usuarios", usuarios);
                    startActivity(it2);

        }
    }
}
