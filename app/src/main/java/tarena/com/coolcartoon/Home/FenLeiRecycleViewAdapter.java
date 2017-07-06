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

public class FenLeiRecycleViewAdapter extends RecyclerView.Adapter<FenLeiRecycleViewAdapter.ViewHolder> {

    private Context mContext;


    public FenLeiRecycleViewAdapter(Context context){
        this.mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.fenlei_recyclerview_item,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 4;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView FenLei_Item_Img;
        private TextView FenLen_Item_FenLei;
        private TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            FenLei_Item_Img=itemView.findViewById(R.id.FenLei_Item_Img);
            FenLen_Item_FenLei=itemView.findViewById(R.id.FenLen_Item_FenLei);
            textView=itemView.findViewById(R.id.textView);
        }
    }
}
