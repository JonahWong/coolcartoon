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

public class ShaoNvRecycleViewAdapter extends RecyclerView.Adapter<ShaoNvRecycleViewAdapter.ViewHolder> {

    private Context mContext;


    public ShaoNvRecycleViewAdapter(Context context){
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
        private  TextView ShaoNv_RecycleView_Item_name;
        private  TextView ShaoNv_RecycleView_Item_author;
        private  ImageView ShaoNv_RecycleView_Item_Img;

        public ViewHolder(View itemView) {
            super(itemView);
            ShaoNv_RecycleView_Item_Img=itemView.findViewById(R.id.ReMen_RecycleView_Item_Img);
            ShaoNv_RecycleView_Item_name=itemView.findViewById(R.id.ReMen_RecycleView_Item_name);
            ShaoNv_RecycleView_Item_author=itemView.findViewById(R.id.ReMen_RecycleView_Item_author);

        }
    }
}
