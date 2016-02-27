package once2go.com.musicplayer.model;

import android.net.Uri;

/**
 * Created by once2go on 27.02.16.
 */
public class Mp3File {

    private String mFileName;
    private Uri mFilePath;

    public Mp3File(String fileName, Uri filePath) {
        mFileName = fileName;
        mFilePath = filePath;
    }

    public String getFileName() {
        return mFileName;
    }

    public Uri getFilePath() {
        return mFilePath;
    }

    @Override
    public String toString() {
        return "Mp3File{" + "mFileName='" + mFileName + '\'' + ", mFilePath=" + mFilePath + '}';
    }
}
