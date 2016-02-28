package once2go.com.musicplayer.utill;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaMetadataRetriever;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import once2go.com.musicplayer.model.Mp3File;
import once2go.com.musicplayer.model.Mp3Metadata;

/**
 * Created by once2go on 28.02.16.
 */
public class MetadataRetrieverHelper {

    public static List<Mp3File> prepareFilesForShowing(List<Mp3File> files) {
        List<Mp3File> newList = new ArrayList<>();
        for (Mp3File mp3file : files) {
            String filePath = mp3file.getFilePath();
            MediaMetadataRetriever mmr = new MediaMetadataRetriever();
            try {
                mmr.setDataSource(filePath);
            } catch (RuntimeException e) {
                break;
            }
            Mp3Metadata data = new Mp3Metadata(getTitle(mmr), getArtist(mmr), getDuration(mmr), getEmpeddedPicure(mmr), getMetadata(mmr));
            mp3file.setMp3Metadata(data);
            newList.add(mp3file);
        }
        return newList;
    }


    private static Bitmap getEmpeddedPicure(MediaMetadataRetriever mmr) {
        byte[] artBytes = mmr.getEmbeddedPicture();
        if (artBytes != null && artBytes.length > 0) {
            return BitmapFactory.decodeByteArray(artBytes, 0, artBytes.length);
        } else {
            return null;
        }
    }

    private static String getArtist(MediaMetadataRetriever mmr) {
        return mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ARTIST);
    }

    private static String getTitle(MediaMetadataRetriever mmr) {
        return mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_TITLE);
    }

    private static String getMetadata(MediaMetadataRetriever mmr) {
        int bitrate = Integer.parseInt(mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_BITRATE));
        return String.format("%d kb/s", bitrate / 1000);
    }


    private static String getDuration(MediaMetadataRetriever mmr) {
        int duration = Integer.parseInt(mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION));
        long min = TimeUnit.MILLISECONDS.toMinutes(duration);
        long sec = TimeUnit.MILLISECONDS.toSeconds(duration) - TimeUnit.MINUTES.toSeconds(min);
        return String.format("%02d:%02d", min, sec);
    }

}
