package once2go.com.musicplayer;

import android.app.Application;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;

import once2go.com.musicplayer.controller.PlayerController;

/**
 * Created by once2go on 27.02.16.
 */
public class MusicPlayerApplication extends Application {

    private static final String LOG_TAG = MusicPlayerApplication.class.getSimpleName();
    private static MusicPlayerApplication sInstance;

    private PlayerController mPlayerController;

    {
        sInstance = this;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mPlayerController = new PlayerController();
        bindToService();
    }

    public static MusicPlayerApplication getInstance() {
        return sInstance;
    }

    public PlayerController getPlayerController() {
        return mPlayerController;
    }

    private void bindToService () {
        Intent mServiceIntent = new Intent(this, PlayerService.class);
        ServiceConnection mServiceConnection = new ServiceConnection() {
            public void onServiceConnected(ComponentName name, IBinder binder) {
                Log.e(LOG_TAG, "onServiceConnected | " + name);
                mPlayerController.setAvailablePlayerService(((PlayerService.PlayerServiceBinder) binder).getService());
            }

            public void onServiceDisconnected(ComponentName name) {
                Log.e(LOG_TAG, "onServiceDisconnected | " + name);
            }
        };

        startService(mServiceIntent);
        bindService(mServiceIntent, mServiceConnection, 0);
    }
}
