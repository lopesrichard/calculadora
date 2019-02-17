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


import constants.Symbol;
import exceptions.ConstantNotFoundException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import math.CustomMath;

/**
 *
 * @author richard
 */
public class Calculator {
    
    private String expression;
    
    public Calculator(String expression) {
        this.expression = '(' + expression.replace(",", ".") + ')';
    }
    
    public String calculate() {
       Matcher m = Pattern.compile("(\\([^()]+\\))").matcher(expression);
       if(!m.find()) {
           return expression;
       }

       String result = m.group(1);
       expression = expression.replace(result, calculateExpression(result));
       return calculate();
    }
    
    private String calculateExpression(String expression) {
        String operations;
        expression = calculatePostFix(expression);
        
        operations = Symbol.MULT.toString() + Symbol.DIV.toString();
        expression = calculateArithmetic(expression, operations);
        
        operations = Symbol.SUM.toString() + Symbol.SUB.toString();
        expression = calculateArithmetic(expression, operations);
        
        return expression.replace("(", "").replace(")", "");
    }
    
    private String calculatePostFix(String expression) {
        String operations = Symbol.SQUARE.toString() + Symbol.PERC.toString();
        Matcher m = Pattern.compile("(\\(*(\\d+(\\.?\\d+)?)(["+operations+"])\\)*)").matcher(expression);
        
        if (!m.find()) {
            return expression;
        }
    
        Double value = 0.0;
        try{
            switch(Symbol.fromChar(m.group(4).charAt(0))) {
                case SQUARE:
                    value = Math.pow(Double.parseDouble(m.group(2)), 2);
                    break;
                case PERC:
                    value = Double.parseDouble(m.group(2)) / 100;
                    break;
            } 
        } catch(ConstantNotFoundException e) {
            return Symbol.NAN.toString();
        }
            
        return calculatePostFix(expression.replace(m.group(1), String.valueOf(value)));
    }
    
    private String calculateArithmetic(String expression, String operations) {
        Matcher m = Pattern.compile("(\\(*([+-]?\\d+(\\.?\\d+)?)(["+operations+"])([+-]?\\d+(\\.?\\d+)?)\\)*)").matcher(expression);
        
        if (!m.find()) {
            return expression;
        }
    
        Double value = 0.0;
        try{
             switch(Symbol.fromChar(m.group(4).charAt(0))) {
                case SUM:
                    value = CustomMath.sum(Double.parseDouble(m.group(2)), Double.parseDouble(m.group(5)));
                    break;
                case SUB:
                    value = CustomMath.sub(Double.parseDouble(m.group(2)), Double.parseDouble(m.group(5)));
                    break;
                case MULT:
                    value = Double.parseDouble(m.group(2)) * Double.parseDouble(m.group(5));
                    break;
                case DIV:
                    value = Double.parseDouble(m.group(2)) / Double.parseDouble(m.group(5));
                    break;
            }
        } catch (ConstantNotFoundException e) {
            return Symbol.NAN.toString();
        }
            
        return calculateArithmetic(expression.replace(m.group(1), String.valueOf(value)), operations);
    }
}
