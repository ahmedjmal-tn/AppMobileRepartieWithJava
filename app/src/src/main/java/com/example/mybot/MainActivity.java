package com.example.mybot;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import com.example.mybot.Controler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    int x=0;
    private Controler homeController;
    private EditText txtServer;
    private EditText txtClient;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final MediaPlayer player=MediaPlayer.create(this,R.raw.backgroundsound); //to play music in background
        player.setLooping(true);
        player.start();
        Button b1;
        Button b2;
        this.homeController = Controler.getInstance(this);
        final ImageButton mute;
        b1=findViewById(R.id.server);
        b2=findViewById(R.id.client);
        mute=findViewById(R.id.mute); //to mute background music
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(MainActivity.this,ServerActivity.class); //to call new activity
                startActivity(intent1);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2=new Intent(MainActivity.this,ClientActivity.class); //to call new activity
                startActivity(intent2);
            }
        });
        mute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                if(x==0) {
                    player.pause();

                    mute.setImageResource(R.drawable.play); //to set background image

                    x=1;
                }
                else
                {
                    player.start();

                    x=0;
                    mute.setImageResource(R.drawable.mute);
                }

            }
        });


    }
    /**
     * récupération des noms de joueurs s'ils étaient sérialisés
     */
    private void recupMsg(){
        if(homeController.getMsgServer()!= null){
            txtClient.setText(homeController.getMsgCLient());
            txtServer.setText(homeController.getMsgServer());
        }
    }

    private void savePlayers(String name1, String name2) {
        this.homeController.createMsg(name1,name2,this);
    }
}