package com.example.androiddemo.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.androiddemo.R;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        closeActivity();
    }

    private void closeActivity() {
        Button btn_close = findViewById(R.id.btn_close);
        btn_close.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        finish();
    }
}