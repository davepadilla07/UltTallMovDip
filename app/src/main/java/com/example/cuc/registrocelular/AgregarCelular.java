package com.example.cuc.registrocelular;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.widget.EditText;

public class AgregarCelular extends AppCompatActivity {
    private EditText cajaCodCertificado;
    private EditText cajaNombre;
    private EditText cajaMarca;
    private EditText cajaColor;
    private boolean guardado=false;
    private TextInputLayout icajaCodCertificado;
    private TextInputLayout icajaNombre;
    private TextInputLayout icajaMarca;
    private TextInputLayout icajaColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_celular);

        cajaCodCertificado=(EditText)findViewById(R.id.txtCodC);
        cajaNombre=(EditText)findViewById(R.id.txtNombreC);
        cajaMarca=(EditText)findViewById(R.id.txtMarcaC);
        cajaColor=(EditText)findViewById(R.id.txtCodC);

        icajaCodCertificado=(TextInputLayout)findViewById(R.id.CodCertificado);
        icajaNombre=(TextInputLayout)findViewById(R.id.NombreCelular);
        icajaMarca=(TextInputLayout)findViewById(R.id.MarcaCelular);
        icajaColor=(TextInputLayout)findViewById(R.id.ColorCelular);

        cajaCodCertificado.addTextChangedListener(new TextWatcherPersonalizado(icajaCodCertificado,getResources().getString(R.string.error1)) {
            @Override
            public boolean estaVacio(Editable s) {
                if (TextUtils.isEmpty(s)&&!guardado) return true;
                else return false;
            }
        });
        cajaNombre.addTextChangedListener(new TextWatcherPersonalizado(icajaNombre,getResources().getString(R.string.error2)) {
            @Override
            public boolean estaVacio(Editable s) {
                if (TextUtils.isEmpty(s)&&!guardado) return true;
                else return false;
            }
        });
        cajaMarca.addTextChangedListener(new TextWatcherPersonalizado(icajaMarca,getResources().getString(R.string.error3)) {
            @Override
            public boolean estaVacio(Editable s) {
                if (TextUtils.isEmpty(s)&&!guardado) return true;
                else return false;
            }
        });
        cajaColor.addTextChangedListener(new TextWatcherPersonalizado(icajaColor,getResources().getString(R.string.error4)) {
            @Override
            public boolean estaVacio(Editable s) {
                if (TextUtils.isEmpty(s)&&!guardado) return true;
                else return false;
            }
        });


    }
}
