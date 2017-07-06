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

public class DanMeiRecycleViewAdapter extends RecyclerView.Adapter<DanMeiRecycleViewAdapter.ViewHolder> {

    private Context mContext;

    public DanMeiRecycleViewAdapter(Context context){
        this.mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.remen_recycleview_item,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView DanMei_img;
        private TextView DanMei_author;
        private  ImageView DanMei_RecycleView_Item_Img;
        private  TextView DanMei_RecycleView_Item_name;
        private  TextView DanMei_name;
        private  TextView DanMei_RecycleView_Item_author;

        public ViewHolder(View itemView) {
            super(itemView);
            DanMei_RecycleView_Item_Img=itemView.findViewById(R.id.ReMen_RecycleView_Item_Img);
            DanMei_RecycleView_Item_name=itemView.findViewById(R.id.ReMen_RecycleView_Item_name);
            DanMei_RecycleView_Item_author=itemView.findViewById(R.id.ReMen_RecycleView_Item_author);
            DanMei_name=itemView.findViewById(R.id.DanMei_Name);
            DanMei_author=itemView.findViewById(R.id.DanMei_author);
            DanMei_img=itemView.findViewById(R.id.DanMei_img);
            
        }
    }
}
