package com.example.yousan.myapplication8;

/**
 * Created by yousan on 2014/07/18.
 */
public class Clac implements Context {
    private double A;
    private double B;
    private Operation op;
    protected AbstarctDisplay disp;
    protected State state;

    public Calc() {
        A = 0d;
        B = 0d;
        op = null;
        changeState(NumberAState.getInstance());
        disp = new StringDisplay();
    }

    public void onButtonNumber(Number num) {
        state.onInputNumber(this, num);
    }

    public void onButtonClear() {
        state.onInputClear(this);
    }

    public void onButtonAllClear(){
        state.onInputAllClear(this);
    }

    public void onButtonEqual() {
        state.onInputEqual(this);
    }

    @Override
    public void changeState() {

    }

    @Override
    public double doOperation() {
        double result = op.eval(A, B);
        showDisplay(result);
        return result;
    }

    @Override
    public void showDisplay() {
        disp.showDisplay(false);
    }

    @Override
    public void showDisplay(double d) {
        disp.setNumbe(d);
        disp.showDisplay(true);
    }

    @Override
    public void addDisplayNumber(Number num) {
        if(num == Number.ZERO || num == Number.DOUBLE_ZERO) {
            if (disp.displayChar.size() == 0 && !disp.commaMode) {
                disp.showDisplay(false);
                return;
            }
        }

        if (num == Number.COMMA && !disp.commaMode && disp.displayChar.size() == 0) {
            disp.onInputNumber(Number.ZERO);
        }

        disp.onInputNumber(num);
        disp.showDisplay(false);
    }

    @Override
    public void saveDisplayNumberToA() {
        A = disp.getNumber();
    }

    @Override
    public void saveDisplayNumberToB() {
        B = disp.getNumber();
    }

    @Override
    public void clearA() {
        A = 0d;
    }

    @Override
    public void clearB() {
        B = 0d;
    }

    @Override
    public Operation getOp() {
        return op;
    }

    @Override
    public void setOp(Operation op) {
        this.op = op;
    }

    @Override
    public void clearDisplay() {
        disp.clear();
        disp.showDisplay(false);
    }

    @Override
    public void copyAtoB() {
        B = A;
    }

    @Override
    public double getA() {
        return A;
    }

    @Override
    public double getB() {
        return B;
    }

    @Override
    public void setError() {
        disp.setError();
    }

    @Override
    public void clearError() {
        disp.clearError();
    }

    @Override
    public void changeSign() {
        if (disp.getNumber() != 0d) {
            disp.minus = !disp.minus;
            disp.showDisplay(false);
        }
    }
}
