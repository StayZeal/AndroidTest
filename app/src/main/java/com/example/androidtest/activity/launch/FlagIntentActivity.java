package com.example.androidtest.activity.launch;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.androidtest.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FlagIntentActivity extends BaseActivity2 {

    @BindView(R.id.message)
    TextView message;
    @BindView(R.id.new_task)
    Button newTask;
    @BindView(R.id.single_top)
    Button singleTop;
    @BindView(R.id.clear_top)
    Button clearTop;
    @BindView(R.id.navigation)
    BottomNavigationView navigation;
    @BindView(R.id.container)
    LinearLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flag_intent);
        ButterKnife.bind(this);

        message.setText(getClass().getSimpleName());
    }

    @OnClick({R.id.new_task, R.id.single_top, R.id.clear_top})
    public void onViewClicked(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.new_task:

                intent = new Intent(this, FlagIntentActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);

                break;
            case R.id.single_top:
                intent = new Intent(this, FlagIntentActivity2.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
                break;
            case R.id.clear_top:
                intent = new Intent(this, FlagIntentActivity2.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                break;
        }
    }
}
