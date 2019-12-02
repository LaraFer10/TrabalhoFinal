package com.example.trabalhoum;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class CadRecomendaActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btn;
    private ImageButton btnIcon;
    private EditText edtNome, edtDesc, edtOnde, edtCat;
    private RecomendacaoDAO recDAO;
    private Usuario user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad_recomenda);

        edtNome = findViewById(R.id.edtNome);
        edtCat = findViewById(R.id.edtCat);
        edtDesc = findViewById(R.id.edtDesc);
        edtOnde = findViewById(R.id.edtOnde);
        btn = findViewById(R.id.btnCadR);
        btnIcon = findViewById(R.id.btnVoltaPerf);

        Intent it = getIntent();
        user = it.getParcelableExtra("usuario");

        recDAO = new RecomendacaoDAO(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == btn.getId()){
            Recomendacao reco = new Recomendacao();
            reco.setCategoria(edtCat.getText().toString());
            reco.setDescricao(edtDesc.getText().toString());
            reco.setNome(edtNome.getText().toString());
            reco.setOndeEncontrar(edtOnde.getText().toString());
            reco.setUsuarioId(user.getId());
            recDAO.cadastrar(reco);
            Toast.makeText(this, "Recomendação Adicionada!", Toast.LENGTH_SHORT).show();
        }

        if(view.getId()== btnIcon.getId()){
            Intent it = new Intent(this, HomeActivity.class);
            it.putExtra("usuario", (Parcelable) user);
            startActivity(it);
        }
    }
}
