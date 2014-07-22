package com.example.yousan.myapplication8;

/**
 * Created by yousan on 2014/07/18.
 */
public interface Context {
    public abstract void changeState(State state);
    public abstract double doOperation() throws CalcException;
    void showDisplay();
    public abstract void showDisplay(double d);
    public abstract void addDisplayNumber(Number num);
    public abstract void saveDisplayNumberToA();
    public abstract void saveDisplayNumberToB();
    public abstract void clearA();
    public abstract void clearB();
    public abstract Operation getOp();
    public abstract void setOp(Operation op);
    public abstract void clearDisplay();
    public abstract void copyAtoB();
    public abstract double getA();
    public abstract double getB();
    public abstract void setError();
    public abstract void clearError();
    public abstract void changeSign();
}
