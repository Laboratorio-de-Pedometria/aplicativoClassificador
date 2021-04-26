package com.example.classificador.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.classificador.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button buttonClassificarSubsuperficial = findViewById(R.id.button_classificar_subsuperficial);
        Button buttonClassificarSuperificial = findViewById(R.id.button_classificar_superficial);


        buttonClassificarSuperificial.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, PerguntaSoloSuperficialActivity.class)));

        buttonClassificarSubsuperficial.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, PerguntaSoloSubsuperficialActivity.class)));
    }
}