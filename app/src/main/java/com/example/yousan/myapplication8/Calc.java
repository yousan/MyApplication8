package com.example.yousan.myapplication8;


import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by yousan on 2014/07/18.
 */
public class Calc implements Context {
    private double A;
    private double B;
    private Operation op;
    protected AbstractDisplay disp;
    protected State state;
    protected android.content.Context parent;

    public Calc() {
        A = 0d;
        B = 0d;
        op = null;
        changeState(NumberAState.getInstance());
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
    public void changeState(State state) {
        this.state = state;
    }

    @Override
    public double doOperation() throws CalcException {
        double result = op.eval(A, B);
        if (Double.isInfinite(result) || Double.isNaN(result)) {
            throw new CalcException();
        }
        showDisplay(result);

        if (disp.isOverflow(result)) {
            throw new CalcException();
        }
        return result;
    }

    @Override
    public void showDisplay() {
        disp.showDisplay(false);
    }

    @Override
    public void showDisplay(double d) {
        disp.setNumber(d);
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
        if (parent != null) {
            Toast.makeText(parent, "Error", Toast.LENGTH_LONG).show();
        }
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

    public void setDisp(TextView txt, android.content.Context parent) {
        this.disp = new StringDisplay(txt);
        this.parent = parent;
    }

    public void onButtonOp(Operation op) {
        state.onInputOperation(this, op);
    }
}
