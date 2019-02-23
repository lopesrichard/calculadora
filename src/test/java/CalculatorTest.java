/*
 * The MIT License
 *
 * Copyright 2019 richard.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

import com.sun.xml.internal.ws.policy.spi.AssertionCreationException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author richard
 */
public class CalculatorTest {
    private Calculator calc;

    @Test
    public void testShouldSumPositiveNumbers() {
        calc = new Calculator("1+21+165");
        assertEquals(calc.calculate(), "187.0");
    }
    
    @Test
    public void testShouldSumNegativeAndPositiveNumbers() {
        calc = new Calculator("-13+24");
        assertEquals(calc.calculate(), "11.0");
    }
    
    @Test
    public void testShouldSubtractNumbers() {
        calc = new Calculator("103-24-138");
        assertEquals(calc.calculate(), "-59.0");
    }
    
    @Test
    public void testShouldMultiplyPositiveNumbers() {
        calc = new Calculator("4×3×5");
        assertEquals(calc.calculate(), "60.0");
    }
    
    @Test
    public void testShouldMultiplyNegativeNumbers() {
        calc = new Calculator("-4×-3");
        assertEquals(calc.calculate(), "12.0");
    }
    
    @Test
    public void testShouldMultiplyNegativeAndPositiveNumbers() {
        calc = new Calculator("-8×3");
        assertEquals(calc.calculate(), "-24.0");
    }
    
    @Test
    public void testShouldDividePositiveNumbers() {
        calc = new Calculator("4÷3÷5");
        assertEquals(calc.calculate(), "0.26666666666666666");
    }
    
    @Test
    public void testShouldDivideNegativeNumbers() {
        calc = new Calculator("-4÷-3");
        assertEquals(calc.calculate(), "1.3333333333333333");
    }
    
    @Test
    public void testShouldDivideNegativeAndPositiveNumbers() {
        calc = new Calculator("-8÷3");
        assertEquals(calc.calculate(), "-2.6666666666666665");
    }
    
    @Test
    public void testShouldThrowsArithmeticExceptionWhenDivisionByZero() {
        calc = new Calculator("-4÷0");
        assertThrows(ArithmeticException.class, () -> calc.calculate());
    }
    
    @Test
    public void testShouldCalculateRootOfPositiveNumbers() {
        calc = new Calculator("√144");
        assertEquals(calc.calculate(), "12.0");
    }
    
    @Test
    public void testShouldThrowsArithmeticExceptionWhenCalculatingRootOfNegativeNumbers() {
        calc = new Calculator("√-9");
        assertThrows(ArithmeticException.class, () -> calc.calculate());
    }
    
    @Test
    public void testShouldCalculateCompleteExpression() {
        calc = new Calculator("√(9×((5²+7)÷(38+5%)+3))");
        assertEquals(calc.calculate(), "5.849619228016636");
    }
}
