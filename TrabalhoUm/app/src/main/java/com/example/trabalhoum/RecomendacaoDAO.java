package com.example.trabalhoum;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class RecomendacaoDAO {
    private Conexao conexao;
    private SQLiteDatabase banco;

    public RecomendacaoDAO(Context context){
        conexao = new Conexao(context);
        banco = conexao.getWritableDatabase();
    }

    public void cadastrar(Recomendacao recomendacao){
        ContentValues values = new ContentValues();
        values.put("nome", recomendacao.getNome());
        values.put("descricao", recomendacao.getDescricao());
        values.put("categoria", recomendacao.getCategoria());
        values.put("ondeEncontrar", recomendacao.getOndeEncontrar());
        values.put("usuarioId", recomendacao.getUsuarioId());
        banco.insert("recomendacao", null, values);
    }

    public ArrayList<Recomendacao> buscaRecomendacoesDoUsuario(int id){
        ArrayList<Recomendacao> lista = new ArrayList<>();
        String[] colunas = new String[]{"*"};
        Cursor cursor = banco.query("recomendacao", colunas, "usuarioId = ?", new String[]{""+id}, null, null, "nome ASC");

        if(cursor.getCount()>0){
            cursor.moveToFirst();
            do{
                Recomendacao r = new Recomendacao();
                r.setId(cursor.getInt(0));
                r.setNome(cursor.getString(1));
                r.setDescricao(cursor.getString(2));
                r.setCategoria(cursor.getString(3));
                r.setOndeEncontrar(cursor.getString(4));
                r.setUsuarioId(cursor.getInt(5));
                lista.add(r);
            }while(cursor.moveToNext());
        }
        return lista;
    }


}
