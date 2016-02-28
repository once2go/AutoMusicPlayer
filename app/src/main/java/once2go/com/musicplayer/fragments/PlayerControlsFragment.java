package once2go.com.musicplayer.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import once2go.com.musicplayer.MusicPlayerApplication;
import once2go.com.musicplayer.R;
import once2go.com.musicplayer.controller.ControlsActionListener;

/**
 * Created by once2go on 27.02.16.
 */
public class PlayerControlsFragment extends Fragment implements View.OnClickListener {

    private ControlsActionListener uiActionsListener;

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
        final View v = inflater.inflate(R.layout.player_controls_view, container, false);
        v.findViewById(R.id.control_panel_next).setOnClickListener(this);
        v.findViewById(R.id.control_panel_play).setOnClickListener(this);
        v.findViewById(R.id.control_panel_prev).setOnClickListener(this);
        uiActionsListener = MusicPlayerApplication.getInstance().getPlayerController().getUiActionsListener();
        return v;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.control_panel_next:
                uiActionsListener.onNext();
                break;
            case R.id.control_panel_play:
                uiActionsListener.onPlay();
                break;
            case R.id.control_panel_prev:
                uiActionsListener.onPrevious();
                break;
        }
    }
}
