package com.example.yousan.myapplication8;

import android.widget.TextView;

/**
 * Created by yousan on 2014/07/18.
 */
public class StringDisplay extends AbstractDisplay {

    private TextView txt;

    public StringDisplay(TextView disp) {
        clear();
        this.txt = disp;
    }

    @Override
    public void showDisplay(boolean format) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < displayChar.size(); i++) {
            String str = displayChar.get(i);
            sb.append(str);
        }
        if (commaMode && decimalPlaces > 0) {
            sb.insert(sb.length() - decimalPlaces, ".");
        }
        if (sb.length() == 0) {
            sb.append("0");
        }

        if (minus) {
            sb.insert(0, "-");
        }

        if (format && commaMode && decimalPlaces > 0) {
            StringBuffer sbOut = new StringBuffer();
            boolean commaFlag = false;
            for (int i = sb.length() - 1; i >= 0; i--) {
                if (commaFlag) {
                    sbOut.insert(0, sb.charAt(i));
                } else {
                    if (sb.charAt(i) == '0') {
                    } else if (sb.charAt(i) == '.') {
                        commaFlag = true;
                    } else {
                        commaFlag = true;
                        sbOut.insert(0, sb.charAt(i));
                    }
                }
            }
            sb = sbOut;
        }
        System.out.println(sb);
        txt.setText(sb);
    }

    @Override
    public void onInputNumber(Number num) {
        switch (num) {
            case DOUBLE_ZERO:
                addNumber(num);
                addNumber(num);
                break;
            case COMMA:
                if (!commaMode) {
                    commaMode = true;
                    decimalPlaces = 0;
                }
                break;
            default:
                addNumber(num);
                break;
        }
    }

    private void addNumber(Number num) {
        if (displayChar.size() < DISPLAY_DIGIT) {
            displayChar.push(num.getValue());
            if (commaMode) {
                decimalPlaces++;
            }
        }
    }

    @Override
    public void clear() {
        commaMode = false;
        decimalPlaces = 0;
        minus = false;
        displayChar.clear();
    }

    @Override
    public double getNumber() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < displayChar.size(); i++) {
            String str = displayChar(i);
            sb.append(str);
        }
        return 0;
    }

    @Override
    public void setNumber(double d) {

    }

    @Override
    public void setError() {

    }

    @Override
    public void clearError() {

    }
}
