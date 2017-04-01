package com.example.administrator.rxjavademo3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java_rx3.RxUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * 调用create方法
     * @param view
     */

    public void createMethod(View view) {
        RxUtils.createObserable();

    }

    public void createMethod2(View view) {
        RxUtils.createPrint();
    }

    public void createMethod3(View view) {
        RxUtils.from();
    }

    public void createMethod4(View view) {
        RxUtils.interval();
    }
}
