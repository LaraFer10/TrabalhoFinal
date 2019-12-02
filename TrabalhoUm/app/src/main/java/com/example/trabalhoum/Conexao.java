package com.example.trabalhoum;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Conexao extends SQLiteOpenHelper {
    private static final String name = "trabalhoumdb";
    private static final int version = 1;
    public Conexao(Context context) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table usuario(id integer primary key autoincrement," +
                "user varchar (20), senha varchar (45), idade integer, profissao varchar (45))");
        db.execSQL("create table recomendacao(id integer primary key autoincrement," +
                "nome varchar (45), categoria varchar (45), descricao varchar (45), ondeEncontrar varchar (45)" +
                ",usuarioId integer not null constraint usuarioId references usuario (id) on delete cascade)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }
}
