package com.example.classificador.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import com.example.classificador.R;

public class SaibaMaisActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);

        TextView saibaMaisTextView = findViewById(R.id.textView_texto_de_creditos);
      /*  String textoCreditos = "Recurso Educacional Aberto produzido com o fomento do Edital de Apoio ao " +
                "Desenvolvimento de Recursos Educacionais Abertos na Graduação da UTFPR.\n\n" +
                "Autores: negrito\n\n" +
                "Alessandro Samuel-Rosa\nUniversidade Tecnológica Federal do Paraná\nConcepção e design (aut, cre)\nalessandrorosa@utfpr.edu.br\n\n" +
                "Letícia D Santi Moreira\nUniversidade Tecnológica Federal do Paraná\nDesign e desenvolvimento da aplicação (aut, cre)\nleticiamoreira@alunos.utfpr.edu.br\n\n" +
                "Contribuidores: negrito\n\n" +
                "Giuvane Conti\nUniversidade Tecnológica Federal do Paraná\nDesenvolvimento da aplicação\n\n"+
                "Fabrício de Araújo Pedron\nUniversidade Federal de Santa Maria\nDesenvolvimento da base de dados\n\n" +
                "Ademir Fontana\nEmbrapa Solos\nDesenvolvimento da base de dados\n\n"+
                "Ricardo Simão Diniz Dalmolin\nUniversidade Federal de Santa Maria\nDesenvolvimento da base de dados\n\n"+
                "Glauber José Vaz\nEmbrapa Informática Agropecuária\nDesenvolvimento da base de dados\n\n\n\n\n"+
                "Contato\n"+
                "Encontrou um problema? Quer dar uma opinião? Quer saber como colaborar? " +
                "Acesse o espaço de desenvolvimento do Laboratório de Pedometria no GitHub<a href=\"http://www.google.com\">Google</a> e deixe uma mensagem para nossa equipe.\n";

        saibaMaisTextView.setText(textoCreditos);*/
        saibaMaisTextView.setPaintFlags(0);
        saibaMaisTextView.setMovementMethod(new ScrollingMovementMethod());
        saibaMaisTextView.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
