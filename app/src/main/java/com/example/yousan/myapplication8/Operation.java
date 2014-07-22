package com.example.yousan.myapplication8;

/**
 * Created by yousan on 2014/07/19.
 */
public enum Operation {
    PLUS {
        double eval(double x, double y) {
            return x + y;
        }
    },
    MINUS {
        double eval(double x, double y) {
            return x - y;
        }
    },
    TIMES {
        double eval(double x, double y) {
            return x * y;
        }
    },
    DIVIDE {
        double eval(double x, double y) {
            return x / y;
        }
    };
    abstract double eval(double x, double y);
}
