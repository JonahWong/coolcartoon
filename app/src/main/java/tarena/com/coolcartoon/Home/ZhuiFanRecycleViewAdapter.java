package tarena.com.coolcartoon.Home;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import tarena.com.coolcartoon.R;
import tarena.com.coolcartoon.model.Book;
import tarena.com.coolcartoon.model.ResultEntity;

/**
 * Created by tarena on 2017/7/5.
 */

public class ZhuiFanRecycleViewAdapter extends RecyclerView.Adapter<ZhuiFanRecycleViewAdapter.ViewHolder> {

    private Context mContext;
    private ResultEntity mResultEntity;
    private ArrayList<Book> books = mResultEntity.getBookList();
    private OntoBookContentListener listener;

    public ZhuiFanRecycleViewAdapter(ResultEntity mResultEntity,Context context,OntoBookContentListener listener){
        this.mResultEntity = mResultEntity;
        this.mContext = context;
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.zhuifan_recyclerview_item,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Book book = books.get(position);

        Glide.with(mContext).load(book.getCoverImg()).into(holder.ZuiFan_Item_Img);
        //书名
        holder.ZuiFan_Item_Name.setText(book.getName());
        //分类
        holder.ZuiFan_Item_FenLei.setText(book.getType());
        //全集，是否完结
        if (book.getFinish()){
            holder.ZuiFan_Item_ZhangJie.setText("完结");
        }else {
            holder.ZuiFan_Item_ZhangJie.setText("连载");
        }


        //TODO 点赞，评论 ---从数据库中取

        //点击item上的图片进入到具体的漫画列表
        holder.ZuiFan_Item_Img.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (listener != null){
                    listener.toBookContent(book.getName());
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return books != null?books.size():0;
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

    public void notifyDataSetChanged(ArrayList<Book> books){
        this.books = books;
        notifyDataSetChanged();
    }

    public interface OntoBookContentListener{
        void toBookContent(String bookName);
    }

}
