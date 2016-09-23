package com.example.edu.androidformenu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ActionBarOverlayLayout;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent itent=new Intent();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        menu.add(0,1,0,"主菜单一");
//        menu.add(0,2,0,"主菜单二");
//        menu.add(0,3,0,"主菜单三");
//        menu.add(0,4,0,"主菜单四");
//       SubMenu sub= menu.addSubMenu(0,5,0,"子菜单");
//        sub.add(0,6,0,"子菜单一");
//        sub.add(0,7,0,"子菜单二");
//        sub.add(0,8,0,"子菜单三");
//        sub.add(0,9,0,"子菜单四");
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case 1:
                Toast.makeText(MainActivity.this,"主菜单一",Toast.LENGTH_SHORT).show();
                break;
            case 2:
                Toast.makeText(MainActivity.this,"主菜单二",Toast.LENGTH_SHORT).show();
                break;
            case 3:
                Toast.makeText(MainActivity.this,"主菜单三",Toast.LENGTH_SHORT).show();
                break;
            case 4:
                Toast.makeText(MainActivity.this,"主菜单四",Toast.LENGTH_SHORT).show();
                break;
            case 5:
                Toast.makeText(MainActivity.this,"子菜单",Toast.LENGTH_SHORT).show();
                break;
            case 6:
                Toast.makeText(MainActivity.this,"子菜单一",Toast.LENGTH_SHORT).show();
                break;
            case 7:
                Toast.makeText(MainActivity.this,"子菜单二",Toast.LENGTH_SHORT).show();
                break;
            case 8:
                Toast.makeText(MainActivity.this,"子菜单三",Toast.LENGTH_SHORT).show();
                break;
            case 9:
                Toast.makeText(MainActivity.this,"子菜单四",Toast.LENGTH_SHORT).show();
                break;

        }

        return false;
    }
}
