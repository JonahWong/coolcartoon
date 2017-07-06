package tarena.com.coolcartoon.view;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import tarena.com.coolcartoon.R;
import tarena.com.coolcartoon.setting.SettingActivity;
import tarena.com.coolcartoon.view.interfaces.MeView;


/**
 * Created by jonah on 03/07/2017.
 */

public class MeFragment extends Fragment implements MeView, View.OnClickListener {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //TODO "我的" Fragment
    }

    View item1, item2, item3, item4, item5, item6, item7, item8, item9;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.mine_layout, container, false);
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getActivity().getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getActivity().getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        item9 = view.findViewById(R.id.item2);
        item9.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.item2 : {
                Intent intent = new Intent(getContext(), SettingActivity.class);
                startActivity(intent);
            }
        }
    }
}
