package com.example.yousan.myapplication8;

/**
 * Created by yousan on 2014/07/22.
 */
public class OperationState implements State {

    private static OperationState singleton = new OperationState();

    private OperationState() {
    }

    public static State getInstance() {
        return singleton;
    }


    @Override
    public void onInputNumber(Context context, Number num) {
        context.clearDisplay();
        context.addDisplayNumber(num);
        context.changeState(NumberBState.getInstance());
    }

    @Override
    public void onInputOperation(Context context, Operation op) {
        context.setOp(op);
    }

    @Override
    public void onInputEqual(Context context) {
        switch (context.getOp()) {
            case DIVIDE:
            case TIMES:
                try {
                    context.copyAtoB();
                    context.doOperation();
                    context.changeState(ResultState.getInstance());
                } catch (CalcException e) {
                    context.setError();
                    context.changeState(ErrorState.getInstance());
                }
                break;
            case MINUS:
            case PLUS:
                context.showDisplay(context.getA());
                context.changeState(ResultState.getInstance());
                break;
            default:
                break;
        }
    }

    @Override
    public void onInputClear(Context context) {
        context.clearA();
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
