package com.example.classificador.ui.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.classificador.R;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import Application.Application;
import Arvore.ArvoreService;
import Arvore.No;
import Entrada.Decisao;

import static Application.Application.eLinhaValida;
import static Utils.Helper.TELA_INICIAL;

public abstract class PerguntaActivity extends AppCompatActivity {

    private List<Decisao> listaDecisao;
    private ArvoreService service;
    private Button buttonSim;
    private Button buttonNao;
    private Button buttonReiniciar;

    public abstract Handler getHideHandler();

    public abstract int getId();

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pergunta);
        buttonSim = findViewById(R.id.button_sim);
        buttonNao = findViewById(R.id.button_nao);
        buttonReiniciar = findViewById(R.id.button_reiniciar);

        InputStream fisPlanilha = getResources().openRawResource(getId());
        listaDecisao = new ArrayList<>();
        try {
            XSSFWorkbook workbook = new XSSFWorkbook(fisPlanilha);
            XSSFSheet sheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = sheet.iterator();
            Row currentRow = iterator.next();
            while (eLinhaValida(currentRow)) {
                listaDecisao.add(Application.criarDecisaoPorLinha(currentRow));
                currentRow = iterator.next();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        service = new ArvoreService(Application.processaListaDecisao(listaDecisao));
        No raiz = service.getNoAtual();
        TextView perguntTextView = findViewById(R.id.textView_pergunta);
        perguntTextView.setText(raiz.getTextoPrincipal());
        TextView ajudTextView = findViewById(R.id.textView_ajuda);
        ajudTextView.setMovementMethod(new ScrollingMovementMethod());
        ajudTextView.setText(raiz.getTextoAjuda());


        buttonSim.setOnClickListener(v -> {
            service.direita();
            processaNoAtual(service, buttonSim, buttonNao);
        });

        buttonNao.setOnClickListener(v -> {
            service.esquerda();
            processaNoAtual(service, buttonSim, buttonNao);
        });
        buttonReiniciar.setOnClickListener(v -> startActivity(new Intent(PerguntaActivity.this, MainActivity.class)));
    }

    private void processaNoAtual(ArvoreService service, Button buttonSim, Button buttonNao) {
        TELA_INICIAL = false;
        TextView perguntaTextView;
        TextView ajudaTextView;
        perguntaTextView = findViewById(R.id.textView_pergunta);
        perguntaTextView.setText(service.getNoAtual().getTextoPrincipal());
        ajudaTextView = findViewById(R.id.textView_ajuda);
        ajudaTextView.setMovementMethod(new ScrollingMovementMethod());
        ajudaTextView.setText(service.getNoAtual().getTextoAjuda());

        if (service.getNoAtual().iseNoFinal()) {
            getHideHandler().post(() -> {
                buttonSim.setVisibility(View.GONE);
                buttonNao.setVisibility(View.GONE);
            });
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onBackPressed() {
        if (TELA_INICIAL) {
            super.onBackPressed();
        } else {
            if (service.getNoAtual().iseNoFinal()) {
                getHideHandler().post(() -> {
                    buttonSim.setVisibility(View.VISIBLE);
                    buttonNao.setVisibility(View.VISIBLE);
                });
            }
            service.voltar();
            if (Objects.isNull(service.getNoAtual())) {
                TELA_INICIAL = true;
                startActivity(new Intent(PerguntaActivity.this, MainActivity.class));
            } else {
                processaNoAtual(service, buttonSim, buttonNao);
            }
        }
    }

}