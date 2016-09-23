package com.example.edu.objectanimatorsimple;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.ImageView;

public class FlipperAcitivity extends AppCompatActivity {
    private ObjectAnimator mFlipper;
    private Bitmap mHeadsImage,mTailsImage;
    private boolean mIsHead;
    private ImageView mFlipImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flipper_acitivity);
        mHeadsImage= BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher);
        mTailsImage=BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher);

        mFlipImage= (ImageView) findViewById(R.id.flip_image);

        mFlipImage.setImageBitmap(mHeadsImage);
        mIsHead=true;

        mFlipper=ObjectAnimator.ofFloat(mFlipImage,"rotationY",0f,360f);
        mFlipper.setDuration(500);

        mFlipper.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                if (animation.getAnimatedFraction()>=0.25f&&mIsHead){
                    mFlipImage.setImageBitmap(mTailsImage);
                    mIsHead=false;

                }
                if (animation.getAnimatedFraction()>=0.75f&&!mIsHead){
                    mFlipImage.setImageBitmap(mHeadsImage);
                    mIsHead=true;

                }
            }
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction()==MotionEvent.ACTION_DOWN){
            mFlipper.start();
            return true;
        }
        return super.onTouchEvent(event);
    }
}
