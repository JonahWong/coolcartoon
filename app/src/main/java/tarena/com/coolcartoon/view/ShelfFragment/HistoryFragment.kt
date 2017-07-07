package tarena.com.coolcartoon.view.ShelfFragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import tarena.com.coolcartoon.R


/**
 * 历史阅读记录
 */
class HistoryFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_history, container, false)
    }
}// Required empty public constructor
