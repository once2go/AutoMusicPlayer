package once2go.com.musicplayer.model;


/**
 * Created by once2go on 27.02.16.
 */
public class Mp3File {

    private String mFileName;
    private String mFilePath;
    private Mp3Metadata mMp3Metadata;

    public Mp3File(String fileName, String filePath) {
        mFileName = fileName;
        mFilePath = filePath;
    }

    public void setMp3Metadata(Mp3Metadata mp3Metadata) {
        mMp3Metadata = mp3Metadata;
    }

    public Mp3Metadata getMp3Metadata() {
        return mMp3Metadata;
    }

    public String getFileName() {
        return mFileName;
    }

    public String getFilePath() {
        return mFilePath;
    }

    @Override
    public String toString() {
        return "Mp3File{" + "mFileName='" + mFileName + '\'' + ", mFilePath=" + mFilePath + '}';
    }
}
