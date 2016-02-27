package once2go.com.musicplayer;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import once2go.com.musicplayer.model.MediaPlayerSettings;

public class PlayerService extends Service {
    private static final String LOG_TAG = PlayerService.class.getSimpleName();
    private MediaPlayer mMediaPlayer;
    private PlayerServiceBinder playerServiceBinder;

    public PlayerService() {

    }

    public void onCreate() {
        super.onCreate();
        mMediaPlayer =new MediaPlayer();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return playerServiceBinder;
    }


    class PlayerServiceBinder extends Binder {
        PlayerService getService() {
            return PlayerService.this;
        }
    }

    void play () {
        Log.e(LOG_TAG, "play");
    }

    void pause () {
        Log.e(LOG_TAG, "pause");
    }

    void next () {
        Log.e(LOG_TAG, "next");
    }

    void previous () {
        Log.e(LOG_TAG, "next");
    }
}
