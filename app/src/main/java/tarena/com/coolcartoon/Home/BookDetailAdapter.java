package tarena.com.coolcartoon.Home;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.zip.Inflater;

import tarena.com.coolcartoon.R;
import tarena.com.coolcartoon.model.Chapter;
import tarena.com.coolcartoon.model.ChapterResult;

/**
 * 如果不行，就用两个ViewHolder
 * Created by tarena on 2017/7/7.
 */

public class BookDetailAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ChapterResult mChapterResult;
    private OnToReadListener listener;
    private ArrayList<Chapter> mchapterList = mChapterResult.getChapterList();
    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;
    private View contentView;

    public BookDetailAdapter(ChapterResult mChapterResult, OnToReadListener listener) {
        this.mChapterResult = mChapterResult;
        this.listener = listener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType == TYPE_HEADER){
            contentView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.book_detail_header,parent,false);
            return new ViewHolderHeader(contentView);
        }else {
            contentView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.book_detail_item,parent,false);
            return new ViewHolderItem(contentView);
        }


    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        final Chapter mChapter = mchapterList.get(position - 1);
        if (position == TYPE_HEADER){
            //TODO 头mPosition
            ((ViewHolderHeader)holder).tvComicName.setText(mChapterResult.getComicName());
        }else {
            ((ViewHolderItem)holder).tvChapterName.setText(mChapter.getName());
            //设置点击漫画话数监听,直接将chapter传过去，需要name 和 id 都有
            contentView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener != null){
                        listener.toRead(mChapter);
                    }
                }
            });
        }

    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0){
            return TYPE_HEADER;
        }else {
            return TYPE_ITEM;
        }
    }

    @Override
    public int getItemCount() {
        return mchapterList != null ? mchapterList.size() + 1 : 0;
    }


    public class ViewHolderHeader extends RecyclerView.ViewHolder {
        // 漫画名字
        TextView tvComicName;
        public ViewHolderHeader(View itemView) {
            super(itemView);
            tvComicName = itemView.findViewById(R.id.tv_chapter_id);

        }
    }

    public class ViewHolderItem extends RecyclerView.ViewHolder {
        // 这个用来表示是多少话
        TextView tvChapterName;
        public ViewHolderItem(View itemView) {
            super(itemView);
            tvChapterName = itemView.findViewById(R.id.tv_book_name);
        }
    }

    public void notifyDataSetChanged(ChapterResult mChapterResult){
        this.mChapterResult = mChapterResult;
        notifyDataSetChanged();
    }

    public interface OnToReadListener{
        void toRead(Chapter chapter);
    }

}
