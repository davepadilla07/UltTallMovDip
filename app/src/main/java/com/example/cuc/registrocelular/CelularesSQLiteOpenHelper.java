package com.example.cuc.registrocelular;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by CUC on 3/06/2017.
 */

public class CelularesSQLiteOpenHelper extends SQLiteOpenHelper {
    private String sql="CREATE TABLE Celulares(codcertificado text, foto text, nombre text, marca text, color text)";
    static int version=2;

    public CelularesSQLiteOpenHelper(Context contexto, String name, SQLiteDatabase.CursorFactory factory){
        super(contexto,name,factory,version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Celulares");
        db.execSQL(sql);
    }
}
