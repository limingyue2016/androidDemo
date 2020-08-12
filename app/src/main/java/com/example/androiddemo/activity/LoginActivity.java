package com.example.androiddemo.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.androiddemo.MainActivity;
import com.example.androiddemo.R;
import com.example.androiddemo.util.Constants;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


public class LoginActivity extends BaseActivity implements View.OnClickListener {
    public static final String TAG = "test";

    public Button btn_login;
    public EditText et_username;
    public EditText et_password;
    public ImageView imageView;
    public Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btn_login = findViewById(R.id.btn_login);
        et_username = findViewById(R.id.et_username);
        et_password = findViewById(R.id.et_password);
        imageView = findViewById(R.id.imageView);

        btn_login.setOnClickListener(this);

        new Thread(new Runnable() {
            @Override
            public void run() {
                Drawable drawable = getResources().getDrawable(R.drawable.ic_launcher);
                BitmapDrawable bd = (BitmapDrawable) drawable;
                bitmap = bd.getBitmap();

                handler.sendEmptyMessage(0);
            }
        }).start();
    }

    public Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);

            if (msg.what == 0) {
                imageView.setImageBitmap(bitmap);
            } else {
                Log.d(TAG, "handleMessage: fail");
            }
        }
    };

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                login();
                break;
            default:
                break;
        }

    }

    private void login() {
        String phone = et_username.getText().toString().trim();
        String pwd = et_password.getText().toString().trim();

        if (TextUtils.isEmpty(phone)) {
            Toast.makeText(LoginActivity.this, "请输入手机号", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(pwd)) {
            Toast.makeText(LoginActivity.this, "请输入密码", Toast.LENGTH_SHORT).show();
            return;
        }

        if (Constants.PHONE.equals(phone) && Constants.PWD.equals(pwd)) {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);

            finish();
        }
    }
}