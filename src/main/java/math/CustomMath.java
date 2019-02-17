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
package math;

/**
 *
 * @author richard
 */
public class CustomMath {
    
    public static double abs(double number) {
        return number < 0 ? - number : number;
    }
    
    public static double inc(double number) {
        return ++number;
    }
    
    public static double dec(double number) {
        return --number;
    }
    
    public static double sum(double a, double b) {
        if (a == 0)
            return b;
        
        if(a < 0)
            return sum(inc(a), dec(b));
        
        return sum(dec(a), inc(b));
    }
    
    public static double sub(double a, double b) {
        if (a == 0)
            return (-b);
        
        if(a < 0)
            return sub(inc(a), inc(b));
        
        return sub(dec(a), dec(b));
    }
}
