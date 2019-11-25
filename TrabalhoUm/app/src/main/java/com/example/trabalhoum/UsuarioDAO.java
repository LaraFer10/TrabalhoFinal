package com.example.trabalhoum;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    private Conexao conexao;
    private SQLiteDatabase banco;

    public UsuarioDAO(Context context){
        conexao = new Conexao((context));
        banco = conexao.getWritableDatabase();
    }

    public void cadastrar(Usuario usuario){

        ContentValues values = new ContentValues();
        values.put("user", usuario.getUser());
        values.put("senha", usuario.getSenha());
        values.put("idade", usuario.getIdade());
        values.put("profissao", usuario.getProfissao());

        banco.insert("trabalhoumdb", null, values);
    }

    public ArrayList<Usuario> buscaUsuarios(){
        ArrayList<Usuario> lista = new ArrayList<>();
        String[] colunas = new String[]{"id", "user", "senha", "idade", "profissao"};
        Cursor cursor = banco.query("usuario", colunas, null, null, null, null, "user ASC");
        if(cursor.getCount()>0){
            cursor.moveToFirst();
            do{
                Usuario user = new Usuario();
                user.setId(cursor.getInt(0));
                user.setUser(cursor.getString(1));
                user.setSenha(cursor.getString(2));
                user.setIdade(cursor.getInt(3));
                user.setProfissao(cursor.getString(4));
                lista.add(user);
            }while(cursor.moveToNext());
        }
        return lista;

    }
}
