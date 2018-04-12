package com.example.android.mymusic;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Create an ArrayList of words
        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("Slowmotion", "Bensound", R.drawable.slowmotion, "4:30"));
        words.add(new Word("Funnysong", "Bensound", R.drawable.funnysong, "5:00"));
        words.add(new Word("A New Beginning", "Bensound", R.drawable.anewbeginning, "3:30"));
        words.add(new Word("Memories", "Bensound", R.drawable.memories, "4:30"));
        words.add(new Word("Little Idea", "Bensound", R.drawable.littleidea, "2:30"));
        words.add(new Word("Ukulele", "Bensound", R.drawable.ukulele, "6:25"));


        TitleAdapter adapter =
                new TitleAdapter(this, words);

        final ListView listView = findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View v, int position,
                                    long arg3) {
                Word currentWord = getItem(position);
                Intent playerIntent = new Intent(MainActivity.this, PlayerActivity.class);
                playerIntent.putExtra("position", (Parcelable) currentWord);
                startActivity(playerIntent);

            }

            private Word getItem(int position) {
                return words.get(position);
            }
        });
    }


}
