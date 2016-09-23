package com.example.edu.objectanimatorsimple;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
  private Button mBtn;
    private View view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initWidgets();
        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (view.getAlpha()>0f){
                    view.animate().alpha(0f).translationX(1000f);
                }else {
                    view.setTranslationX(0f);
                    view.animate().alpha(1f);
                }
            }
        });
    }

    private void initWidgets() {
        mBtn= (Button) findViewById(R.id.id_btn);
        view=findViewById(R.id.theView);
    }
}
