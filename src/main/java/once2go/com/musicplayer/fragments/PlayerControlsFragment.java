package once2go.com.musicplayer.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import once2go.com.musicplayer.R;

/**
 * Created by once2go on 27.02.16.
 */
public class PlayerControlsFragment extends Fragment{

    public static PlayerControlsFragment getInstance() {
        PlayerControlsFragment fragment = new PlayerControlsFragment();
        final Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.random_play_list_layout, container, false);


        return v;
    }

}
