package com.example.cuc.registrocelular;

import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

public class DetalleCelular extends AppCompatActivity {
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private Celular p;
    private String codCertificado,nombre,marca,color;
    private Bundle b;
    private Intent i;
    private ImageView foto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_celular);

        Toolbar toolbar= (Toolbar)findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        i = getIntent();
        b=i.getBundleExtra("datos");
        codCertificado= b.getString("codcertificado");
        nombre = b.getString("nombre");
        marca = b.getString("marca");
        color = b.getString("color");

        collapsingToolbarLayout = (CollapsingToolbarLayout)findViewById(R.id.collapsing_toolbar);
        foto = (ImageView)findViewById(R.id.fotoCelular);

        collapsingToolbarLayout.setTitle(codCertificado+" "+nombre);

    }
}
