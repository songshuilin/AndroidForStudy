package com.example.edu.androidforlistener;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Button;

/**
 * Created by Administrator on 2016/9/20.
 */
public class MyButton extends Button {


    public MyButton(Context context) {
        this(context,null);
    }

    public MyButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i("TAG", "MyButton 类中的onTouchEvent事件");
        //返回false代表事件不截断，
        return false;
    }

}
