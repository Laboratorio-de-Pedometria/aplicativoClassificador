package com.example.classificador.ui.activity;

import android.os.Handler;

import com.example.classificador.R;

public class PerguntaSoloSubsuperficialActivity extends PerguntaActivity{

    @Override
    public Handler getHideHandler() {
        return new Handler();
    }

    @Override
    public int getId() {
        return R.raw.base_dados_superficial;
    }


}