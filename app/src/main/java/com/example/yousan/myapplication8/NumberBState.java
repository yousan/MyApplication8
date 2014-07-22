package com.example.yousan.myapplication8;

/**
 * Created by yousan on 2014/07/22.
 */
public class NumberBState implements State {

    private static State singleton = new NumberBState();

    private NumberBState(){

    }

    public static State getInstance() {
        return singleton;
    }

    @Override
    public void onInputNumber(Context context, Number num) {

    }

    @Override
    public void onInputOperation(Context context, Operation op) {

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