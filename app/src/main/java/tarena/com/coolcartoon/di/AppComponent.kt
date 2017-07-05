package tarena.com.coolcartoon.di

import android.support.v7.app.AppCompatActivity
import dagger.Component
import dagger.android.AndroidInjectionModule
import tarena.com.coolcartoon.CartoonApp
import tarena.com.coolcartoon.MainActivity
import tarena.com.coolcartoon.view.CommunityFragment

/**
 * Created by jonah on 04/07/2017.
 */
@Component(modules = arrayOf(
        AppModule::class,
        AndroidBindingModule::class))
interface AppComponent {
    fun inject(app: CartoonApp)
    /*fun inject(activity: MainActivity)
    fun inject(fragment: CommunityFragment)*/
}