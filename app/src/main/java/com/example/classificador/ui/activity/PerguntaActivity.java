package com.example.classificador.ui.activity;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.classificador.R;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import Application.Application;
import Arvore.ArvoreService;
import Arvore.No;
import Entrada.Decisao;

public abstract class PerguntaActivity extends AppCompatActivity {

    public abstract Handler getHideHandler();
    public abstract int getId();

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pergunta);

        InputStream fisPlanilha = getResources().openRawResource(getId());
        List<Decisao> listaDecisao = new ArrayList<>();

        try {
            XSSFWorkbook workbook = new XSSFWorkbook(fisPlanilha);
            XSSFSheet sheet = workbook.getSheetAt(0);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                sheet.rowIterator().forEachRemaining(linha -> {
                    if (Application.eLinhaValida(linha)) {
                        listaDecisao.add(Application.criarDecisaoPorLinha(linha));
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        ArvoreService service = new ArvoreService(Application.processaListaDecisao(listaDecisao));
        No raiz = service.getNoAtual();
        TextView perguntTextView = findViewById(R.id.textView_pergunta);
        perguntTextView.setText(raiz.getTextoPrincipal());
        TextView ajudTextView = findViewById(R.id.textView_ajuda);
        ajudTextView.setText(raiz.getTextoAjuda());

        Button buttonSim = findViewById(R.id.button_sim);
        Button buttonNao = findViewById(R.id.button_nao);


        buttonSim.setOnClickListener(v -> {
            service.direita();
            processaNoAtual(service, buttonSim, buttonNao);
        });

        buttonNao.setOnClickListener(v -> {
            service.esquerda();
            processaNoAtual(service, buttonSim, buttonNao);
        });

    }

    private void processaNoAtual(ArvoreService service, Button buttonSim, Button buttonNao) {
        if (!service.getNoAtual().iseNoFinal()) {
            TextView perguntaTextView = findViewById(R.id.textView_pergunta);
            perguntaTextView.setText(service.getNoAtual().getTextoPrincipal());
            TextView ajudsTextView = findViewById(R.id.textView_ajuda);
            ajudsTextView.setText(service.getNoAtual().getTextoAjuda());
        } else {
            TextView perguntaTextView = findViewById(R.id.textView_pergunta);
            perguntaTextView.setText(service.getNoAtual().getTextoPrincipal());
            getHideHandler().post(() -> {
                buttonSim.setVisibility(View.GONE);
                buttonNao.setVisibility(View.GONE);
            });
        }
    }

}