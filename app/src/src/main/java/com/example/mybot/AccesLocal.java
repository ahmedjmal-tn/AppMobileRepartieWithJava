package com.example.mybot;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.example.mybot.MySQLiteOpenHelper;
import com.example.mybot.Message;
import java.util.Date;
public class AccesLocal {
    //propriétés
    private String baseName ="bdPlayersSQLite";
    private Integer baseVersion =1 ; // version de la BD
    private MySQLiteOpenHelper accesBD;
    private SQLiteDatabase db;
    private Message Message;

    /**
     * Constructeur
     * @param context
     */
    public AccesLocal(Context context){
        accesBD = new MySQLiteOpenHelper(context, baseName, null,
                baseVersion);
    }
    /**
     * Ajout de noms de joueurs (messages) dans la DB
     * @param msg
     */
    public void ajout (Message msg){
        db=accesBD.getWritableDatabase();
        String req="insert into messages (msgDate, msgServer, msgClient) values";
        req+="(\""+ msg.getMsgDate()+ "\",\"" +
                msg.getMsgServer()+ "\",\"" + msg.getMsgClient()+"\")";
        db.execSQL(req);
    }
    /**
     * Récupération du derniers noms de joueurs (players) de la DB
     */
    public Message recupDernier(){
        db = accesBD.getReadableDatabase();
        Message msg = null;
        String req = "select * from messages"; // récuppérer tous les messages
        Cursor curseur =db.rawQuery(req, null); // lire ligne par ligne
        curseur.moveToLast(); // se possitionner sur la dernière ligne du table messages
        if (!curseur.isAfterLast()) {
            String msgServer = curseur.getString(1); // playerName1 : i=1
            String msgClient = curseur.getString(2); // playerName2 : i=2
            Message=new Message(new Date(),msgServer,msgClient);
        }
        curseur.close();
        return msg;
    }
}
