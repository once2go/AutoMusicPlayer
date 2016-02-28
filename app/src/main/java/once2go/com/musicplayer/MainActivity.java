package once2go.com.musicplayer;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import once2go.com.musicplayer.fragments.PlayerControlsFragment;
import once2go.com.musicplayer.fragments.PlayerDataFragment;

public class MainActivity extends FragmentActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      //  getSupportFragmentManager().beginTransaction().add(R.id.player_data, PlayerDataFragment.getInstance()).commit();
      //  getSupportFragmentManager().beginTransaction().add(R.id.player_controls, PlayerControlsFragment.getInstance()).commit();
    }


}
