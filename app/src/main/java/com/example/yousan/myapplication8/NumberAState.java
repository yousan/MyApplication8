package com.example.yousan.myapplication8;

import android.content.Context;

/**
 * Created by yousan on 2014/07/18.
 */
public class NumberAState implements State {

    private static NumberAState singleton = new NumberAState();

    private NumberAState() {
    }

    public static State getInstance() {
        return singleton;
    }

    @Override
    public void onInputNumber(Context context, Number num) {
        context.addDisplayNumber(num);
    }

    @Override
    public void onInputOperation(Context context, Operation op) {
        context.savedisplayNumberToA();
        context.setOp(op);
        context.changeState();

    }

    @Override
    public void onInputEqual(Context context) {

    }

    @Override
    public void onInputClear(Context context) {

    }

    @Override
    public void onInputAllClear(Context context) {

    }
}
