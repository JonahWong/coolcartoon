package tarena.com.coolcartoon.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;
import tarena.com.coolcartoon.R;
import tarena.com.coolcartoon.biz.CoolCartoonApi;
import tarena.com.coolcartoon.model.Book;
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
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidSupportInjection.inject(this);
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_shelf,null);
    }
}
