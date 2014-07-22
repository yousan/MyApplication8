package com.example.yousan.myapplication8;

/**
 * Created by yousan on 2014/07/22.
 */
public class ResultState implements State {

    private static State singleton = new ResultState();

    private ResultState() {
    }

    public static State getInstance() {
        return singleton;
    }

    @Override
    public void onInputNumber(Context context, Number num) {
        context.clearDisplay();
        context.addDisplayNumber(num);
        context.changeState(NumberAState.getInstance());
    }

    @Override
    public void onInputOperation(Context context, Operation op) {
        context.saveDisplayNumberToA();
        context.setOp(op);

        context.changeState(OperationState.getInstance());
    }

    @Override
    public void onInputEqual(Context context) {

    }

    @Override
    public void onInputClear(Context context) {
        context.clearA();
        context.clearB();
        context.clearDisplay();

        context.changeState(NumberAState.getInstance());
    }

    @Override
    public void onInputAllClear(Context context) {
        context.clearA();
        context.clearB();
        context.clearDisplay();

        context.changeState(NumberAState.getInstance());
    }
}
