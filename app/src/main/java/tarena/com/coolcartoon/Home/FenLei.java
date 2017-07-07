package tarena.com.coolcartoon.Home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import tarena.com.coolcartoon.R;

/**
 * Created by tarena on 2017/7/6.
 */

public class FenLei extends Fragment {
    private RecyclerView FeiLei_RecyclerView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fen_lei,container,false);
        FeiLei_RecyclerView=view.findViewById(R.id.FeiLei_RecyclerView);
        GridLayoutManager grid = new GridLayoutManager(getActivity(), 2);
        FenLeiRecycleViewAdapter fenLeiRecycleViewAdapter=new FenLeiRecycleViewAdapter(getActivity());
        FeiLei_RecyclerView.setAdapter(fenLeiRecycleViewAdapter);
        FeiLei_RecyclerView.setLayoutManager(grid);
        return view;
    }
}
