package tarena.com.coolcartoon.CounnunityFrgement;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by tarena on 2017/7/4.
 */

/***
 * 适配数据到listView 上 图片数据
 */
public class adapter extends BaseAdapter {
    List<Counnnunibean>list;

    public adapter(List<Counnnunibean> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }
}
