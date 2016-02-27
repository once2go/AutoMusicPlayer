package once2go.com.musicplayer.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import once2go.com.musicplayer.R;
import once2go.com.musicplayer.adapters.PlayListAdapter;
import once2go.com.musicplayer.utill.ScanHelper;

/**
 * Created by once2go on 27.02.16.
 */
public class RandomPlayListFragment extends Fragment {

    public static RandomPlayListFragment getInstance() {
        RandomPlayListFragment fragment = new RandomPlayListFragment();
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
        RecyclerView recyclerView = (RecyclerView)v.findViewById(R.id.play_list_recycle_view);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        PlayListAdapter playListAdapter = new PlayListAdapter(ScanHelper.getMp3Files());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(llm);
        recyclerView.setAdapter(playListAdapter);

        return v;
    }

}
