package com.example.android.mymusic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;

public class PlayerActivity extends AppCompatActivity { ;
    boolean buttonIsClicked;
    ImageView playButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player_activity);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        LinearLayout view = findViewById(R.id.seekBarLinearLayout);
        TextView length = (TextView) view.findViewById(R.id.songend);
        playButton = (ImageView) findViewById(R.id.playButton);
        buttonIsClicked=false;
        Intent intent = getIntent();
        Word song = intent.getParcelableExtra("position");

        ArrayList<Word> selectedsong = new ArrayList<Word>();
        selectedsong.add(song);
        TitleAdapterPlayer adapter =
                new TitleAdapterPlayer (this,selectedsong);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);
        listView.setEnabled(false);


        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (buttonIsClicked==false){
                    playButton.setImageResource(R.drawable.ic_play_arrow);
                    buttonIsClicked=true;
                }
                else if (buttonIsClicked){
                    playButton.setImageResource(R.drawable.ic_pause);
                    buttonIsClicked=false;
                }
            }
        });

        length.setText(song.getSongLength().toString());

    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean("isPressed", buttonIsClicked);

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        buttonIsClicked=savedInstanceState.getBoolean("isPressed");
        if (buttonIsClicked){
            playButton.setImageResource(R.drawable.ic_pause);
        }

    }
}