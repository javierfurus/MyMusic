package com.example.android.mymusic;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by javier on 2018.03.23..
 */

public class Word extends ArrayList<Parcelable> implements Parcelable {
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
    private String mTitle;
    private String mArtist;
    private int mAlbumArt;
    private String mSongLength;

    public Word(String artist, String title, int albumArt, String songLength) {
        mTitle = title;
        mArtist = artist;
        mAlbumArt = albumArt;
        mSongLength = songLength;
    }

    protected Word(Parcel in) {
        mTitle = in.readString();
        mArtist = in.readString();
        mAlbumArt = in.readInt();
        mSongLength = in.readString();
    }

    public String getArtist() {
        return mTitle;
    }

    public String getTitle() {
        return mArtist;
    }

    public int getAlbumArt() {
        return mAlbumArt;
    }

    public String getSongLength() {
        return mSongLength;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mTitle);
        parcel.writeString(mArtist);
        parcel.writeInt(mAlbumArt);
        parcel.writeString(mSongLength);
    }
}
