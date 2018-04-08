package com.example.android.mymusic;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by javier on 2018.03.23..
 */

public class Word extends ArrayList<Parcelable> implements Parcelable {
    private String mArtist;
    private String mTitle;
    private int mAlbumArt;

    public Word (String artist, String title, int albumArt) {
        mArtist = artist;
        mTitle = title;
        mAlbumArt = albumArt;
    }

    protected Word(Parcel in) {
        mArtist = in.readString();
        mTitle = in.readString();
        mAlbumArt = in.readInt();
    }

    public static final Creator<Word> CREATOR = new Creator<Word>() {
        @Override
        public Word createFromParcel(Parcel in) {
            return new Word(in);
        }

        @Override
        public Word[] newArray(int size) {
            return new Word[size];
        }
    };

    public String getArtist(){
        return mArtist;
    }

    public String getTitle() {
        return mTitle;
    }

    public int getAlbumArt() {
        return mAlbumArt;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mArtist);
        parcel.writeString(mTitle);
        parcel.writeInt(mAlbumArt);
    }
}
