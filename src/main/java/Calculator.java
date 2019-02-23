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
        this.expression = inicialTreatment(expression);
        
    }
    
    public final String inicialTreatment(String expression) {
        expression = putLastParenthesis(expression);
        expression = substituteComma(expression);
        expression = inferMultiplications(expression);
        
        return expression;
    }
    
    public String putLastParenthesis(String expression) {
        return '(' + expression + ')';
    }
    
    public String substituteComma(String expression) {
        Matcher m = Pattern.compile("(([\\d,]+)(,\\d+))").matcher(expression);
        while (m.find()) {
            expression = expression.replace(m.group(1), m.group(2).replace(",", "") + m.group(3).replace(",", "."));
        }
        expression = expression.replace(",", ".");
        return expression;
    }
    
    public String inferMultiplications(String expression) {
        Matcher m = Pattern.compile("(\\)\\()").matcher(expression);
        while (m.find()) {
            expression = expression.replace(m.group(1), ")" + Symbol.MULT.getValue() + "(");
        }
        return expression;
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
        expression = calculateSquare(expression);
        expression = calculateRoot(expression);
        expression = calculatePercentage(expression);
                
        operations = Symbol.MULT.toString() + Symbol.DIV.toString();
        expression = calculateArithmetic(expression, operations);
                
        operations = Symbol.SUM.toString() + Symbol.SUB.toString();
        expression = calculateArithmetic(expression, operations);
                
        return expression.replace("(", "").replace(")", "");
    }
    
    private String calculateSquare(String expression) {
        Matcher m = Pattern.compile("(\\(*(\\d+(\\.?\\d+)?)²\\)*)").matcher(expression);
        
        if (!m.find()) {
            return expression;
        }
    
        Double value = Math.pow(Double.parseDouble(m.group(2)), 2);
        return calculateSquare(expression.replace(m.group(1), String.valueOf(value)));
    }
    
    private String calculateRoot(String expression) {
        Matcher m = Pattern.compile("(\\(*" + Symbol.ROOT.getValue() + "([+-]?\\d+(\\.?\\d+)?)\\)*)").matcher(expression);
        
        if (!m.find()) {
            return expression;
        }
        
        double number = Double.parseDouble(m.group(2));
        
        if (number < 0) {
            throw new ArithmeticException("This application doesn't support complex numbers");
        }
    
        Double value = Math.sqrt(number);
        return calculateSquare(expression.replace(m.group(1), String.valueOf(value)));
    }
    
    private String calculatePercentage(String expression) {
        Matcher m = Pattern.compile("(\\(*((\\d+(\\.?\\d+)?)([+-]))?((\\d+(\\.?\\d+)?)%)\\)*)").matcher(expression);
        
        if (!m.find()) {
            return expression;
        }
        
        Double value = m.group(3) != null && (m.group(5).matches("[+-]"))
                     ? Double.parseDouble(m.group(3)) * (Double.parseDouble(m.group(7)) / 100)
                     : Double.parseDouble(m.group(7)) / 100;
        
        return calculatePercentage(expression.replace(m.group(6), String.valueOf(value)));
    }
    
    private String calculateArithmetic(String expression, String operations) {
        Matcher m = Pattern.compile("(\\(*(-?\\d+(\\.?\\d+)?)(["+operations+"])(-?\\d+(\\.?\\d+)?)\\)*)").matcher(expression);
        
        if (!m.find()) {
            return expression;
        }
    
        Double value = 0.0;
        try{
             switch(Symbol.fromChar(m.group(4).charAt(0))) {
                case SUM:
                    value = Double.parseDouble(m.group(2)) + Double.parseDouble(m.group(5));
                    break;
                case SUB:
                    value = Double.parseDouble(m.group(2)) - Double.parseDouble(m.group(5));
                    break;
                case MULT:
                    value = Double.parseDouble(m.group(2)) * Double.parseDouble(m.group(5));
                    break;
                case DIV:
                    double divisor = Double.parseDouble(m.group(5));
                    if (divisor == 0.0) {
                        throw new ArithmeticException("It's not possible divide by zero");
                    }
                    value = Double.parseDouble(m.group(2)) / divisor;
                    break;
            }
        } catch (ConstantNotFoundException e) {
            return Symbol.NAN.toString();
        }
            
        return calculateArithmetic(expression.replace(m.group(1), String.valueOf(value)), operations);
    }
}
