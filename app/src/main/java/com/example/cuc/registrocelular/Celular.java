package com.example.cuc.registrocelular;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by CUC on 3/06/2017.
 */

public class Celular {
    private String codCertificado;
    private String foto;
    private String nombre;
    private String marca;
    private String color;

    public Celular(String codigoCertificado, String foto, String nombre, String marca, String color) {
        this.codCertificado = codigoCertificado;
        this.foto = foto;
        this.nombre = nombre;
        this.marca = marca;
        this.color = color;
    }

    public Celular(String codigoCertificado, String nombre, String marca, String color) {
        this.codCertificado = codigoCertificado;
        this.nombre = nombre;
        this.marca = marca;
        this.color = color;
    }

    public String getCodCertificado() {
        return codCertificado;
    }

    public void setCodCertificado(String codigoCertificado) {
        this.codCertificado = codigoCertificado;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void guardar(Context contexto){
        //Declarar variables
        SQLiteDatabase db;
        String sql;

        //Abrir conexion base de datos en escritura
        CelularesSQLiteOpenHelper aux = new CelularesSQLiteOpenHelper(contexto,"DBCelulares",null);
        db=aux.getWritableDatabase();

        //Insertar forma 1
        sql="INSERT INTO Personas values('"
                +this.getCodCertificado()+"','"
                +this.getFoto()+"','"
                +this.getNombre()+"','"
                +this.getMarca()+"','"
                +this.getColor()+"')";

        db.execSQL(sql);

        //Insertar forma 2
        /*ContentValues nuevoRegistro = new ContentValues();
        nuevoRegistro.put("foto",this.getFoto());
        nuevoRegistro.put("cedula",this.getCedula());
        nuevoRegistro.put("nombre",this.getNombre());
        nuevoRegistro.put("apellido",this.getApellido());
        nuevoRegistro.put("sexo",this.getSexo());
        nuevoRegistro.put("pasatiempo",this.getPasatiempo());

        db.insert("Personas",null,nuevoRegistro);*/

        //cerrar conexion
        db.close();
    }
}
