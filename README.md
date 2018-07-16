
## **OkNetutils** ##


## **目前只精简了两个常用网络请求（都是POST请求）** ##
 - 一般网络请求 

 - 多文件上传网络请求

>本项目是在鸿洋前辈的okhttp-utils项目的基础上，根据自己的开发经验精简出两个常用的post网络请求的方法主要为自己使用方便，同时尝试一下如何创建自己的library库，okhttp-utils的所有方法仍然可以继续使用



## **如何使用** ##

- Android Studio
 
在工程gradle中添加：

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}


在module的gradle中添加：

	implementation 'com.github.Charay:OkNetutils:1.1'


## **初始化** ##
和okhttp-utils初始化一样：

	public class MyApplication extends Application
	{	
		@Override
    	public void onCreate()
    	{
        	super.onCreate();

        	OkHttpClient okHttpClient = new OkHttpClient.Builder()
		//            .addInterceptor(new LoggerInterceptor("TAG"))
                  	.connectTimeout(10000L, TimeUnit.MILLISECONDS)
                  	.readTimeout(10000L, TimeUnit.MILLISECONDS)
                  	//其他配置
                 	.build();
                 
        	OkHttpUtils.initClient(okHttpClient);

    	}
	}

别忘了在AndroidManifest中设置application和网络请求permission

## 其他详细配置**可选**，详见okhttp-utils说明文档 ##
[https://github.com/hongyangAndroid/okhttputils](https://github.com/hongyangAndroid/okhttputils)


## **使用：** ##

- 一般网络请求：
	**OkNetUtils.executeNetRequest(...)**

![image](https://github.com/Charay/OkNetutils/blob/master/images/commonrequest.png)

 - 多文件上传网络请求
 
	**OkNetUtils.executeMultiUploadRequest(...)**
 
![images](https://github.com/Charay/OkNetutils/blob/master/images/multirequest.png)


