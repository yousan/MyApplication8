package com.example.yousan.myapplication8;

//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;


import android.content.*;
import android.test.ActivityTestCase;
import android.test.AndroidTestCase;
import android.widget.TextView;

import junit.framework.Assert;

import junit.framework.TestCase;

public class CalcTest extends AndroidTestCase {
	final double EPSION = 0.0000000001;

    private Calc c;

    public void setUp() {
        c = new Calc();

        //android.content.Context context = getActivity().getApplicationContext();
        TextView txtDisp = new TextView(getContext());
        c.setDisp(txtDisp, null);
    }

    public void tearDown() {
        c = null;
    }

	public final void testCalc() {
		System.out.println("CalcTest.testCalc()----------------------------------------");

	
		c.onButtonNumber(Number.TWO); // 2
		c.onButtonNumber(Number.ONE); // 21
		c.onButtonNumber(Number.COMMA); // 21.
		c.onButtonNumber(Number.TWO); // 21.2
		c.onButtonNumber(Number.THREE); // 21.23
		c.onButtonNumber(Number.FOUR); // 21.234
		c.onButtonNumber(Number.EIGHT); // 21.2348
		c.onButtonClear();
		c.onButtonNumber(Number.TWO); // 2
		c.onButtonNumber(Number.ONE); // 21
		c.onButtonNumber(Number.COMMA); // 21.
		c.onButtonNumber(Number.TWO); // 21.2
		c.onButtonNumber(Number.THREE); // 21.23
		c.onButtonNumber(Number.FOUR); // 21.234
		c.onButtonNumber(Number.EIGHT); // 21.2348
		c.onButtonAllClear();
		c.onButtonNumber(Number.TWO); // 2
		c.onButtonNumber(Number.ONE); // 21
		c.onButtonNumber(Number.COMMA); // 21.
		c.onButtonNumber(Number.TWO); // 21.2
		c.onButtonNumber(Number.THREE); // 21.23
		c.onButtonNumber(Number.FOUR); // 21.234
		c.onButtonNumber(Number.EIGHT); // 21.2348
		Assert.assertNotNull(c);
	}

