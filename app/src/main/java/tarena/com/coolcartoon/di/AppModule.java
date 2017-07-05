package tarena.com.coolcartoon.di;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import tarena.com.coolcartoon.presenter.CommunityPresenter;
import tarena.com.coolcartoon.presenter.MainPresenter;

/**
 * Created by jonah on 04/07/2017.
 */
@Module
public class AppModule {
    private final Context mContext;

    public AppModule(Context context) {
        mContext = context;
    }

    @Provides
    Context providesContext() {
        return mContext;
    }

    @Provides
    CommunityPresenter providesCommunityPresenter() {
        return new CommunityPresenter();
    }

    @Provides
    MainPresenter providesMainPresenter() {
        return new MainPresenter();
    }
}
