package tarena.com.coolcartoon.di;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import tarena.com.coolcartoon.biz.CoolCartoonApi;
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

    @Provides
    CoolCartoonApi providesCoolCartoonApi() {
        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://japi.juhe.cn/comic/")
                .build();
        return retrofit.create(CoolCartoonApi.class);
    }
}
