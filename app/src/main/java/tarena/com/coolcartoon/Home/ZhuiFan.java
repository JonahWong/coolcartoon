package tarena.com.coolcartoon.Home;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import tarena.com.coolcartoon.R;

/**
 * Created by tarena on 2017/7/5.
 */

public class ZhuiFan extends Fragment {
    private RecyclerView ZuiFan_Fragment_RecyclerView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       // ZuiFan_Fragment_RecyclerView =getView().findViewById(R.id.ZuiFan_Fragment_RecyclerView);


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_zhui_fan,container,false);
        ZuiFan_Fragment_RecyclerView=view.findViewById(R.id.ZhuiFan_Fragment_RecyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        ZuiFan_Fragment_RecyclerView.setLayoutManager(linearLayoutManager);
        ZhuiFanRecycleViewAdapter recyclerViewAdapter = new ZhuiFanRecycleViewAdapter(this.getActivity());
        ZuiFan_Fragment_RecyclerView.setAdapter(recyclerViewAdapter);
        return view;
    }
}
