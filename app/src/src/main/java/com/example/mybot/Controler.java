package com.example.mybot;

import android.content.Context;
import com.example.mybot.AccesLocal;
import com.example.mybot.Message;
import com.example.mybot.Serializer;
import java.util.Date;

public final class Controler {
    private static Controler instance = null;
    private static Message msg;
    //Nom du fichier
    private static String nonFichier = "saveMsg";
    private static AccesLocal accesLocal;

    private Controler() {
        super();
    }

    public static final Controler getInstance(Context context) {
        if (Controler.instance == null) {
            Controler.instance = new Controler();
            accesLocal = new AccesLocal(context);
            //récuper
            msg = accesLocal.recupDernier();
        }
        return Controler.instance;
    }

    public void createMsg(String msgServer, String msgClient,
                              Context context) {
        msg = new Message(new Date(), msgServer, msgClient);
        //Serializer.serialize(nonFichier, players, context);
        accesLocal.ajout(msg);
    }

    /**
     * Récuparation de l'objet sérailiser càd messages
     *
     * @param context
     */
    private static void recupeSerialize(Context context) {
        msg = (Message) Serializer.deSerialize(nonFichier, context);
    }

    public String getMsgServer() {
        if (msg == null) return null;
        return msg.getMsgServer();
    }

    public String getMsgCLient() {
        if (msg == null) return null;
        return msg.getMsgClient();
    }

}
