package tarena.com.coolcartoon.Home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import tarena.com.coolcartoon.R;
import tarena.com.coolcartoon.model.Chapter;
import tarena.com.coolcartoon.model.ChapterResult;

/**
 * 书籍详情页
 * adapter中提供了notifyDataSetChanged方法，当persenter中对应的接口数据（参数）传来的时候赋值this.mChapterResult并调用
 * reated by tarena on 2017/7/7.
 */

public class BookDetailFragment extends Fragment implements View.OnClickListener, BookDetailAdapter.OnToReadListener {

    private View view;
    private RecyclerView rv;
    private static final String BOOK_NAME ="bookName";
    private ChapterResult mChapterResult;
    private BookDetailAdapter adapter;

    public static BookDetailFragment newInstance(String bookName){
        BookDetailFragment bookDetailFragment = new BookDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putString(BOOK_NAME,bookName);
        bookDetailFragment.setArguments(bundle);
        return bookDetailFragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        //获取参数
        String bookName = bundle.getString(BOOK_NAME);
        // TODO 这里根据bookName调用persenter中的具体访问数据方法

    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.book_detail,null);
        initView();
        setView();
        addListeners();
        return view;
    }

    private void setView() {
        LinearLayoutManager linearLayoutManager = new GridLayoutManager(getActivity(),1);
        rv.setLayoutManager(linearLayoutManager);
        adapter = new BookDetailAdapter(mChapterResult,this);
        rv.setAdapter(adapter);
    }


    private void initView() {
        rv = view.findViewById(R.id.rv_bookdetail);

    }

    private void addListeners() {
        (view.findViewById(R.id.iv_back)).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            //返回，即将页面销毁
            case R.id.iv_back:
                getActivity().getSupportFragmentManager().beginTransaction().remove(this).commit();
                break;
            //TODO 下载，调用persenter中的具体下载方法
            case R.id.iv_download:

                break;
            //TODO 分享  调用persenter中的具体方法
            case R.id.iv_share:

                break;
            //TODO 订阅  调用persenter中的具体方法
            case R.id.btn_subscribe:

                break;
            //TODO 继续阅读  调用persenter中的具体方法
            case R.id.btn_continue_read:

                break;
        }
    }

    /**
     * 点击进入阅读具体漫画
     * @param chapter
     */
    @Override
    public void toRead(Chapter chapter) {

    }
}
