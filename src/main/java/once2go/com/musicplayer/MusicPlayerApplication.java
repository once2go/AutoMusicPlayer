package once2go.com.musicplayer;

import android.app.Application;

import once2go.com.musicplayer.controller.PlayerController;

/**
 * Created by once2go on 27.02.16.
 */
public class MusicPlayerApplication extends Application {

    private static MusicPlayerApplication sInstance;

    private PlayerController mPlayerController;

    {
        sInstance = this;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mPlayerController = new PlayerController();
    }

    public static MusicPlayerApplication getInstance() {
        return sInstance;
    }

    public PlayerController getPlayerController() {
        return mPlayerController;
    }
}
