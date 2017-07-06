package tarena.com.coolcartoon.CounnunityFrgement;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import tarena.com.coolcartoon.R;

/**
 * Created by tarena on 2017/7/5.
 */

public class ImageFrgement extends Fragment {
    View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.image_brek_recycerview,container,false);
        return view;
    }
}
