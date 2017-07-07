package tarena.com.coolcartoon.Shelf;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import tarena.com.coolcartoon.R;

/**
 * 订阅界面
 * Created by tarena on 2017/7/7.
 */

public class SubscribeFragment extends Fragment {
    View view;
    private RecyclerView rv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_subscribe,null);
        initView();
        addListener();
        addData();
        return view;
    }

    /**
     * 根据分类类型或者已阅读过的书籍列表请求书籍数据
     */
    private void addData() {

    }

    private void addListener() {

    }

    private void initView() {
        rv = view.findViewById(R.id.rv_shelfFragment);
        MyRecycleViewAdapter adapter = new MyRecycleViewAdapter(getContext());
        rv.setAdapter(adapter);
    }
}
