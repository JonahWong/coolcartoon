package tarena.com.coolcartoon.Home;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import tarena.com.coolcartoon.R;
import tarena.com.coolcartoon.biz.CoolCartoonApi;
import tarena.com.coolcartoon.model.ResultEntity;

/**
 * Created by tarena on 2017/7/5.
 */

public class ZhuiFan extends Fragment implements ZhuiFanRecycleViewAdapter.OntoBookContentListener, SwipeRefreshLayout.OnRefreshListener {
    private RecyclerView ZuiFan_Fragment_RecyclerView;
    private ResultEntity mResultEntity;
    private ZhuiFanRecycleViewAdapter recyclerViewAdapter;
    private SwipeRefreshLayout srfLayout;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_zhui_fan,container,false);
        initialData();
        initialView(view);
        setView();
        addListener();
        return view;
    }

    /**
     * 通过persenter对象调用相对应的方法来初始化数据
     * 数据类型为ResultEntity
     */
    //TODO
    private void initialData() {

    }


    private void initialView(View view) {
        ZuiFan_Fragment_RecyclerView=view.findViewById(R.id.ZhuiFan_Fragment_RecyclerView);
        srfLayout = view.findViewById(R.id.srf);
    }

    private void setView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        ZuiFan_Fragment_RecyclerView.setLayoutManager(linearLayoutManager);
        //通过构造方法传监听器参数
        recyclerViewAdapter = new ZhuiFanRecycleViewAdapter(mResultEntity,getActivity(),this);
        ZuiFan_Fragment_RecyclerView.setAdapter(recyclerViewAdapter);

        srfLayout.setColorSchemeColors(Color.RED);
    }

    private void addListener() {
        srfLayout.setOnRefreshListener(this);

    }

    /**
     * 根据书名跳到具体的显示页
     * @param bookName
     */
    @Override
    public void toBookContent(String bookName) {
        getActivity().getSupportFragmentManager().beginTransaction().add(
                R.id.container,BookDetailFragment.newInstance(bookName)).commit();
    }

    /**
     * 下拉刷新
     */
    @Override
    public void onRefresh() {
        initialData();
        //切换到UI线程，关闭将刷新的圆圈
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                //TODO
//                recyclerViewAdapter.notifyDataSetChanged(这里有个最新的ResultEntity);
                srfLayout.setRefreshing(false);
            }
        });
    }
}
