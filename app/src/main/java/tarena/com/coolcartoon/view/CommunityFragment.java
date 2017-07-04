package tarena.com.coolcartoon.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.widget.Toast;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.support.AndroidSupportInjection;
import tarena.com.coolcartoon.presenter.CommunityPresenter;
import tarena.com.coolcartoon.view.interfaces.CommunityView;


/**
 * Created by jonah on 03/07/2017.
 */

public class CommunityFragment extends Fragment implements CommunityView {
    @Inject
    CommunityPresenter presenter;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidSupportInjection.inject(this);
        super.onCreate(savedInstanceState);
        //TODO "社区" Fragment


    }

    @Override
    public void showToast(String message) {
        Toast.makeText(this.getContext(), message, Toast.LENGTH_SHORT).show();
    }
}
