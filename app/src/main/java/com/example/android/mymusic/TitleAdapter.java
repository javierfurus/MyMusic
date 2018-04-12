package com.example.android.mymusic;

import android.app.Activity;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class TitleAdapter extends ArrayAdapter<Word> {

    TitleAdapter (Activity context, ArrayList<Word> words) {
        super(context, 0, words);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listViewItem = convertView;
        if (listViewItem == null) {
            listViewItem = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false
            );
        }
        Word currentWord=getItem(position);

        //get music title
        TextView songtitle = (TextView) listViewItem.findViewById(R.id.title_textview);
        songtitle.setText(currentWord.getTitle());
        songtitle.setTypeface(null, Typeface.BOLD);

        //get the artist of the song
        TextView artist = (TextView) listViewItem.findViewById(R.id.artist_text_view);
        artist.setText(currentWord.getArtist());

        //get albumart
        ImageView albumart = (ImageView) listViewItem.findViewById(R.id.album_art);
        albumart.setImageResource(currentWord.getAlbumArt());

        return listViewItem;
    }

}
