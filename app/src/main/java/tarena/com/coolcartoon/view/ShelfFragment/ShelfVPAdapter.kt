package tarena.com.coolcartoon.view.ShelfFragment

import android.support.v4.view.PagerAdapter
import android.view.View
import android.view.ViewGroup

/**
 *
 * Created by tarena on 2017/7/7.
 */
class ShelfVPAdapter: PagerAdapter() {

    override fun isViewFromObject(view: View?, `object`: Any?): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun destroyItem(container: ViewGroup?, position: Int, `object`: Any?) {
        super.destroyItem(container, position, `object`)
    }

    override fun instantiateItem(container: ViewGroup?, position: Int): Any {
        return super.instantiateItem(container, position)
    }
}