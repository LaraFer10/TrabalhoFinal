package com.example.trabalhoum;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class Login extends AppCompatActivity implements View.OnClickListener {

    private EditText senha, user;
    private Button btnEntrar, btnCad;
    private ArrayList<Usuario> usuarios = new ArrayList<>();
    private UsuarioDAO userDAO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getSupportActionBar().hide();
        setContentView(R.layout.activity_login);
        this.senha = findViewById(R.id.edtSenha);
        this.user = findViewById(R.id.edtUser);
        this.btnCad = findViewById(R.id.btnCad);
        this.btnEntrar = findViewById(R.id.btnEntrar);

        this.userDAO = new UsuarioDAO(this);
    }

    @Override
    public void onClick(View view) {

        String senha1 = String.valueOf(senha.getText().toString());
        String user1 = String.valueOf(user.getText().toString());
        if(view.getId() == btnCad.getId()){

                    Intent it1 = new Intent(this, CadastroActivity.class);
                    startActivity(it1);

        }
        if(view.getId() == btnEntrar.getId()){
        this.usuarios = userDAO.buscaUsuarios();
            for (int i=0;i<usuarios.size();i++) {
                    Usuario u = new Usuario();
                if (usuarios.get(i).getSenha().equals(senha1)) {
                    if (usuarios.get(i).getUser().equals(user1)) {
                        u.setId(usuarios.get(i).getId());
                        u.setUser(usuarios.get(i).getUser());
                        u.setProfissao(usuarios.get(i).getProfissao());
                        u.setIdade(usuarios.get(i).getIdade());
                        u.setSenha(usuarios.get(i).getSenha());
                        Intent it2 = new Intent(this, HomeActivity.class);
                        it2.putExtra("usuario", (Parcelable) u);
                        startActivity(it2);
                    }
                }
            }
        }
    }
}
