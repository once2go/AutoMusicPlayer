package once2go.com.musicplayer.utill;

import android.net.Uri;
import android.os.Environment;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

import once2go.com.musicplayer.model.Mp3File;

/**
 * Created by once2go on 27.02.16.
 */
public class ScanHelper {

    private static final String MP3_EXTENSION = ".mp3";

    public static List<Mp3File> getMp3Files() {
        List<Mp3File> files = new ArrayList();
        File dir = Environment.getExternalStorageDirectory();
        addFilesToList(files, dir);
        for (File childDir: dir.listFiles()) {
            if (childDir.isDirectory()) {
                addFilesToList(files, childDir);
            }
        }

        return files;
    }

    private static void addFilesToList(List<Mp3File> files, File dir) {
        for (File file : scanFilesInDirectory(dir)) {
            files.add(new Mp3File(file.getName(), convertStringToUri(file.getAbsolutePath())));
        }
    }

    private static Uri convertStringToUri(String path) {
        return Uri.parse(path);
    }

    private static File[] scanFilesInDirectory(File dir) {
        return dir.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return (name.endsWith(MP3_EXTENSION));
            }
        });
    }


}
