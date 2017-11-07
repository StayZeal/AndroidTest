package com.hook;

import android.util.Log;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by yangfeng on 2017/11/2.
 */

public class AmsInvocationHandler implements InvocationHandler {


    private  Object iActivityManagerObject;

    public AmsInvocationHandler(Object iActivityManagerObject) {
        this.iActivityManagerObject = iActivityManagerObject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Log.i("HookUtil", method.getName());
        //我要在这里搞点事情
        if ("startActivity".contains(method.getName())) {
            Log.e("HookUtil","Activity已经开始启动");
            Log.e("HookUtil","小弟到此一游！！！");
        }
        return method.invoke(iActivityManagerObject, args);
    }
}
