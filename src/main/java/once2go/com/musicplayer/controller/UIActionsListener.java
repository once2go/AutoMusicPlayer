package once2go.com.musicplayer.controller;

import android.net.Uri;

/**
 * Created by once2go on 27.02.16.
 */
public interface UIActionsListener {

    void play();

    void play (Uri path);

    void pause ();

    void next ();

    void previous ();

}
