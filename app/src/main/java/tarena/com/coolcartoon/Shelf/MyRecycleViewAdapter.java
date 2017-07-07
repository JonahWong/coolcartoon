package tarena.com.coolcartoon.Shelf;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import tarena.com.coolcartoon.R;
import tarena.com.coolcartoon.model.Book;

/**
 * Created by tarena on 2017/7/7.
 */

public class MyRecycleViewAdapter extends RecyclerView.Adapter<MyRecycleViewAdapter.ViewHolder>{
    private List<Book> dataList;
    private Context context;
    public MyRecycleViewAdapter(Context context) {
        if (dataList==null){
            dataList = new ArrayList<>();
        }
        this.context= context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.shelf_recycle_item,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Book book = dataList.get(position);
        holder.tvDate.setText(String.valueOf(book.getLastUpdate()));
        holder.tvReadState.setText(String.valueOf(book.getFinish()));
        holder.tvName.setText(book.getName());
        Glide.with(context).load(book.getCoverImg()).into(holder.ivPhoto);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvName;
        TextView tvDate;
        TextView tvReadState;
        Button btn;
        ImageView ivPhoto;
        public ViewHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_title);
            tvDate = itemView.findViewById(R.id.tv_date);
            tvReadState = itemView.findViewById(R.id.tvReadState);
            btn = itemView.findViewById(R.id.btn_continue_read);
            ivPhoto = itemView.findViewById(R.id.iv_photo);
        }
    }
    public void addData(List<Book> list){
        dataList = list;
        notifyDataSetChanged();
    }
}
