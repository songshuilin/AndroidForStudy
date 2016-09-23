package com.example.edu.androidforlistener;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/*
MainActivity实现OnClickListener接口
 */
public class MainActivity extends AppCompatActivity {
 private MyButton mMb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i("TAG", "MainActivity 类中的onTouchEvent事件");
        //返回false代表事件不截断，
        return false;
    }
}

