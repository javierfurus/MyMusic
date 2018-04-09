package com.example.android.mymusic;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class MyParcelable implements Parcelable{
    private String mArtist;
    private String mTitle;
    private int mAlbumArt;

    public MyParcelable (String artist, String title, int albumArt) {
        mArtist = artist;
        mTitle = title;
        mAlbumArt = albumArt;
    }

    protected MyParcelable(Parcel in) {
        mArtist = in.readString();
        mTitle = in.readString();
        mAlbumArt = in.readInt();
    }

    public static final Creator<MyParcelable> CREATOR = new Creator<MyParcelable>() {
        @Override
        public MyParcelable createFromParcel (Parcel in) {
            return new MyParcelable (in);
        }

        @Override
        public MyParcelable[] newArray(int size) {
            return new MyParcelable[size];
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