	public final void textOpe() {
		System.out.println("CalcTest.textOpe()----------------------------------------");

	
		// 4+8=12
		System.out.print("TEST:");
		System.out.println(c.state.toString());

		c.onButtonNumber(Number.FOUR);
		c.onButtonOp(Operation.PLUS);
		Assert.assertEquals(4d, c.getA(), EPSION);
		System.out.print("TEST:");
		System.out.println(c.state.toString());
		c.onButtonNumber(Number.EIGHT);

		c.onButtonEqual();
		System.out.print("TEST:");
		System.out.println(c.state.toString());
		Assert.assertEquals(4d, c.getA(), EPSION);
		Assert.assertEquals(8d, c.getB(), EPSION);
		System.out.print("TEST:");
		System.out.println(c.disp.toString());
		Assert.assertEquals(4d + 8d, c.disp.getNumber(), EPSION);

		// 4444444444+ 1111111111=5555555555.0
		c.onButtonNumber(Number.FOUR);
		c.onButtonNumber(Number.FOUR);
		c.onButtonNumber(Number.FOUR);
		c.onButtonNumber(Number.FOUR);
		c.onButtonNumber(Number.FOUR);
		c.onButtonNumber(Number.FOUR);
		c.onButtonNumber(Number.FOUR);
		c.onButtonNumber(Number.FOUR);
		c.onButtonNumber(Number.FOUR);
		c.onButtonNumber(Number.FOUR);

		c.onButtonOp(Operation.PLUS);

		c.onButtonNumber(Number.ONE);
		c.onButtonNumber(Number.ONE);
		c.onButtonNumber(Number.ONE);
		c.onButtonNumber(Number.ONE);
		c.onButtonNumber(Number.ONE);
		c.onButtonNumber(Number.ONE);
		c.onButtonNumber(Number.ONE);
		c.onButtonNumber(Number.ONE);
		c.onButtonNumber(Number.ONE);
		c.onButtonNumber(Number.ONE);

		c.onButtonEqual();

		System.out.println(String.format("TEST：%1$10.10f", c.disp.getNumber()));

		Assert.assertEquals(4444444444d + 1111111111d, c.disp.getNumber(), EPSION);

		// 1-4 = -3
		c.onButtonNumber(Number.ONE);
		c.onButtonOp(Operation.MINUS);
		c.onButtonNumber(Number.FOUR);
		c.onButtonEqual();
		Assert.assertEquals(1d - 4d, c.disp.getNumber(), EPSION);

		// -5=-5
		c.onButtonAllClear();
		c.onButtonOp(Operation.MINUS);
		c.onButtonNumber(Number.FIVE);
		c.onButtonEqual();
		Assert.assertEquals(-5d, c.disp.getNumber(), EPSION);

		// 5-789456123
		c.onButtonNumber(Number.FIVE);
		c.onButtonOp(Operation.MINUS);
		c.onButtonNumber(Number.SEVEN);
		c.onButtonNumber(Number.EIGHT);
		c.onButtonNumber(Number.NINE);
		c.onButtonNumber(Number.FOUR);
		c.onButtonNumber(Number.FIVE);
		c.onButtonNumber(Number.SIX);
		c.onButtonNumber(Number.ONE);
		c.onButtonNumber(Number.TWO);
		c.onButtonNumber(Number.THREE);
		c.onButtonEqual();
		Assert.assertEquals(5d - 789456123d, c.disp.getNumber(), EPSION);

		// 0.1+2.489

		c.onButtonNumber(Number.COMMA);
		c.onButtonNumber(Number.ONE);
		c.onButtonOp(Operation.PLUS);
		c.onButtonNumber(Number.TWO);
		c.onButtonNumber(Number.COMMA);
		c.onButtonNumber(Number.FOUR);
		c.onButtonNumber(Number.EIGHT);
		c.onButtonNumber(Number.NINE);
		c.onButtonEqual();
		Assert.assertEquals(0.1 + 2.489, c.disp.getNumber(), EPSION);

		// 0.1 - 2.489

		c.onButtonNumber(Number.COMMA);
		c.onButtonNumber(Number.ONE);
		c.onButtonOp(Operation.MINUS);
		c.onButtonNumber(Number.TWO);
		c.onButtonNumber(Number.COMMA);
		c.onButtonNumber(Number.FOUR);
		c.onButtonNumber(Number.EIGHT);
		c.onButtonNumber(Number.NINE);
		c.onButtonEqual();
		Assert.assertEquals(0.1 - 2.489, c.disp.getNumber(), EPSION);

		// 4 * 8 = 32
		c.onButtonNumber(Number.FOUR);
		c.onButtonOp(Operation.TIMES);
		c.onButtonNumber(Number.EIGHT);
		c.onButtonEqual();
		Assert.assertEquals(4d * 8d, c.disp.getNumber(), EPSION);

		// 4 / 8 = 0.5
		c.onButtonNumber(Number.FOUR);
		c.onButtonOp(Operation.DIVIDE);
		c.onButtonNumber(Number.EIGHT);
		c.onButtonEqual();
		Assert.assertEquals(4d / 8d, c.disp.getNumber(), EPSION);

		// 7 / 3 = 2.3333333333333335
		c.onButtonNumber(Number.SEVEN);
		c.onButtonOp(Operation.DIVIDE);
		c.onButtonNumber(Number.THREE);
		c.onButtonEqual();
		Assert.assertEquals(7d / 3d, c.disp.getNumber(), EPSION);

		// 2 / 3 = 0.666666666666...
		c.onButtonNumber(Number.TWO);
		c.onButtonOp(Operation.DIVIDE);
		c.onButtonNumber(Number.THREE);
		c.onButtonEqual();

		System.out.println(2d / 3d);
		System.out.println(c.disp.getNumber());
		Assert.assertEquals(2d / 3d, c.disp.getNumber(), EPSION);

	}

	public final void testべき乗() {
		System.out.println("CalcTest.testべき乗()----------------------------------------");
			c.onButtonNumber(Number.FOUR);
		c.onButtonOp(Operation.TIMES);
		c.onButtonEqual();
		Assert.assertEquals(16d, c.disp.getNumber(), EPSION);

		c.onButtonNumber(Number.FOUR);
		c.onButtonOp(Operation.DIVIDE);
		c.onButtonEqual();
		Assert.assertEquals(4d / 4d, c.disp.getNumber(), EPSION);

	}

	public final void testClearB() {
		System.out.println("CalcTest.testClearB()----------------------------------------");
		c.onButtonNumber(Number.FOUR);
		c.onButtonOp(Operation.TIMES);
		c.onButtonNumber(Number.FOUR);
		c.onButtonNumber(Number.FIVE);
		c.onButtonClear();
		c.onButtonNumber(Number.EIGHT);
		c.onButtonEqual();
		Assert.assertEquals(4d * 8d, c.disp.getNumber(), EPSION);

	}

