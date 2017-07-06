package tarena.com.coolcartoon.Home;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import tarena.com.coolcartoon.R;

/**
 * Created by tarena on 2017/7/5.
 */

public class ZhuiFanRecycleViewAdapter extends RecyclerView.Adapter<ZhuiFanRecycleViewAdapter.ViewHolder> {

    private Context mContext;

    public ZhuiFanRecycleViewAdapter(Context context){
        this.mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.zhuifan_recyclerview_item,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private  TextView ZuiFan_Item_NowZhangJie;
        private  TextView ZuiFan_Item_ZhangJie;
        private  TextView ZuiFan_Item_FenLei;
        private  TextView ZuiFan_Item_Name;
        private  ImageView ZuiFan_Item_Img;
        private  ImageView ZuiFan_Item_zan_ImageView;
        private  TextView ZuiFan_Item_zan_TextView;
        private  TextView ZuiFan_Item_PingLunShu;
        public ViewHolder(View itemView) {
            super(itemView);
            ZuiFan_Item_Img=itemView.findViewById(R.id.ZhuiFan_Item_Img);
            ZuiFan_Item_FenLei=itemView.findViewById(R.id.ZhuiFan_Item_FenLei);
            ZuiFan_Item_Name=itemView.findViewById(R.id.ZhuiFan_Item_Name);
            ZuiFan_Item_zan_ImageView=itemView.findViewById(R.id.ZhuiFan_Item_zan_ImageView);
            ZuiFan_Item_zan_TextView=itemView.findViewById(R.id.ZhuiFan_Item_zan_TextView);
            ZuiFan_Item_ZhangJie=itemView.findViewById(R.id.ZhuiFan_Item_ZhangJie);
            ZuiFan_Item_NowZhangJie=itemView.findViewById(R.id.ZhuiFan_Item_NowZhangJie);
            ZuiFan_Item_PingLunShu=itemView.findViewById(R.id.ZhuiFan_Item_PingLunShu);
        }
    }
}
