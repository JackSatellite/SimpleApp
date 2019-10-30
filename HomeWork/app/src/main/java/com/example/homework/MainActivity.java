package com.example.homework;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button mBtnPhoto;
    private Button mBtnCall;
    private Button mBtnMessage;
    private Button mBtnCalculator;
    private Button mBtnHelloWorld;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnPhoto = findViewById(R.id.bu_1);
        mBtnCall = findViewById(R.id.bu_2);
        mBtnMessage = findViewById(R.id.bu_3);
        mBtnCalculator = findViewById(R.id.bu_4);
        mBtnHelloWorld = findViewById(R.id.bu_5);
        setListeners();
    }

    private void setListeners(){
        Onclick onclick = new Onclick();
        mBtnPhoto.setOnClickListener(onclick);
        mBtnCall.setOnClickListener(onclick);
        mBtnMessage.setOnClickListener(onclick);
        mBtnCalculator.setOnClickListener(onclick);
        mBtnHelloWorld.setOnClickListener(onclick);
    }


    private class Onclick implements View.OnClickListener{
        @Override
        public void onClick(View view){
            Intent intent = null;
            switch (view.getId()){
                case R.id.bu_1://拍照
                    intent = new Intent(MainActivity.this,PhotoActivity.class);
                    break;
                case R.id.bu_2://打电话
                    intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + 1783995596));
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    break;
                case R.id.bu_3://发短信
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse("smsto:" + 1783995596));
                    break;
                case R.id.bu_4://计算器(系统自带计算器以前被我卸载了，所以用调用应用的方法)
                    try {
                        PackageManager packageManager = getPackageManager();
                        intent = packageManager.getLaunchIntentForPackage("com.google.android.calculator");
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    break;
                case R.id.bu_5://Hello World
                    try {
                        PackageManager packageManager = getPackageManager();
                        intent = packageManager.getLaunchIntentForPackage("com.example.helloworld");
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    break;
            }
            startActivity(intent);
        }
    }
}
