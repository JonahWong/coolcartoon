package tarena.com.coolcartoon.Home;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import tarena.com.coolcartoon.R;

public class FenLeiLieBiaoActivity extends AppCompatActivity {

    private RecyclerView rv;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fen_lei_lie_biao);
        //点击会到列表界面
        tv= (TextView) findViewById(R.id.fenleileibiao_fenlei);


        rv= (RecyclerView) findViewById(R.id.fenleileibiao_RecyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rv.setLayoutManager(linearLayoutManager);
        FenLeiLieBiaoRecycleViewAdapter recyclerViewAdapter = new FenLeiLieBiaoRecycleViewAdapter(this);
        rv.setAdapter(recyclerViewAdapter);
    }
}
