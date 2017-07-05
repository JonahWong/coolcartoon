package tarena.com.coolcartoon.di;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import tarena.com.coolcartoon.MainActivity;
import tarena.com.coolcartoon.view.CommunityFragment;

/**
 * Created by jonah on 04/07/2017.
 */
@Module
public abstract class AndroidBindingModule {

    @ContributesAndroidInjector
    abstract CommunityFragment communityFragment();

    @ContributesAndroidInjector
    abstract MainActivity mainActivity();

}
