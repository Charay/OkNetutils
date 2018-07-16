package com.ajj.charay.oknet_utils;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.builder.PostFormBuilder;
import com.zhy.http.okhttp.callback.StringCallback;
import com.zhy.http.okhttp.request.RequestCall;

import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * @author Charay
 * @data 2018/7/13
 */

public class OkNetUtils {

    /**
     * 常用网络接口
     *
     * @param url            请求的完整URL地址：baseurl+接口
     * @param params         加密后的参数 map形式
     * @param stringCallback String类型的回调
     */
    public static void executeNetRequest(String url, Map<String, String> params, Object obj, StringCallback stringCallback) {
        OkHttpUtils
                .post()
                .addHeader("Connection", "close")
                .url(url)
                .params(params)
                .tag(obj)
                .build()
                .connTimeOut(10000)
                .readTimeOut(20000)
                .writeTimeOut(20000)
                .execute(stringCallback);

    }

    /**
     * 多参数上传 (普通参数和多文件)
     *
     * @param url            url地址
     * @param params         普通参数
     * @param fileKey        文件key
     * @param mlist          文件列表
     * @param stringCallback 回调callback
     */
    public static void executeMultiUploadRequest(String url, Map<String, String> params, String fileKey, List<File> mlist, StringCallback stringCallback) {

        PostFormBuilder builder = OkHttpUtils
                .post()
                .url(url)
                .params(params);
        for (File file : mlist) {
            builder.addFile(fileKey, file.getName(), file);
        }
        RequestCall build = builder.build();
        build.execute(stringCallback);
    }

}
