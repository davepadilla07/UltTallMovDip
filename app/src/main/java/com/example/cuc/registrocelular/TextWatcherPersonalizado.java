package com.example.cuc.registrocelular;

import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.TextWatcher;

/**
 * Created by CUC on 3/06/2017.
 */

public abstract class TextWatcherPersonalizado implements TextWatcher {
    private TextInputLayout icaja;
    private String textoError;

    public TextWatcherPersonalizado(TextInputLayout icaja, String textoError) {
        this.icaja = icaja;
        this.textoError = textoError;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        if (estaVacio(s)) icaja.setError(textoError);
        else if (icaja.isErrorEnabled()){
            icaja.setError(null);
        }
    }

    public abstract boolean estaVacio(Editable s);
}