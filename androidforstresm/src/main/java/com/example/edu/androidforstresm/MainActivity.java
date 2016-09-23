package com.example.edu.androidforstresm;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "TAG";
    private EditText mEt;
    PrintStream ps;
    FileOutputStream fos;
    FileInputStream fis;
    BufferedReader reader;
    private TextView mTv;
    private TextView mTvRaw;
    InputStream is;
    private TextView mTvAss;
    private EditText mEtSdWrite;
    private TextView mEtSdRead;
    private File file;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEt = (EditText) findViewById(R.id.input_et);
        mTv = (TextView) findViewById(R.id.content_tv);
        mTvRaw = (TextView) findViewById(R.id.raw_content_tv);
        mTvAss = (TextView) findViewById(R.id.ass_content_tv);
        mEtSdWrite = (EditText) findViewById(R.id.write_sd_content_tv);
        mEtSdRead = (TextView) findViewById(R.id.read_sd_content_tv);
    }

    public void write(View view) {
        try {
            fos = openFileOutput("person.txt", MODE_PRIVATE);
            ps = new PrintStream(fos, true, "utf-8");
            ps.print(mEt.getText().toString());
            Toast.makeText(MainActivity.this, "写入成功", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            if (ps != null) {
                ps.close();
                ps = null;
            }
            if (fos != null) {
                try {
                    fos.close();
                    fos = null;
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

        }


    }

    public void read(View view) {
        try {
            fis = openFileInput("person.txt");
            reader = new BufferedReader(new InputStreamReader(fis));
            StringBuffer sb = new StringBuffer();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }

            mTv.setText(sb.toString());
            Toast.makeText(MainActivity.this, "读取成功", Toast.LENGTH_SHORT).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                    fis = null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (reader != null) {
                    try {
                        reader.close();
                        reader = null;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }
        }

    }

    public void onclickRaw(View view) {
        Resources resources = getResources();
        is = resources.openRawResource(R.raw.person);
        reader = new BufferedReader(new InputStreamReader(is));
        String line = null;
        StringBuffer sb = new StringBuffer();
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            mTvRaw.setText(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                    is = null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (reader != null) {
                    try {
                        reader.close();
                        reader = null;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }
        }
    }

    public void onclickAss(View view) {
        is = MainActivity.this.getClass().getClassLoader().getResourceAsStream("assets/person.txt");
        try {
            //is = getResources().getAssets().open("person.txt");
            reader = new BufferedReader(new InputStreamReader(is, "utf-8"));

            String line = null;
            StringBuffer sb = new StringBuffer();

            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            mTvAss.setText(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                    is = null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (reader != null) {
                    try {
                        reader.close();
                        reader = null;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }
        }
    }

    public void onclickSdWrite(View view) {


        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            File fileDir = Environment.getExternalStorageDirectory();

            try {
                file = new File(fileDir.getCanonicalPath() + File.separator + "person.txt");
                Log.i(TAG, "onclickSdWrite: " + fileDir.getAbsolutePath());
                Log.i(TAG, "onclickSdWrite: "+fileDir.getCanonicalPath());
                Log.i(TAG, "onclickSdWrite: "+fileDir.getPath());
                Log.i(TAG, "onclickSdWrite: "+fileDir.getName());
                Log.i(TAG, "onclickSdWrite: "+fileDir.getParent());
                FileOutputStream fos = new FileOutputStream(file);
                ps = new PrintStream(fos);
                ps.print(mEtSdWrite.getText().toString());
                Toast.makeText(MainActivity.this, "写入成功", Toast.LENGTH_SHORT).show();

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (ps != null) {
                    ps.close();
                }
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }


            }


        } else {
            Toast.makeText(MainActivity.this, "没有sd卡权限", Toast.LENGTH_SHORT).show();
        }

    }

    public void onclickSdRead(View view) {
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            File fileDir = Environment.getExternalStorageDirectory();
            try {
                file = new File(fileDir.getCanonicalPath() + File.separator + "person.txt");
                reader = new BufferedReader(new FileReader(file));
                StringBuffer sb = new StringBuffer();
                String line = null;
                while ((line = reader.readLine()) != null) {
                    sb.append(line);
                }
                mEtSdRead.setText(sb.toString());
                Toast.makeText(MainActivity.this, "读取成功", Toast.LENGTH_SHORT).show();

            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                if (reader!=null){
                    try {
                        reader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    reader=null;
                }
            }

        } else {

            Toast.makeText(MainActivity.this, "没有sd卡权限", Toast.LENGTH_SHORT).show();
        }

    }

}
