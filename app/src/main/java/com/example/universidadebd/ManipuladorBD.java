package com.example.universidadebd;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import
        androidx.annotation.Nullable;

import java.util.ArrayList;

public class ManipuladorBD extends SQLiteOpenHelper {
    private static final String NOMEBD = "universidadeBD";
    private static final int VERSAO = 0;

    public ManipuladorBD(@Nullable Context context) {
        super(context, NOMEBD, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //Chama o método que cria a tabela curso
        criaTabelaCurso();
        //Chama o método que cria a tabela aluno.
        criaTabelaAluno();
        populaCurso();

    }


    private void criaTabelaAluno() {
        String sql = "CREATE TABLE ALUNO ("+
                "matricula int PRIMARY KEY,"+
                "nome varchar(200),"+
                "cpf char(11) UNIQUE," +
                "curso smallint,"+
                "FOREIGN KEY (curso) REFERENCES CURSO(codigo)"+
                ")";
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(sql);
    }

    private void criaTabelaCurso() {
        String sql = "CREATE TABLE CURSO ("+
                "codigo smallint PRIMARY KEY,"+
                "nome varchar(200),"+
                "descricao varchar(2000),"+
                "duracao smallint)";

        SQLiteDatabase bd = getWritableDatabase();
        bd.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String sql = "DROP TABLE IF EXISTS ALUNO";
        sqLiteDatabase.execSQL(sql);
        sql = "DROP TABLE IF EXISTS CURSO";
        sqLiteDatabase.execSQL(sql);

        onCreate(sqLiteDatabase);
    }

    public void adicionaCurso(String nome,String descricao, int duracao){
        SQLiteDatabase db = getWritableDatabase();
        //ContentValues é o objeto que contém os dados para inserir na tabela
        ContentValues novoCurso = new ContentValues();
        novoCurso.put("nome",nome);
        novoCurso.put("descricao",descricao);
        novoCurso.put("duracao",duracao);

        //adiciona o novoCurso na tabela curso
        db.insert("curso",null,novoCurso);

        /*String sql = "INSERT INTO CURSO (nome,descricao,duracao)"+
                "VALUES("+nome+","+descricao+","+duracao+")";
        db.execSQL(sql);*/

        db.close();
    }

    public void populaCurso(){
        SQLiteDatabase db = getWritableDatabase();
        String sql = "INSERT INTO CURSO(nome,descricao,duracao)"+
                "VALUES('Ciência da computação','curso foda pra caralho',"
                +"5)";
        db.execSQL(sql);
        sql = "INSERT INTO CURSO(nome,descricao,duracao)"+
                "VALUES('Direito','curso de advogados',"
                +"5)";
        db.execSQL(sql);
        db.close();
    }

    public void adicionaAluno(String nome, String cpf, int curso){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues novoAluno = new ContentValues();
        novoAluno.put("nome",nome);
        novoAluno.put("cpf",cpf);
        novoAluno.put("curso",curso);
        db.insert("aluno", null,novoAluno);
        db.close();
    }

    public int pegaCurso(String nomeCurso){
        int codigoCurso=0;
        String sql = "SELECT codigo FROM CURSO WHERE nome="+nomeCurso;
        SQLiteDatabase db = getWritableDatabase();
        Cursor linha = db.rawQuery(sql,null);
        if(linha.moveToFirst()){
            do {
                int posicao = linha.getColumnIndex("codigo");
                codigoCurso = linha.getInt(posicao);
            }while(linha.moveToNext());
            linha.close();
        }

        return codigoCurso;
    }

    public ArrayList<Curso> mostraCursos(){
        SQLiteDatabase db = getWritableDatabase();
        String sql = "SELECT * FROM CURSO";
        Cursor linha = db.rawQuery(sql,null);
        ArrayList<Curso> cursosAtuais;
        cursosAtuais = new ArrayList<Curso>();
        if (linha.moveToFirst()){
            do {
                int posicao = linha.getColumnIndex("codigo");
                int codigo = linha.getInt(posicao);
                posicao = linha.getColumnIndex("nome");
                String nomeCurso = linha.getString(posicao);
                posicao = linha.getColumnIndex("descricao");
                String descricaoCurso = linha.getString(posicao);
                posicao = linha.getColumnIndex("duracao");
                int duracaoCurso = linha.getInt(posicao);
                Curso novoCurso = new Curso(nomeCurso,descricaoCurso,codigo,duracaoCurso);
                cursosAtuais.add(novoCurso);
            } while (linha.moveToNext());
            linha.close();
        }
        return cursosAtuais;
    }
}
