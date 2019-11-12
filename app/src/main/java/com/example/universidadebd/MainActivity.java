package com.example.universidadebd;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ManipuladorBD meuBanco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        meuBanco = new ManipuladorBD(this);
    }

    public void realizarMatricula(View view) {
        EditText pegaNome = findViewById(R.id.et_pegaNome);
        EditText pegaCPF = findViewById(R.id.et_pegaCPF);
        EditText pegaCurso = findViewById(R.id.et_pegaCurso);

        String nomeAluno = pegaNome.getText().toString();
        String cpfAluno = pegaCPF.getText().toString();
        String cursoAluno = pegaCurso.getText().toString();

        int codigoCurso = meuBanco.pegaCurso(cursoAluno);
        meuBanco.adicionaAluno(nomeAluno,cpfAluno,codigoCurso);
    }

    public void mostrarCursos(View view) {
        ArrayList<Curso> meusCursos = new ArrayList<Curso>();
        meusCursos = meuBanco.mostraCursos();
        TextView tv_mostraCursos = findViewById(R.id.tv_mostraCursos);
        String texto="";
        for (int x=0;x<meusCursos.size();x++){
            Curso cursoTemp = meusCursos.get(x);
            texto=texto+" \nNome: "+cursoTemp.getNome()+" Descricao :"+
                    cursoTemp.getDescricao()+ " duracao: "+cursoTemp.getDuracao()+
                    "codigo: "+cursoTemp.getCodigo();
        }
        tv_mostraCursos.setText(texto);
    }
}
