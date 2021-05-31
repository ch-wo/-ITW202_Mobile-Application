package edu.gcit.todo_10;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.closeTo;
import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(JUnit4.class)

public class ExampleUnitTest {
    private Calculator mCalculator;

    @Before
    public void SetUp(){
        mCalculator = new Calculator();
    }
    //unit test for Addition
    @Test
    public void addTwoNumbers() {
        double result = mCalculator.Adding(1d,2d);
        assertThat(result, is(equalTo(3d)));
    }

    @Test
    public void addTwoNumbersNegative(){
        double result = mCalculator.Adding(-3d, 1d);
        assertThat(result, is(equalTo(-2d)));
    }

    @Test
    public void addTwoNumbersFloat(){
        double result = mCalculator.Adding(1.11f, 1.11d);
        assertThat(result, is(closeTo(2.22,0.01)));
    }

    //unit test for subtraction
    @Test
    public void subTwoNumbers() {
        double result = mCalculator.Subtracting(3d,2d);
        assertThat(result, is(equalTo(1d)));
    }
    @Test
    public void subTwoNumbersNegative(){
        double result = mCalculator.Subtracting(-3d, 1d);
        assertThat(result, is(equalTo(-4d)));
    }

    @Test
    public void subTwoNumbersFloat(){
        double result = mCalculator.Subtracting(3.11f, 1.11d);
        assertThat(result, is(closeTo(2.00,0.01)));
    }
    //unit test for Multiplication
    @Test
    public void mulTwoNumbers() {
        double result = mCalculator.Multiply(3d,2d);
        assertThat(result, is(equalTo(6d)));
    }
    @Test
    public void mulNegative(){
        double result = mCalculator.Multiply(-3d, 1d);
        assertThat(result, is(equalTo(-3d)));
    }

    @Test
    public void mulTwoNumbersZero(){
        double result = mCalculator.Multiply(3d, 0d);
        assertThat(result, is(equalTo(0d)));
    }

    //Unit test for division
    @Test
    public void divTwoNumbers() {
        double result = mCalculator.Division(6d,2d);
        assertThat(result, is(equalTo(3d)));
    }
    @Test
    public void divTwoNumbersZero(){
        double result = mCalculator.Division(3d, 0d);
        assertThat(result, is(equalTo(Double.POSITIVE_INFINITY)));
    }

}