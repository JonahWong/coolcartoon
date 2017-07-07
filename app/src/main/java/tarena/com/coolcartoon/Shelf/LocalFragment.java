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
 * Created by tarena on 2017/7/7.
 */

public class LocalFragment extends Fragment {
    View view;
    private RecyclerView rv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_subscribe,null);
        initView();
        addListener();
        return view;
    }

    private void addListener() {

    }

    private void initView() {
        rv = view.findViewById(R.id.rv_shelfFragment);
        MyRecycleViewAdapter adapter = new MyRecycleViewAdapter(getContext());
        rv.setAdapter(adapter);
    }
}
