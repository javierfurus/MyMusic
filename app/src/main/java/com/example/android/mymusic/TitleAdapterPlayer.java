package com.example.android.mymusic;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class TitleAdapterPlayer extends ArrayAdapter<Word> {

    TitleAdapterPlayer(Activity context, ArrayList<Word> words) {
        super(context, 0, words);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listViewItem = convertView;

        if (listViewItem == null) {
            listViewItem = LayoutInflater.from(getContext()).inflate(
                    R.layout.player_list_item, parent, false
            );
        }
        Word currentWord = getItem(position);

        //get miwok word
        TextView songtitle = listViewItem.findViewById(R.id.title_textview);
        songtitle.setText(currentWord.getTitle());

        //get default translation word
        TextView artist = listViewItem.findViewById(R.id.artist_text_view);
        artist.setText(currentWord.getArtist());

        //get albumart
        ImageView albumart = listViewItem.findViewById(R.id.album_art);
        albumart.setImageResource(currentWord.getAlbumArt());


        return listViewItem;
    }

}
