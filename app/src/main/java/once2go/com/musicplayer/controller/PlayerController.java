package once2go.com.musicplayer.controller;

import android.os.AsyncTask;
import android.util.Log;

import java.util.List;

import once2go.com.musicplayer.PlayerService;
import once2go.com.musicplayer.model.Mp3File;
import once2go.com.musicplayer.utill.MetadataRetrieverHelper;
import once2go.com.musicplayer.utill.ScanHelper;

/**
 * Created by once2go on 27.02.16.
 */
public class PlayerController implements ControlsActionListener {

    private static final String LOG_TAG = PlayerController.class.getSimpleName();
    private ControlsActionListener uiActionsListener;
    private PlayerService mPlayerService;
    private PlayerStatesListener mPlayerStatesListener;
    private List<Mp3File> mScannedList;
    private List<Mp3File> mFilesWithMetaData;

    public PlayerController() {
        uiActionsListener = this;
        scanFiles();
    }

    public void setAvailablePlayerService(PlayerService playerService) {
        mPlayerService = playerService;
    }

    @Override
    public void onPlay() {
        Log.e(LOG_TAG, "onPlay");
    }

    @Override
    public void onPlay(String path) {
        Log.e(LOG_TAG, "onPlay | " + path);
        mPlayerService.testPlay(path);
    }

    @Override
    public void onPause() {
        Log.e(LOG_TAG, "onPause");
    }

    @Override
    public void onNext() {
        Log.e(LOG_TAG, "onNext");
    }

    @Override
    public void onPrevious() {
        Log.e(LOG_TAG, "onPrevious");
    }

    public ControlsActionListener getUiActionsListener() {
        return uiActionsListener;
    }

    private void scanFiles() {
        new AsyncTask<Void, Void, List<Mp3File>>() {
            @Override
            protected List<Mp3File> doInBackground(Void... params) {
                return ScanHelper.getMp3Files();
            }

            @Override
            protected void onPostExecute(List<Mp3File> result) {
                super.onPostExecute(result);
                mScannedList = result;
                Log.e("test", result.size() + " scanFiles");
                obtainMetaData();
            }
        }.execute();
    }

    private void obtainMetaData() {
        new AsyncTask<Void, Void, List<Mp3File>>() {
            @Override
            protected List<Mp3File> doInBackground(Void... params) {
                return MetadataRetrieverHelper.prepareFilesForShowing(mScannedList);
            }

            @Override
            protected void onPostExecute(List<Mp3File> result) {
                super.onPostExecute(result);
                mFilesWithMetaData = result;
                Log.e("test", result.size() + " obtainMetaData");
            }
        }.execute();
    }

}
