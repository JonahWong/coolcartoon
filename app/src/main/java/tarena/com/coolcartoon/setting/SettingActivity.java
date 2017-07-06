package tarena.com.coolcartoon.setting;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import tarena.com.coolcartoon.R;

/**
 * Created by tarena on 2017/7/5.
 */

public class SettingActivity extends AppCompatActivity {

    Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_layout);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }
}
