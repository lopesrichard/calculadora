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

package app.src.util;

import app.src.constants.Symbol;
import app.src.exceptions.ConstantNotFoundException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 *
 * @author richard
 */
public class SymbolChecker {
    
    private final Symbol INPUT;
    
    private final String STR;
    
    public SymbolChecker(String str, Symbol input) {
        this.INPUT = input;
        this.STR = str;
    }
    
    public boolean check() {
        
        if (INPUT == Symbol.ROOT) {
            return true;
        }
        
        if (!STR.equals("")) {
            return verifyLastChar();
        }
        
        return INPUT == Symbol.SUM || INPUT == Symbol.SUB;
    }
    
    private boolean verifyLastChar() {
        Symbol last;
        try {
            
            last = Symbol.fromChar(STR.charAt(STR.length() - 1));
            
            if (INPUT == Symbol.SUM || INPUT == Symbol.SUB) {
                return last == Symbol.ROOT ||
                      (last != Symbol.SUM && last != Symbol.SUB && last != Symbol.COMMA);
            }

            if (INPUT == Symbol.MULT || INPUT == Symbol.DIV) {
                return (last != Symbol.ROOT && last != Symbol.SUM  &&
                        last != Symbol.SUB  && last != Symbol.MULT &&
                        last != Symbol.DIV  && last != Symbol.COMMA);
            }
            
            return false;
        
        }catch (ConstantNotFoundException e) {            
            return e.getCode().matches("\\d");
        }
    }
    
    public boolean checkParenthesis() {
        if (INPUT == Symbol.OPENPAR) {
            return true;
        }
        
        Matcher m = Pattern.compile("(\\()|(\\))").matcher(STR);
        
        int open = 0;
        int close = 0;

        while(m.find()) {
            if (m.group(1) != null) {
                open++;
            }
            if (m.group(2) != null) {
                close++;
            }
        }
        
        return open > close;
    }
}
