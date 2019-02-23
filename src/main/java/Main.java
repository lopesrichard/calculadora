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
import util.SymbolChecker;
import exceptions.ConstantNotFoundException;

/**
 *
 * @author richard
 */
public class Main extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        ScreenPanel = new javax.swing.JPanel();
        Screen = new javax.swing.JTextField();
        ResultPanel = new javax.swing.JScrollPane();
        ResultScreen = new javax.swing.JTextArea();
        MainPanel = new javax.swing.JPanel();
        one = new javax.swing.JButton();
        two = new javax.swing.JButton();
        three = new javax.swing.JButton();
        division = new javax.swing.JButton();
        backspace = new javax.swing.JButton();
        clear = new javax.swing.JButton();
        four = new javax.swing.JButton();
        five = new javax.swing.JButton();
        six = new javax.swing.JButton();
        multiplication = new javax.swing.JButton();
        openParenthesis = new javax.swing.JButton();
        closeParenthesis = new javax.swing.JButton();
        seven = new javax.swing.JButton();
        eight = new javax.swing.JButton();
        nine = new javax.swing.JButton();
        sum = new javax.swing.JButton();
        square = new javax.swing.JButton();
        squareRoot = new javax.swing.JButton();
        zero = new javax.swing.JButton();
        comma = new javax.swing.JButton();
        percentage = new javax.swing.JButton();
        subtraction = new javax.swing.JButton();
        equals = new javax.swing.JButton();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ScreenPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        Screen.setEditable(false);
        Screen.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        Screen.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        ResultScreen.setEditable(false);
        ResultScreen.setColumns(20);
        ResultScreen.setRows(5);
        ResultPanel.setViewportView(ResultScreen);

        javax.swing.GroupLayout ScreenPanelLayout = new javax.swing.GroupLayout(ScreenPanel);
        ScreenPanel.setLayout(ScreenPanelLayout);
        ScreenPanelLayout.setHorizontalGroup(
            ScreenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ScreenPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ScreenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ResultPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(Screen, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE))
                .addContainerGap())
        );
        ScreenPanelLayout.setVerticalGroup(
            ScreenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ScreenPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ResultPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Screen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        MainPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        MainPanel.setLayout(new java.awt.GridLayout(4, 6));

        one.setText("1");
        one.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertNumber(evt);
            }
        });
        MainPanel.add(one);

        two.setText("2");
        two.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertNumber(evt);
            }
        });
        MainPanel.add(two);

        three.setText("3");
        three.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertNumber(evt);
            }
        });
        MainPanel.add(three);

        division.setText("÷");
        division.setActionCommand("DIV");
        division.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertSymbol(evt);
            }
        });
        MainPanel.add(division);

        backspace.setText("⟵");
        backspace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backspaceButton(evt);
            }
        });
        MainPanel.add(backspace);

        clear.setText("C");
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearScreen(evt);
            }
        });
        MainPanel.add(clear);

        four.setText("4");
        four.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertNumber(evt);
            }
        });
        MainPanel.add(four);

        five.setText("5");
        five.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertNumber(evt);
            }
        });
        MainPanel.add(five);

        six.setText("6");
        six.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertNumber(evt);
            }
        });
        MainPanel.add(six);

        multiplication.setText("×");
        multiplication.setActionCommand("MULT");
        multiplication.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertSymbol(evt);
            }
        });
        MainPanel.add(multiplication);

        openParenthesis.setText("(");
        openParenthesis.setActionCommand("OPENPAR");
        openParenthesis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertParenthesis(evt);
            }
        });
        MainPanel.add(openParenthesis);

        closeParenthesis.setText(")");
        closeParenthesis.setActionCommand("CLOSEPAR");
        closeParenthesis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertParenthesis(evt);
            }
        });
        MainPanel.add(closeParenthesis);

        seven.setText("7");
        seven.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertNumber(evt);
            }
        });
        MainPanel.add(seven);

        eight.setText("8");
        eight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertNumber(evt);
            }
        });
        MainPanel.add(eight);

        nine.setText("9");
        nine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertNumber(evt);
            }
        });
        MainPanel.add(nine);

        sum.setText("+");
        sum.setActionCommand("SUM");
        sum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertSymbol(evt);
            }
        });
        MainPanel.add(sum);

        square.setText("x²");
        square.setActionCommand("SQUARE");
        square.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertSymbol(evt);
            }
        });
        MainPanel.add(square);

        squareRoot.setText("√");
        squareRoot.setActionCommand("ROOT");
        squareRoot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertSymbol(evt);
            }
        });
        MainPanel.add(squareRoot);

        zero.setText("0");
        zero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertNumber(evt);
            }
        });
        MainPanel.add(zero);

        comma.setText(",");
        comma.setActionCommand("COMMA");
        comma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertSymbol(evt);
            }
        });
        MainPanel.add(comma);

        percentage.setText("%");
        percentage.setActionCommand("PERC");
        percentage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertSymbol(evt);
            }
        });
        MainPanel.add(percentage);

        subtraction.setText("-");
        subtraction.setActionCommand("SUB");
        subtraction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertSymbol(evt);
            }
        });
        MainPanel.add(subtraction);

        equals.setText("=");
        equals.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calculateTotal(evt);
            }
        });
        MainPanel.add(equals);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(ScreenPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(ScreenPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void insertNumber(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertNumber
        insert(evt.getActionCommand().charAt(0));
    }//GEN-LAST:event_insertNumber

    private void insertSymbol(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertSymbol
        try {
            Symbol input = Symbol.fromStr(((javax.swing.JButton) evt.getSource()).getActionCommand());
            String text  = Screen.getText();
            SymbolChecker checker = new SymbolChecker(text, input);
            if (checker.check()) {
                insert(input.getValue());
            }
        } catch (ConstantNotFoundException e) {
            System.out.println(e.getMessage());
        }
       
    }//GEN-LAST:event_insertSymbol

    private void backspaceButton(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backspaceButton
        String text = Screen.getText();
        if (!text.equals("")) {
            Screen.setText(text.substring(0, text.length() - 1));
        }
    }//GEN-LAST:event_backspaceButton

    private void insertParenthesis(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertParenthesis
        try {
            Symbol input = Symbol.fromStr(((javax.swing.JButton) evt.getSource()).getActionCommand());
            String text  = Screen.getText();
            SymbolChecker checker = new SymbolChecker(text, input);
            if (checker.checkParenthesis()) {
                insert(input.getValue());
            }
        } catch (ConstantNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_insertParenthesis

    private void clearScreen(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearScreen
        Screen.setText("");
    }//GEN-LAST:event_clearScreen

    private void calculateTotal(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calculateTotal
        try {
            Calculator calc = new Calculator(Screen.getText());
            ResultScreen.setText(ResultScreen.getText() + Screen.getText() + " = " + calc.calculate() + "\n");
        } catch(ArithmeticException e) {
            ResultScreen.setText(ResultScreen.getText() + Screen.getText() + " = " + Symbol.NAN.getValue() + " (" + e.getMessage() + ")" + "\n");
        } catch(Exception e) {
            ResultScreen.setText(ResultScreen.getText() + Screen.getText() + " = " + Symbol.NAN.getValue() + " (Erro desconhecido)" + "\n");
        } finally {
            clearScreen(evt);
        }
       
    }//GEN-LAST:event_calculateTotal

    private void insert(char insert) {
        Screen.setText(Screen.getText() + insert);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel MainPanel;
    private javax.swing.JScrollPane ResultPanel;
    private javax.swing.JTextArea ResultScreen;
    private javax.swing.JTextField Screen;
    private javax.swing.JPanel ScreenPanel;
    private javax.swing.JButton backspace;
    private javax.swing.JButton clear;
    private javax.swing.JButton closeParenthesis;
    private javax.swing.JButton comma;
    private javax.swing.JButton division;
    private javax.swing.JButton eight;
    private javax.swing.JButton equals;
    private javax.swing.JButton five;
    private javax.swing.JButton four;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton multiplication;
    private javax.swing.JButton nine;
    private javax.swing.JButton one;
    private javax.swing.JButton openParenthesis;
    private javax.swing.JButton percentage;
    private javax.swing.JButton seven;
    private javax.swing.JButton six;
    private javax.swing.JButton square;
    private javax.swing.JButton squareRoot;
    private javax.swing.JButton subtraction;
    private javax.swing.JButton sum;
    private javax.swing.JButton three;
    private javax.swing.JButton two;
    private javax.swing.JButton zero;
    // End of variables declaration//GEN-END:variables
}
