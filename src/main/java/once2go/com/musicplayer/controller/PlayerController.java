package once2go.com.musicplayer.controller;

import android.net.Uri;
import android.util.Log;

/**
 * Created by once2go on 27.02.16.
 */
public class PlayerController implements UIActionsListener{

    private static final String LOG_TAG = PlayerController.class.getSimpleName();
    private UIActionsListener uiActionsListener;

    public PlayerController() {
        uiActionsListener = this;
    }

    @Override
    public void play() {
        Log.e(LOG_TAG, "play");
    }

    @Override
    public void play(Uri path) {

    }

    @Override
    public void pause() {
        Log.e(LOG_TAG, "play");
    }

    @Override
    public void next() {
        Log.e(LOG_TAG, "next");
    }

    @Override
    public void previous() {
        Log.e(LOG_TAG, "previous");
    }

    public UIActionsListener getUiActionsListener() {
        return uiActionsListener;
    }

}
