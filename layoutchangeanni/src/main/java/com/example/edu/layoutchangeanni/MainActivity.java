package com.example.edu.layoutchangeanni;

import android.animation.Animator;
import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;


public class MainActivity extends AppCompatActivity {
    private LinearLayout mContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
          mContainer= (LinearLayout) findViewById(R.id.verticalContatiner);
        LayoutTransition transition=new LayoutTransition();
        mContainer.setLayoutTransition(transition);

        Animator appearAnim= ObjectAnimator.ofFloat(null,"rotationY",90f,0f).setDuration(
                transition.getDuration(LayoutTransition.APPEARING)
        );
        transition.setAnimator(LayoutTransition.APPEARING,appearAnim);


        Animator disappearAnim= ObjectAnimator.ofFloat(null,"rotationX",0f,90f).setDuration(
                transition.getDuration(LayoutTransition.APPEARING)
        );
        transition.setAnimator(LayoutTransition.APPEARING,disappearAnim);

        PropertyValuesHolder pvhSlide=PropertyValuesHolder.ofFloat("y",0,1);
        PropertyValuesHolder pvhScaleY=PropertyValuesHolder.ofFloat("scaleY",1f,0.5f,1f);
        PropertyValuesHolder pvhScaleX=PropertyValuesHolder.ofFloat("scaleX",1f,0.5f,1f);

        Animator changeAppearingAnim=ObjectAnimator.ofPropertyValuesHolder(this,pvhSlide
        ,pvhScaleY,pvhScaleX
        );
        changeAppearingAnim.setDuration(transition.getDuration(LayoutTransition.CHANGE_DISAPPEARING));
        transition.setAnimator(LayoutTransition.CHANGE_DISAPPEARING,changeAppearingAnim);

    }


    public void onAddClick(View view){
        Button btn=new Button(this);
        btn.setText("Click To move");
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContainer.removeView(v);
            }
        });
        mContainer.addView(btn,new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT
               , ViewGroup.LayoutParams.WRAP_CONTENT
        ));

    }
}
