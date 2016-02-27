package once2go.com.musicplayer.adapters;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


import java.util.List;

import once2go.com.musicplayer.utill.Validator;

/**
 * Created by once2go on 27.02.16.
 */
public class DataPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> mFragments;

    public DataPagerAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        Validator.validateArgument(fm, "Fragment manager can't be null");
        mFragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }
}
