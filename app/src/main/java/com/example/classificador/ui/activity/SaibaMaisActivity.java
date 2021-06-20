package com.example.classificador.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import com.example.classificador.R;

public class SaibaMaisActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);

        TextView saibaMaisTextView = findViewById(R.id.textView_texto_de_creditos);
        String textoCreditos = "Recurso Educacional Aberto produzido com o fomento do Edital de Apoio ao " +
                "Desenvolvimento de Recursos Educacionais Abertos na Graduação da UTFPR.\n\n" +
                "Dados de autoria: \n\nAlessandro Samuel-Rosa, Professor Coordenador,\n alessandrorosa@utfpr.edu.br.\n\n" +
                "Letícia D Santi Moreira, Bolsista de Iniciação Científica,\n leticiamoreira@alunos.utfpr.edu.br\n\n" +
                "Giuvane Conti, Professor \n" +
                "Colaboradores: \n" +
                "Dados de autoria (responsável intelectual pelo conteúdo) e colaboradores;, Créditos (indicar as " +
                "funções desempenhadas pelos membros da equipe);,Recurso Educacional Aberto produzido com o fomento do Edital de Apoio ao" +
                " Desenvolvimento de Recursos Educacionais Abertos na Graduação da UTFPR " +
                "Dados de autoria (responsável intelectual pelo conteúdo) e colaboradores;, Créditos (indicar as " +
                "funções desempenhadas pelos membros da equipe);,Recurso Educacional Aberto produzido com o fomento do Edital de Apoio ao" +
                " Desenvolvimento de Recursos Educacionais Abertos na Graduação da UTFPR " +
                "Dados de autoria (responsável intelectual pelo conteúdo) e colaboradores;, Créditos (indicar as " +
                "funções desempenhadas pelos membros da equipe);,Recurso Educacional Aberto produzido com o fomento do Edital de Apoio ao" +
                " Desenvolvimento de Recursos Educacionais Abertos na Graduação da UTFPR " +
                "Dados de autoria (responsável intelectual pelo conteúdo) e colaboradores;, Créditos (indicar as " +
                "funções desempenhadas pelos membros da equipe);,Recurso Educacional Aberto produzido com o fomento do Edital de Apoio ao" +
                " Desenvolvimento de Recursos Educacionais Abertos na Graduação da UTFPR " +
                "Dados de autoria (responsável intelectual pelo conteúdo) e colaboradores;, Créditos (indicar as " +
                "funções desempenhadas pelos membros da equipe);,Recurso Educacional Aberto produzido com o fomento do Edital de Apoio ao" +
                " Desenvolvimento de Recursos Educacionais Abertos na Graduação da UTFPR " +
                "";
        saibaMaisTextView.setText(textoCreditos);
        saibaMaisTextView.setMovementMethod(new ScrollingMovementMethod());
    }
}
