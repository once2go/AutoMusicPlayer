package once2go.com.musicplayer.model;

import android.graphics.Bitmap;

/**
 * Created by once2go on 28.02.16.
 */
public class Mp3Metadata {
    private String mDuration;
    private Bitmap mEmbededPic;
    private String mMetadata;
    private String mTitle;
    private String mArtist;

    public Mp3Metadata(String title, String artist, String duration, Bitmap embededPic, String metadata) {
        mDuration = duration;
        mEmbededPic = embededPic;
        mMetadata = metadata;
        mArtist = artist;
        mTitle = title;
    }

    public String getDuration() {
        return mDuration;
    }

    public Bitmap getEmbededPic() {
        return mEmbededPic;
    }

    public String getMetadata() {
        return mMetadata;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getArtist() {
        return mArtist;
    }
}
