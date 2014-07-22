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
        context.addDisplayNumber(num);
    }

    @Override
    public void onInputOperation(Context context, Operation op) {
        try {
            context.saveDisplayNumberToB();
            context.doOperation();
            context.setOp(op);
            context.saveDisplayNumberToA();
            context.changeState(OperationState.getInstance());
        } catch (CalcException e) {
            context.setError();
            context.changeState(ErrorState.getInstance());
        }
    }

    @Override
    public void onInputEqual(Context context) {
        try {
            context.saveDisplayNumberToA();
            context.doOperation();
            context.changeState(ResultState.getInstance());
        } catch (CalcException e) {
            context.setError();
            context.changeState(ErrorState.getInstance());
        }
    }

    @Override
    public void onInputClear(Context context) {
        context.clearB();
        context.clearDisplay();
    }

    @Override
    public void onInputAllClear(Context context) {
        context.clearA();
        context.clearB();
        context.clearDisplay();

        context.changeState(NumberAState.getInstance());
    }
}
