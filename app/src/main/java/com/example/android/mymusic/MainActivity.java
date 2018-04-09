package com.example.android.mymusic;

import android.annotation.SuppressLint;
import android.app.ListActivity;
import android.content.Intent;
import android.hardware.Sensor;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Create an ArrayList of words
        Word song1 = new Word("Slowmotion", "Bensound", R.drawable.slowmotion);
        Word song2 = new Word ("Funnysong", "Bensound", R.drawable.funnysong);
        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(song1);
        words.add(song2);


        TitleAdapter adapter =
                new TitleAdapter(this, words);

        final ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapter, View v, int position,
                                    long arg3)
            {
                Word currentWord=getItem(position);
                Intent playerIntent = new Intent (MainActivity.this, PlayerActivity.class);
                playerIntent.putExtra("position", (Parcelable) currentWord);
                startActivity(playerIntent);

            }

                private Word getItem(int position) {
                    return words.get(position);
                }
        });
    }


}
