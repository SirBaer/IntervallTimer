package com.timer.bko.intervalltimer.item;

import android.content.ContentUris;
import android.net.Uri;

/**
 * Created by bko on 21.05.2016.
 */
public class TrackItem {
    public final long id;
    public final String artist;
    public final String title;
    public final String album;
    public final int duration;

    public TrackItem(long id, String artist, String title, String album, int duration) {
        this.id = id;
        this.artist = artist;
        this.title = title;
        this.album = album;
        this.duration = duration;
    }

    @Override
    public String toString() {
        return title;
    }

    public Uri getURI() {
        return ContentUris.withAppendedId(
                android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, this.id);
    }
}