	public final void test連続Ope() {
		System.out.println("CalcTest.testClearB()----------------------------------------");

		// 1+2+3+4+5+6+7+8+9
			c.onButtonNumber(Number.ONE);
		c.onButtonOp(Operation.PLUS);

		c.onButtonNumber(Number.TWO);
		c.onButtonOp(Operation.PLUS);

		c.onButtonNumber(Number.THREE);
		c.onButtonOp(Operation.PLUS);

		c.onButtonNumber(Number.FOUR);
		c.onButtonOp(Operation.PLUS);

		c.onButtonNumber(Number.FIVE);
		c.onButtonOp(Operation.PLUS);

		c.onButtonNumber(Number.SIX);
		c.onButtonOp(Operation.PLUS);

		c.onButtonNumber(Number.SEVEN);
		c.onButtonOp(Operation.PLUS);

		c.onButtonNumber(Number.EIGHT);

		c.onButtonOp(Operation.PLUS);

		c.onButtonNumber(Number.NINE);

		c.onButtonOp(Operation.PLUS);

		c.onButtonEqual();
		Assert.assertEquals(1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9d, c.disp.getNumber(), EPSION);

	}

	public final void test連続Ope2() {
		System.out.println("CalcTest.testClearB()----------------------------------------");

		// 1+2*3-4/7
			c.onButtonNumber(Number.ONE);
		c.onButtonOp(Operation.PLUS);

		c.onButtonNumber(Number.TWO);
		c.onButtonOp(Operation.TIMES);

		c.onButtonNumber(Number.THREE);
		c.onButtonOp(Operation.MINUS);

		c.onButtonNumber(Number.FOUR);
		c.onButtonOp(Operation.DIVIDE);

		c.onButtonNumber(Number.SEVEN);

		c.onButtonEqual();

		Assert.assertEquals((((1d + 2d) * 3d) - 4d) / 7d, c.disp.getNumber(), EPSION);

	}

	public final void test演算子変更() {
		System.out.println("CalcTest.testClearB()----------------------------------------");

		// 1+2*3-4/7
			c.onButtonNumber(Number.EIGHT);
		c.onButtonOp(Operation.PLUS);
		c.onButtonOp(Operation.TIMES);

		c.onButtonNumber(Number.TWO);

		c.onButtonNumber(Number.THREE);

		c.onButtonOp(Operation.MINUS);

		Assert.assertEquals(184d, c.disp.getNumber(), EPSION);

		c.onButtonOp(Operation.DIVIDE);

		Assert.assertEquals(184d, c.disp.getNumber(), EPSION);

		c.onButtonNumber(Number.FOUR);

		c.onButtonNumber(Number.SEVEN);

		c.onButtonEqual();

		Assert.assertEquals(184d / 47d, c.disp.getNumber(), EPSION);

	}

	public final void test0入力() {
		System.out.println("CalcTest.testClearB()----------------------------------------");

		//Calc c = new Calc();

		c.onButtonNumber(Number.ZERO);
		c.onButtonNumber(Number.ZERO);
		c.onButtonNumber(Number.ZERO);
		c.onButtonNumber(Number.ONE);

		c.onButtonNumber(Number.DOUBLE_ZERO);
		c.onButtonEqual();

		c.onButtonNumber(Number.ZERO);
		c.onButtonNumber(Number.COMMA);
		c.onButtonNumber(Number.ONE);
		c.onButtonOp(Operation.MINUS);
		c.onButtonNumber(Number.THREE);
		c.onButtonEqual();

	}

	public final void test小数入力() {
		System.out.println("CalcTest.testClearB()----------------------------------------");

			c.onButtonNumber(Number.COMMA);
		c.onButtonNumber(Number.ZERO);
		c.onButtonNumber(Number.ZERO);
		c.onButtonNumber(Number.ZERO);
		c.onButtonNumber(Number.ZERO);
		c.onButtonNumber(Number.ZERO);
		c.onButtonNumber(Number.ZERO);
		c.onButtonNumber(Number.ZERO);
		c.onButtonNumber(Number.ZERO);
		c.onButtonNumber(Number.ZERO);
		c.onButtonNumber(Number.ZERO);
		c.onButtonNumber(Number.ZERO);
		c.onButtonNumber(Number.ZERO);
		c.onButtonNumber(Number.ONE);
		c.onButtonNumber(Number.DOUBLE_ZERO);

		c.onButtonEqual();
		c.onButtonNumber(Number.ZERO);
		c.onButtonNumber(Number.COMMA);
		c.onButtonOp(Operation.MINUS);
		c.onButtonNumber(Number.ZERO);
		c.onButtonNumber(Number.COMMA);
		c.onButtonNumber(Number.ZERO);
		c.onButtonEqual();

	}
}
