package once2go.com.musicplayer;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import java.io.IOException;

public class PlayerService extends Service {
    private static final String LOG_TAG = PlayerService.class.getSimpleName();
    private MediaPlayer mMediaPlayer;
    private PlayerServiceBinder playerServiceBinder = new PlayerServiceBinder();
    public PlayerService() {

    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return playerServiceBinder;
    }


    public class PlayerServiceBinder extends Binder {
       public PlayerService getService() {
            return PlayerService.this;
        }
    }

    public void play () {
        Log.e(LOG_TAG, "onPlay");
    }

    public void testPlay(String path) {
        if(mMediaPlayer == null) {
            mMediaPlayer = new MediaPlayer();
        }
        if (mMediaPlayer.isPlaying()) {
            mMediaPlayer.stop();
        }
        mMediaPlayer.reset();
        try {
            mMediaPlayer.setDataSource(path.toString());
            mMediaPlayer.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
        mMediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.start();
            }
        });

    }
}
