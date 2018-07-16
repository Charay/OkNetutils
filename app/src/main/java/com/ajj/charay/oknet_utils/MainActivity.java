package com.ajj.charay.oknet_utils;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //普通网络请求
//        参数次数我写的null，可根据实际情况填写
        OkNetUtils.executeNetRequest(null, null, new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {

            }

            @Override
            public void onResponse(String response, int id) {

            }
        });

        //        多文件上传网络请求
        //        参数次数我写的null，可根据实际情况填写
        OkNetUtils.executeMultiUploadRequest(null, null, null, null, new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {

            }

            @Override
            public void onResponse(String response, int id) {

            }
        });
    }
}
