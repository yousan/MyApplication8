package com.example.yousan.myapplication8;

import com.example.yousan.myapplication8.Context;

/**
 * Created by yousan on 2014/07/18.
 */
public interface State {
    public abstract void onInputNumber(Context context, Number num);
    public abstract void onInputOperation(Context context, Operation op);
    public abstract void onInputEqual(Context context);
    public abstract void onInputClear(Context context);
    public abstract void onInputAllClear(Context context);
}
