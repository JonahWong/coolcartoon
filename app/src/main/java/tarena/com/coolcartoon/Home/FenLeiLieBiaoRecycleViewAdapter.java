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

public class FenLeiLieBiaoRecycleViewAdapter extends RecyclerView.Adapter<FenLeiLieBiaoRecycleViewAdapter.ViewHolder> {

    private Context mContext;

    public FenLeiLieBiaoRecycleViewAdapter(Context context){
        this.mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.fenleileibiao_recyclerview_item,parent,false);
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
        private  TextView FenLeiLieBiao_RecycleView_Item_name;
        private  TextView FenLeiLieBiao_RecycleView_Item_fenlei;
        private  TextView FenLeiLieBiao_RecycleView_Item_author;
        private  ImageView FenLeiLieBiao_RecycleView_Item_Img;

        public ViewHolder(View itemView) {
            super(itemView);
            FenLeiLieBiao_RecycleView_Item_Img=itemView.findViewById(R.id.fenleileibiao_item_RecyclerView_img);
            FenLeiLieBiao_RecycleView_Item_name=itemView.findViewById(R.id.fenleileibiao_item_RecyclerView_name);
            FenLeiLieBiao_RecycleView_Item_author=itemView.findViewById(R.id.fenleileibiao_item_RecyclerView_author);
            FenLeiLieBiao_RecycleView_Item_fenlei=itemView.findViewById(R.id.fenleileibiao_item_RecyclerView_fenlei);

        }
    }
}
