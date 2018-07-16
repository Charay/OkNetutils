
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

	implementation 'com.github.Charay:OkNetutils:1.2'

注意：可能会有support包冲突的异常，解决方法在文档最后

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

![](https://i.imgur.com/Z5NWEOY.png)

 - 多文件上传网络请求
 
	**OkNetUtils.executeMultiUploadRequest(...)**
 
![](https://i.imgur.com/EUpnjd4.png)

support冲突异常：

	Error:FAILURE: Build failed with an exception.

	* What went wrong:
	Execution failed for task ':app:preDebugAndroidTestBuild'.
	> Conflict with dependency 'com.android.support:support-annotations' in project ':app'. Resolved versions for app (26.1.0) and test app (27.1.1) differ. See https://d.android.com/r/tools/test-apk-dependency-conflicts.html for details.
	
	* Try:
	Run with --stacktrace option to get the stack trace. Run with --info or --debug option to get more log output. Run with --scan to get full insights.
	
	* Get more help at https://help.gradle.org
	
	BUILD FAILED in 1s
解决方法：
在module的gradle中与dependences{}同级加入：
具体强制使用annotations的哪个版本，根据异常中test app (27.1.1)的版本号定

	configurations.all {
	    resolutionStrategy.force 'com.android.support:support-annotations:27.1.1'
	}


