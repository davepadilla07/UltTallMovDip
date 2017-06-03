package com.example.cuc.registrocelular;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by CUC on 3/06/2017.
 */

public class Celular {
    private String codcertificado;
    private String foto;
    private String nombre;
    private String marca;
    private String color;

    public Celular(String codigoCertificado, String foto, String nombre, String marca, String color) {
        this.codcertificado = codigoCertificado;
        this.foto = foto;
        this.nombre = nombre;
        this.marca = marca;
        this.color = color;
    }

    public Celular(String foto, String nombre, String marca, String color) {
        this.foto = foto;
        this.nombre = nombre;
        this.marca = marca;
        this.color = color;
    }

    public String getCodCertificado() {
        return codcertificado;
    }

    public void setCodcertificado(String codigoCertificado) {
        this.codcertificado = codigoCertificado;
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

        SQLiteDatabase db;
        String sql;

        CelularesSQLiteOpenHelper aux = new CelularesSQLiteOpenHelper(contexto,"DBCelulares",null);
        db=aux.getWritableDatabase();

        sql="INSERT INTO Celulares values('"
                +this.getCodCertificado()+"','"
                +this.getFoto()+"','"
                +this.getNombre()+"','"
                +this.getMarca()+"','"
                +this.getColor()+"')";

        db.execSQL(sql);
        db.close();
    }

    public void eliminar(Context contexto){

        SQLiteDatabase db;
        String sql;

        CelularesSQLiteOpenHelper aux = new CelularesSQLiteOpenHelper(contexto,"DBCelulares",null);
        db = aux.getWritableDatabase();

        sql = "DELETE FROM Celulares where cedula='"+this.getCodCertificado()+"'";
        db.execSQL(sql);
        db.close();

    }

    public void modificar(Context contexto){

        SQLiteDatabase db;
        String sql;

        CelularesSQLiteOpenHelper aux = new CelularesSQLiteOpenHelper(contexto,"DBCelulares",null);
        db = aux.getWritableDatabase();

        sql = "UPDATE Celulares SET nombre='"+this.getNombre()+"', marca='"+this.getMarca()+"', color='"+this.getColor()+"' where codcertificado ='"+this.getCodCertificado()+"'";

        db.execSQL(sql);

        db.close();

    }

}
