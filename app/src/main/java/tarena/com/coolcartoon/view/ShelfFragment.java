package tarena.com.coolcartoon.view;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.UIUtil;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ClipPagerTitleView;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;
import tarena.com.coolcartoon.R;
import tarena.com.coolcartoon.Shelf.HistoryFragment;
import tarena.com.coolcartoon.Shelf.LocalFragment;
import tarena.com.coolcartoon.Shelf.ShelfPagerAdapter;
import tarena.com.coolcartoon.Shelf.SubscribeFragment;
import tarena.com.coolcartoon.biz.CoolCartoonApi;
import tarena.com.coolcartoon.view.interfaces.ShelfView;


/**
 *  书橱界面
 *  Created by jonah on 03/07/2017.
 */

public class ShelfFragment extends Fragment implements ShelfView {
    private static final String[] CHANNELS = new String[]{"历史", "订阅", "缓存"};
    private List<String> mDataList = Arrays.asList(CHANNELS);

    //请求数据调用接口
    @Inject
    CoolCartoonApi coolCartoonApi;
    private View view;
    private ViewPager mViewPager;
    private Fragment[] fragments = new Fragment[3];
    private ShelfPagerAdapter shelfPagerAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidSupportInjection.inject(this);
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_shelf,null);
        initView();
        initMagicIndicator3();
        return view;
    }
    private void initView() {
        mViewPager = view.findViewById(R.id.vp_shelffragment);
        fragments[0] = new HistoryFragment();
        fragments[1] = new SubscribeFragment();
        fragments[2] = new LocalFragment();
        shelfPagerAdapter = new ShelfPagerAdapter(fragments);
        mViewPager.setAdapter(shelfPagerAdapter);
    }
    private void initMagicIndicator3() {
        MagicIndicator magicIndicator = (MagicIndicator) view.findViewById(R.id.magic_indicator3);
        magicIndicator.setBackgroundResource(R.drawable.round_indicator_bg);
        CommonNavigator commonNavigator = new CommonNavigator(getContext());
        commonNavigator.setAdapter(new CommonNavigatorAdapter() {
            @Override
            public int getCount() {
                return mDataList == null ? 0 : mDataList.size();
            }

            @Override
            public IPagerTitleView getTitleView(Context context, final int index) {
                ClipPagerTitleView clipPagerTitleView = new ClipPagerTitleView(context);
                clipPagerTitleView.setText(mDataList.get(index));
                clipPagerTitleView.setTextColor(Color.parseColor("#e94220"));
                clipPagerTitleView.setClipColor(Color.WHITE);
                clipPagerTitleView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mViewPager.setCurrentItem(index);
                    }
                });
                return clipPagerTitleView;
            }
            @Override
            public IPagerIndicator getIndicator(Context context) {
                LinePagerIndicator indicator = new LinePagerIndicator(context);
                float navigatorHeight = context.getResources().getDimension(R.dimen.common_navigator_height);
                float borderWidth = UIUtil.dip2px(context, 1);
                float lineHeight = navigatorHeight - 2 * borderWidth;
                indicator.setLineHeight(lineHeight);
                indicator.setRoundRadius(lineHeight / 2);
                indicator.setYOffset(borderWidth);
                indicator.setColors(Color.parseColor("#bc2a2a"));
                return indicator;
            }
        });
        magicIndicator.setNavigator(commonNavigator);
        ViewPagerHelper.bind(magicIndicator, mViewPager);
    }
}
