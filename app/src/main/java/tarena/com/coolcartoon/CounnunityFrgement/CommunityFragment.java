package tarena.com.coolcartoon.CounnunityFrgement;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RelativeLayout;

import tarena.com.coolcartoon.R;
import tarena.com.coolcartoon.view.interfaces.CommunityView;


/**
 * Created by jonah on 03/07/2017.
 */
/**
 * 社区frgrnment
 * 左逢春
 */

  /**
   * CommunityView借口需要获取数据 社区的中所需数据
  */
public class CommunityFragment extends Fragment implements CommunityView {
      View view;
      private ListView listView;
      private View hadeview;
      private RelativeLayout zhuantielayout;
      private RelativeLayout chatlayout;
      private RelativeLayout maparealayout;

      @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //TODO "社区" Fragment
        initViews();
        addLister();
    }

      @Nullable
      @Override
      public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
          //渲染主布局
        view =inflater.inflate(R.layout.communityfrgement,container,false);
        //渲染list的头布局
          hadeview = inflater.inflate(R.layout.cardview_hade,container,false);
          return view ;
      }

      private void addLister() {

      }

      private void initViews() {
          //主frgement的list
          listView = view.findViewById(R.id.listview_id);
          //头布局中的三个标题   
          zhuantielayout = hadeview.findViewById(R.id.relative_id_1);
          chatlayout = hadeview.findViewById(R.id.relative_id_2);
          maparealayout = hadeview.findViewById(R.id.relative_id_3);





      }
  }
