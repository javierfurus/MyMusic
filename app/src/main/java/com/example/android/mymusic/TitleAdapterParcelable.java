package com.example.android.mymusic;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class TitleAdapterParcelable extends ArrayAdapter<MyParcelable> {

    TitleAdapterParcelable(Activity context, ArrayList<MyParcelable> song) {
        super(context, 0, song);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listViewItem = convertView;
        if (listViewItem == null) {
            listViewItem = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false
            );
        }
        MyParcelable currentWord=getItem(position);

        //get miwok word
        TextView songtitle = (TextView) listViewItem.findViewById(R.id.title_textview);
        songtitle.setText(currentWord.getTitle());

        //get default translation word
        TextView artist = (TextView) listViewItem.findViewById(R.id.artist_text_view);
        artist.setText(currentWord.getArtist());

        //get albumart
        ImageView albumart = (ImageView) listViewItem.findViewById(R.id.album_art);
        albumart.setImageResource(currentWord.getAlbumArt());

        return listViewItem;
    }

}
