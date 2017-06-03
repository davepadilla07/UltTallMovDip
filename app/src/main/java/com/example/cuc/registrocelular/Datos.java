package com.example.cuc.registrocelular;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by CUC on 3/06/2017.
 */

public class Datos {
    public static ArrayList<Celular> traerCelulares(Context contexto){

        ArrayList<Celular> celulares = new ArrayList<>();
        SQLiteDatabase db;
        String sql,codcertificado,foto,nombre,marca,color;
        Celular p;

        CelularesSQLiteOpenHelper aux = new CelularesSQLiteOpenHelper(contexto,"DBCelulares",null);
        db=aux.getReadableDatabase();

        sql="select * from Celulares";
        Cursor c=db.rawQuery(sql,null);

        if (c.moveToFirst()){
            do{

                codcertificado=c.getString(0);
                foto=c.getString(1);
                nombre=c.getString(2);
                marca=c.getString(3);
                color=c.getString(4);

                p=new Celular(codcertificado,foto,nombre,marca,color);
                celulares.add(p);

            }while(c.moveToNext());
        }

        db.close();

        return celulares;

    }

    public static Celular buscarCelular(Context contexto, String cod){
        //Declaro variables

        SQLiteDatabase db;
        String sql,codcertificado,foto,nombre,marca,color;
        Celular p=null;

        //Abrir conexion
        CelularesSQLiteOpenHelper aux = new CelularesSQLiteOpenHelper(contexto,"DBCelulares",null);
        db=aux.getReadableDatabase();

        //Cursor
        sql="select * from Celulares where codcertificado='"+cod+"'";
        Cursor c=db.rawQuery(sql,null);

        //Recorrido del cursor
        if (c.moveToFirst()){

            codcertificado=c.getString(0);
            foto=c.getString(1);
            nombre=c.getString(2);
            marca=c.getString(3);
            color=c.getString(4);

            p=new Celular(codcertificado,foto,nombre,marca,color);

        }

        db.close();

        return p;
    }
}
