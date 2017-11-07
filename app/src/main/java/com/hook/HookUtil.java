package com.hook;


import java.lang.reflect.Field;
import java.lang.reflect.Proxy;

public class HookUtil {


    public  void hookAms(){

        try {
            //获取类
            Class<?> ActivityManagerServiceClass = Class.forName("android.app.ActivityManagerNative");
            //获取类字段
            Field defaultField = ActivityManagerServiceClass.getDeclaredField("gDefault");
            defaultField.setAccessible(true);

            //获取某一对象的成员变量值，因为要获取的为类变量，所以为null
            Object defaultValue = defaultField.get(null);

            Class<?> SingletonClass = Class.forName("android.util.Singleton");
            Field mInstance = SingletonClass.getDeclaredField("mInstance");
            mInstance.setAccessible(true);
            Object iActivityManagerObject = mInstance.get(defaultValue);

            Class<?> IActivityManagerIntercept = Class.forName("android.app.IActivityManager");

            AmsInvocationHandler handler = new AmsInvocationHandler(iActivityManagerObject);

            Object proxy = Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                    new Class<?>[]{IActivityManagerIntercept},handler);
            mInstance.set(defaultValue,proxy);//proxy代替defaultValue



        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}
