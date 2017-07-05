package tarena.com.coolcartoon

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
//                container.setText(R.string.title_home)

                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_community -> {
//                container.setText(R.string.title_community)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_shelf -> {
//                container.setText(R.string.title_shelf)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_me -> {
//                container.setText(R.string.title_me)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.communityfrgement)

        bottomNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }
}
