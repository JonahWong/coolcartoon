package tarena.com.coolcartoon.Home;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import tarena.com.coolcartoon.R;
import tarena.com.coolcartoon.model.ChapterEntity;
import tarena.com.coolcartoon.presenter.ChapterPresenter;
import tarena.com.coolcartoon.view.interfaces.ChapterPresentation;

public class FenLeiLieBiaoActivity extends AppCompatActivity implements ChapterPresentation {

    @Inject
    ChapterPresenter presenter;
    private RecyclerView rv;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fen_lei_lie_biao);
        //点击会到列表界面
        tv= (TextView) findViewById(R.id.fenleileibiao_fenlei);


        rv= (RecyclerView) findViewById(R.id.fenleileibiao_RecyclerView);
        presenter.loadCartoonChapters("少女漫画");
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rv.setLayoutManager(linearLayoutManager);
        FenLeiLieBiaoRecycleViewAdapter recyclerViewAdapter = new FenLeiLieBiaoRecycleViewAdapter(this);
        rv.setAdapter(recyclerViewAdapter);
    }

    @Override
    public void scrollTo(int position) {

    }

    @Override
    public void chapterAddedAt(int position) {

    }

    @Override
    public void showChapters(@NotNull List<ChapterEntity> chapters) {

    }
}
