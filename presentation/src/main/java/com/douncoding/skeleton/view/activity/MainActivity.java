package com.douncoding.skeleton.view.activity;

import android.os.Bundle;

import com.douncoding.skeleton.R;
import com.douncoding.skeleton.navigation.Navigator;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.load_data_btn)
    void navigateToUserList() {
        this.navigator.navigateToUserList(this);
    }
}
