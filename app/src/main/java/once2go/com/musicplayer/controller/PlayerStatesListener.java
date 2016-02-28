package once2go.com.musicplayer.controller;

/**
 * Created by once2go on 28.02.16.
 */
public interface PlayerStatesListener {

    void onPlayerReady();

    void onPlayerScan();

    void onPlay(boolean isPlay);
}
