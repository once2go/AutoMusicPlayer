package once2go.com.musicplayer.controller;

import android.net.Uri;

/**
 * Created by once2go on 27.02.16.
 */
public interface ControlsActionListener {

    void onPlay();

    void onPlay(String path);

    void onPause();

    void onNext();

    void onPrevious();

}
