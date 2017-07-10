package tarena.com.coolcartoon

import android.app.Activity
import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import tarena.com.coolcartoon.di.AppModule
import tarena.com.coolcartoon.di.DaggerAppComponent
import javax.inject.Inject

/**
 * Created by jonah on 03/07/2017.
 */
class CartoonApp: Application(), HasActivityInjector{
    @Inject
    lateinit var activityInject: DispatchingAndroidInjector<Activity>
    override fun activityInjector(): AndroidInjector<Activity> {
        return activityInject
    }

    override fun onCreate() {
        super.onCreate()
        //genggai

        DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build().inject(this)

    }
}