package tarena.com.coolcartoon.Home;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tarena on 2017/7/5.
 */

public class FragmentViewPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> mList = new ArrayList<Fragment>();

    public FragmentViewPagerAdapter(FragmentManager fm , List<Fragment> list) {
        super(fm);
        this.mList = list;
    }

    @Override
    public Fragment getItem(int position) {
        return mList.get(position);
    }

    @Override
    public int getCount() {
        return  mList != null ? mList.size() : 0;
    }
}
