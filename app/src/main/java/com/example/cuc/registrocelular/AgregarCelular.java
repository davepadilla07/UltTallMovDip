package com.example.cuc.registrocelular;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import java.io.ByteArrayOutputStream;

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
        cajaColor=(EditText)findViewById(R.id.txtColorC);

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
    public boolean buscarExistente(){
        Celular p;
        if(validarCodCertificado()) {
            p = Datos.buscarCelular(getApplicationContext(), cajaCodCertificado.getText().toString());
            if(p!=null){
                cajaCodCertificado.setError(getResources().getString(R.string.error1_1));
                cajaCodCertificado.requestFocus();
                return false;
            }
        }
        return true;
    }

    public int fotoaleatoria(){
        int foto[]={R.drawable.images1,R.drawable.images2,R.drawable.images3,R.drawable.images4,R.drawable.images5,R.drawable.images6};
        int numero=(int)(Math.random()*6);
        return foto[numero];
    }

    public boolean validarTodo() {
        if (cajaCodCertificado.getText().toString().isEmpty()) {
            icajaCodCertificado.setError(getResources().getString(R.string.error1));
            cajaCodCertificado.requestFocus();
            return false;
        }

        if (cajaNombre.getText().toString().isEmpty()) {
            icajaNombre.setError(getResources().getString(R.string.error2));
            cajaNombre.requestFocus();
            return false;
        }
        if (cajaMarca.getText().toString().isEmpty()) {
            icajaMarca.setError(getResources().getString(R.string.error3));
            cajaMarca.requestFocus();
            return false;
        }
        if (cajaColor.getText().toString().isEmpty()) {
            icajaColor.setError(getResources().getString(R.string.error4));
            cajaColor.requestFocus();
            return false;
        }
        return true;
    }

    public void guardar(View v){
        String foto,codCertificado,nombre,marca,color;
        Celular p;
        if (validarTodo() && buscarExistente()){

            codCertificado=cajaCodCertificado.getText().toString();
            nombre=cajaNombre.getText().toString();
            marca=cajaMarca.getText().toString();
            color=cajaColor.getText().toString();
            foto=String.valueOf(fotoaleatoria());

            Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(),Integer.parseInt(foto));
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG,100,baos);


            p=new Celular(foto,codCertificado,nombre,marca,color);
            p.guardar(getApplicationContext());

            InputMethodManager imp = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imp.hideSoftInputFromWindow(cajaCodCertificado.getWindowToken(),0);

            Snackbar.make(v,getResources().getString(R.string.mensaje1),Snackbar.LENGTH_SHORT).show();
            guardado=true;
            limpiar();
        }
    }

    public void limpiar(){
        cajaCodCertificado.setText("");
        cajaNombre.setText("");
        cajaMarca.setText("");
        cajaColor.setText("");
        cajaCodCertificado.requestFocus();
        guardado=true;
    }

    public void borrar(View v){limpiar();}

    public boolean validarCodCertificado(){
        if (cajaCodCertificado.getText().toString().isEmpty()) {
            icajaCodCertificado.setError(getResources().getString(R.string.error1));
            cajaCodCertificado.requestFocus();
            return false;
        }
        return true;
    }

    public void buscarCodCertificado (View v){
        Celular p;
        if (validarCodCertificado()){
            p=Datos.buscarCelular(getApplicationContext(),cajaCodCertificado.getText().toString());
            if (p!=null){

                cajaCodCertificado.setText(p.getCodCertificado());
                cajaNombre.setText(p.getNombre());
                cajaMarca.setText(p.getMarca());
                cajaColor.setText(p.getColor());

            }
        }
    }

    public void onBackPressed(){
        finish();
        Intent i = new Intent(AgregarCelular.this,Principal.class);
        startActivity(i);
    }
}
