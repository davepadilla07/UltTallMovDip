package com.example.cuc.registrocelular;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class Principal extends AppCompatActivity implements AdaptadorCelular.OnCelularClickListener {
    private RecyclerView listado;
    private ArrayList<Celular> celulares;
    private AdaptadorCelular adapter;
    private LinearLayoutManager llm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        listado=(RecyclerView)findViewById(R.id.lstOpciones);

        celulares= Datos.traerCelulares(getApplicationContext());
        adapter= new AdaptadorCelular(celulares,this);

        llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listado.setLayoutManager(llm);
        listado.setAdapter(adapter);
    }

    public void agregar(View v){
        finish();
        Intent i = new Intent(Principal.this, AgregarCelular.class);
        startActivity(i);
    }

    @Override
    public void onCelularClick(Celular p) {

        Intent i = new Intent(Principal.this,DetalleCelular.class);
        Bundle b = new Bundle();
        b.putString("codcertificado",p.getCodCertificado());
        b.putString("nombre",p.getNombre());
        b.putString("marca",p.getMarca());
        b.putString("color",p.getColor());

        i.putExtra("datos",b);
        startActivity(i);

    }
}
