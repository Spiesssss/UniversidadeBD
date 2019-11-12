package com.example.prepaula;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void cadastraPessoa(View view) {
        EditText et_nome = findViewById(R.id.et_pegaNome);
        EditText et_curso = findViewById(R.id.et_pegaCurso);
        RadioGroup rg_sexo = findViewById(R.id.rg_pegaSexo);



        String nome = et_nome.getText().toString();
        String curso = et_curso.getText().toString();
        int idRadioButtonSexo = rg_sexo.getCheckedRadioButtonId();
        RadioButton rb_sexo = findViewById(idRadioButtonSexo);
        String sexo = rb_sexo.getText().toString();

        ImageView iv_Icone = findViewById(R.id.iv_icone);
        if (sexo.equals("Feminino")){
            iv_Icone.setImageResource(R.drawable.feminino);
        }else
        {
            iv_Icone.setImageResource(R.drawable.masculino);
        }

        TextView tv_MostraNome = findViewById(R.id.tv_mostraNome);
        tv_MostraNome.setText(nome);
        TextView tv_MostraCurso = findViewById(R.id.tv_mostraCurso);
        tv_MostraCurso.setText(curso);



    }
}
