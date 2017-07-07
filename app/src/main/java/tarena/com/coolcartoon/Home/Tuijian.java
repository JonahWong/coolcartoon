package tarena.com.coolcartoon.Home;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.circlenavigator.CircleNavigator;

import java.util.ArrayList;

import tarena.com.coolcartoon.R;

/**
 * Created by tarena on 2017/7/5.
 */

public class Tuijian extends Fragment {
    private ViewPager TuiJian_ViewPager;
    ArrayList<View> list = new ArrayList<>();
    private RecyclerView ShaoNian_RecycleView;
    private RecyclerView Tuijian_RecyclerView;
    private RecyclerView QingNian_RecycleView;
    private RecyclerView ShaoNv_RecycleView;
    private RecyclerView DanMei_RecycleView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       // ZuiFan_Fragment_RecyclerView =getView().findViewById(R.id.ZuiFan_Fragment_RecyclerView);


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        GridLayoutManager grid = new GridLayoutManager(getActivity(), 2);
        ShaoNianRecycleViewAdapter shaoNianRecycleViewAdapteradapter=new ShaoNianRecycleViewAdapter(getActivity());
        ShaoNian_RecycleView.setAdapter(shaoNianRecycleViewAdapteradapter);
        ShaoNian_RecycleView.setLayoutManager(grid);

        ShaoNvRecycleViewAdapter shaoNvRecycleViewAdapteradapter=new ShaoNvRecycleViewAdapter(getActivity());
        GridLayoutManager ShaoNvgrid = new GridLayoutManager(getActivity(), 3);
        ShaoNv_RecycleView.setAdapter(shaoNvRecycleViewAdapteradapter);
        ShaoNv_RecycleView.setLayoutManager(ShaoNvgrid);

        QingNianRecycleViewAdapter qingNianRecycleViewAdapter=new QingNianRecycleViewAdapter(getActivity());
        GridLayoutManager qingNiangrid = new GridLayoutManager(getActivity(), 3);
        QingNian_RecycleView.setAdapter(qingNianRecycleViewAdapter);
        QingNian_RecycleView.setLayoutManager(qingNiangrid);

        DanMeiRecycleViewAdapter danMeiRecycleViewAdapter=new DanMeiRecycleViewAdapter(getActivity());
        GridLayoutManager danmeigrid = new GridLayoutManager(getActivity(), 3);
        DanMei_RecycleView.setAdapter(danMeiRecycleViewAdapter);
        DanMei_RecycleView.setLayoutManager(danmeigrid);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=  inflater.inflate(R.layout.fragment_tui_jian, container, false);
        View item1 = inflater.inflate(R.layout.tuijian_viewpager_item1, null);
        View item2 = inflater.inflate(R.layout.tuijian_viewpager_item2, null);
        View item3 = inflater.inflate(R.layout.tuijian_viewpager_item3, null);
        View item4 = inflater.inflate(R.layout.tuijian_viewpager_item4, null);
        list.add(item1);
        list.add(item2);
        list.add(item3);
        list.add(item4);

        TuiJian_ViewPager=view.findViewById(R.id.TuiJian_ViewPager);
        TuiJian_ViewPager.setAdapter(new TuiJianViewPagerAdapter(list));
        ShaoNian_RecycleView=view.findViewById(R.id.ShaoNian_RecycleView);
        ShaoNv_RecycleView=view.findViewById(R.id.ShaoNv_RecycleView);
        QingNian_RecycleView=view.findViewById(R.id.QingNian_RecycleView);
        DanMei_RecycleView=view.findViewById(R.id.DanMei_RecycleView);

        initMagicIndicator1(view);
        return view;
    }
    private void initMagicIndicator1(View view) {
        MagicIndicator magicIndicator = view.findViewById(R.id.Tuijian_magic_indicator);
        CircleNavigator circleNavigator = new CircleNavigator(view.getContext());
        circleNavigator.setCircleCount(list.size());
        circleNavigator.setCircleColor(Color.RED);
        circleNavigator.setCircleClickListener(new CircleNavigator.OnCircleClickListener() {
            @Override
            public void onClick(int index) {
                TuiJian_ViewPager.setCurrentItem(index);
            }
        });
        magicIndicator.setNavigator(circleNavigator);
        ViewPagerHelper.bind(magicIndicator, TuiJian_ViewPager);
    }
}
