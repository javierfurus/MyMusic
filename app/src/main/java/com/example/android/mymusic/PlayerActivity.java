package com.example.android.mymusic;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class PlayerActivity extends AppCompatActivity { ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player_activity);
        Intent intent = getIntent();
        Word song = intent.getParcelableExtra("position");

        ArrayList<Word> selectedsong = new ArrayList<Word>();
        selectedsong.add(song);
        TitleAdapter adapter =
                new TitleAdapter (this,selectedsong);

        final ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);

    }
}