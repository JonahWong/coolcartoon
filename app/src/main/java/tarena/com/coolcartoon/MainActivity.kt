package tarena.com.coolcartoon

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import cn.bmob.v3.Bmob
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import kotlinx.android.synthetic.main.activity_main.*
import tarena.com.coolcartoon.model.responses.BookCategoryResponse
import tarena.com.coolcartoon.presenter.MainPresenter
import tarena.com.coolcartoon.view.CommunityFragment
import tarena.com.coolcartoon.view.HomeFragment
import tarena.com.coolcartoon.view.MeFragment
import tarena.com.coolcartoon.view.ShelfFragment
import javax.inject.Inject

class MainActivity : AppCompatActivity(), HasSupportFragmentInjector {
    @Inject
    lateinit var presenter: MainPresenter

    @Inject
    lateinit var fragmentInjector: DispatchingAndroidInjector<Fragment>

    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return fragmentInjector
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                replaceFragment {
                    replace(R.id.container, HomeFragment())
                }
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_community -> {
                replaceFragment {
                    replace(R.id.container, CommunityFragment())
                }
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_shelf -> {
                replaceFragment {
                    replace(R.id.container, ShelfFragment())
                }
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_me -> {
                replaceFragment {
                    replace(R.id.container, MeFragment())
                }
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        initBmob()
        /*val bookCategory = BookCategoryResponse(null)
        bookCategory.reason = ""
        bookCategory.result = null*/
        setContentView(R.layout.activity_main)

        bottomNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    private fun initBmob() {
        //第一：默认初始化
        Bmob.initialize(this, BuildConfig.BMOB_APPLICATION_KEY);
        // 注:自v3.5.2开始，数据sdk内部缝合了统计sdk，开发者无需额外集成，传渠道参数即可，不传默认没开启数据统计功能
        //Bmob.initialize(this, "Your Application ID","bmob");

        //第二：自v3.4.7版本开始,设置BmobConfig,允许设置请求超时时间、文件分片上传时每片的大小、文件的过期时间(单位为秒)，
        //BmobConfig config =new BmobConfig.Builder(this)
        ////设置appkey
        //.setApplicationId("Your Application ID")
        ////请求超时时间（单位为秒）：默认15s
        //.setConnectTimeout(30)
        ////文件分片上传时每片的大小（单位字节），默认512*1024
        //.setUploadBlockSize(1024*1024)
        ////文件的过期时间(单位为秒)：默认1800s
        //.setFileExpiration(2500)
        //.build();
        //Bmob.initialize(config);
    }

    inline fun <T> replaceFragment(action: FragmentTransaction.() -> T): T{
        val transaction = supportFragmentManager.beginTransaction()

        try {
            return action(transaction)
        } finally {

            transaction.commit()
        }

    }
}
