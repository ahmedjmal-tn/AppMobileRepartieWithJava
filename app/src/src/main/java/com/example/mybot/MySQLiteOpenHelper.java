package com.example.mybot;

import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import androidx.annotation.Nullable;
/**
 * Implémente des méthode abstract de SQLiteOpenHelper
 */
public class MySQLiteOpenHelper extends SQLiteOpenHelper
{
    //propriètés
    private String creation = "create table messages ("
            + "msgDate TEXT PRIMARY KEY,"
            + "msgServer TEXT NOT NULL,"
            + "msgClient TEXT NOT NULL )";
    /**
     * @param context
     * @param name
     * @param factory
     * @param version
     */
    public MySQLiteOpenHelper(@Nullable Context context, @Nullable String
            name, @Nullable SQLiteDatabase.CursorFactory factory, int version)
    {
        super(context, name, factory, version);
    }
    /**
     * Si changement de la BD
     * @param sqLiteDatabase
     */
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {
        sqLiteDatabase.execSQL(creation);
    }
    /**
     * SI changement de la version
     * @param sqLiteDatabase
     * @param i // pour l'ancien version
     * @param i1 // la nouvelle version
     */
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }

}
