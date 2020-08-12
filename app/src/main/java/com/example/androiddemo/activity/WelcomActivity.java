package com.example.androiddemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.example.androiddemo.R;

import androidx.annotation.NonNull;

public class WelcomActivity extends BaseActivity {
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcom);

        // 延时1s 进入登录界面
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                handler.sendEmptyMessage(0);
            }
        }, 1000);
    }

    public Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            next();
        }
    };

    private void next() {
        Intent intent = new Intent(WelcomActivity.this, LoginActivity.class);
        startActivity(intent);

        finish();
    }
}
