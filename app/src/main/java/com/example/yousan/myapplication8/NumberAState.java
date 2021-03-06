package com.example.yousan.myapplication8;

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
        context.saveDisplayNumberToA();
        context.setOp(op);
        context.changeState(OperationState.getInstance());
    }

    @Override
    public void onInputEqual(Context context) {
        context.saveDisplayNumberToA();
        context.showDisplay(context.getA());
        context.changeState(ResultState.getInstance());
    }

    @Override
    public void onInputClear(Context context) {
        context.clearA();
        context.clearDisplay();
    }

    @Override
    public void onInputAllClear(Context context) {
        context.clearA();
        context.clearB();
        context.clearDisplay();
    }
}
