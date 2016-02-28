package once2go.com.musicplayer.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import once2go.com.musicplayer.R;
import once2go.com.musicplayer.adapters.DataPagerAdapter;

/**
 * Created by once2go on 27.02.16.
 */

public class PlayerDataFragment extends Fragment {

    private ViewPager mViewPager;
    private DataPagerAdapter mDataPagerAdapter;
    private List<Fragment> dataFragmentsList;

    public static PlayerDataFragment getInstance() {
        PlayerDataFragment fragment = new PlayerDataFragment();
        final Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataFragmentsList = new ArrayList<>();
        dataFragmentsList.add(RandomPlayListFragment.getInstance());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.player_data_fragment_layout, container, false);
        mDataPagerAdapter = new DataPagerAdapter(getActivity().getSupportFragmentManager(), dataFragmentsList);
        mViewPager = (ViewPager) v.findViewById(R.id.data_view_pager);
        mViewPager.setAdapter(mDataPagerAdapter);
        return v;
    }
}
