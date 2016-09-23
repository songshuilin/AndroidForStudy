package com.example.edu.androidforstudy;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.CornerPathEffect;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends Activity implements SwipeRefreshLayout.OnRefreshListener {
    ArrayAdapter<String> adapter;
    private SwipeRefreshLayout mSwipeLayout;
    private ListView mListView;
    private ArrayList<String> list = new ArrayList<String>();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adapter= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, getData());
        mListView = (ListView) findViewById(R.id.listview);
        mListView.setAdapter(adapter);

        mSwipeLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_container);
        mSwipeLayout.setOnRefreshListener(this);
        // 设置下拉圆圈上的颜色，蓝色、绿色、橙色、红色
        mSwipeLayout.setColorSchemeResources(android.R.color.holo_blue_bright, android.R.color.holo_green_light,
                android.R.color.holo_orange_light, android.R.color.holo_red_light);
        mSwipeLayout.setDistanceToTriggerSync(100);// 设置手指在屏幕下拉多少距离会触发下拉刷新
        //mSwipeLayout.setProgressBackgroundColor(Color.RED);
        mSwipeLayout.setSize(SwipeRefreshLayout.LARGE);
    }

    private ArrayList<String> getData() {
        list.add("Hello");
        list.add("This is stormzhang");
        list.add("An Android Developer");
        list.add("Love Open Source");
        list.add("My GitHub: stormzhang");
        list.add("weibo: googdev");
        list.add("android ");
        return list;
    }

    /*
     * 监听器SwipeRefreshLayout.OnRefreshListener中的方法，当下拉刷新后触发
     */
    public void onRefresh() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                list.add("aaaaa");
                // 停止刷新
                mSwipeLayout.setRefreshing(false);
                adapter.notifyDataSetChanged();

            }
        }, 5000); // 5秒后发送消息，停止刷新
    }
}
