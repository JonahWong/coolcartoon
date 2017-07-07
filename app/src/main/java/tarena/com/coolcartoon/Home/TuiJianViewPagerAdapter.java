package tarena.com.coolcartoon.Home;

import android.support.v4.app.FragmentManager;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tarena on 2017/7/5.
 */

public class TuiJianViewPagerAdapter extends PagerAdapter {

    private List<View> mList = new ArrayList<>();

    public TuiJianViewPagerAdapter(List<View> list) {

        this.mList = list;
    }
    @Override
    public int getCount() {
        return  mList != null ? mList.size() : 0;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        // TODO Auto-generated method stub
        container.removeView(mList.get(position));
    }
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        // TODO Auto-generated method stub
        container.addView(mList.get(position));


        return mList.get(position);
    }
}

