package ba.unsa.etf.rpr;

import java.util.Stack;

/**
 * Class for evaluating string!
 * @author Muhamed Masnopita
 */

public class ExpressionEvaluator {

    /**
     * stack where operands are being held
     *
     */
    private java.util.Stack operands;


    /**
     * stack where values are being held
     *
     */
    private java.util.Stack vals;



    /**
     * This is a constructor where stacks for keeping values and operands are created
     *
     */
    public ExpressionEvaluator(){
        operands = new Stack<String>();
        vals = new Stack<Double> ();
    }

    /**
     * This is a method that test if string is regular to work with
     * @return true if string is regular to work with, otherwise returns false
     * @param s
     */
    public boolean daLiJeValidan(String s){
        if(!s.startsWith("(")) return false;
        return true;
    }

    /**
     * This is method that evaluates string and calculate result
     * @return result of values in string
     * @param string
     */
    public Double evaluate(String string){
        string = string.trim();
        if(!daLiJeValidan(string)) {
            throw new RuntimeException("Nevalidan unos");
        }



        boolean razmak = false;



        for(int i = 0; i < string.length(); i++) {
            StringBuilder stringBuilder = new StringBuilder();

            //validacija razmaka
            if(string.charAt(i)==' ' && string.charAt(i+1)==' ') throw new RuntimeException("Nevalidan unos");


            //hvatanje stringa koji se nalazi izmedju razmaka u jedan string
            while (string.charAt(i) != ' ') {
                stringBuilder.append(string.charAt(i));
                if (i == string.length() - 1) break;
                i++;
            }

            String s = String.valueOf(stringBuilder);


            //validiranje na osnovu toga šta taj string sadrži
            boolean validan = false;
            if (s.equals("(") || s.equals("+") || s.equals("-")
                    || s.equals("/") || s.equals("sqrt") || s.equals(")") || s.equals("*")) {
                validan = true;
            } else {
                Double broj = Double.parseDouble(s);
                validan = true;
            }

            //postupak dijsktre ako je string validan
            if (validan == true) {
                if (s.equals("(")) ;
                else if (s.equals("+")) operands.push(s);
                else if (s.equals("-")) operands.push(s);
                else if (s.equals("*")) operands.push(s);
                else if (s.equals("/")) operands.push(s);
                else if (s.equals("sqrt")) operands.push(s);
                else if (s.equals(")")) {
                    String op = (String) operands.pop();
                    double v = (double) vals.pop();
                    if (op.equals("+")) v = (double) vals.pop() + v;
                    else if (op.equals("-")) v = (double) vals.pop() - v;
                    else if (op.equals("*")) v = (double) vals.pop() * v;
                    else if (op.equals("/")) v = (double) vals.pop() / v;
                    else if (op.equals("sqrt")) v = Math.sqrt(v);
                    vals.push(v);
                } else{
                    vals.push(Double.parseDouble(s));
                }
            } else {
                throw new RuntimeException("Nevalidan unos");
            }
        }
        //Ovo radimo jer je moguće da nešto ostane u steku, tada unos nije validan.
        //( 1 + 3 + 4 ) ne bi smio biti validan
        Double povratna = (Double) vals.pop();
        if(!vals.empty()) throw new RuntimeException("Nevalidan unos");
        return povratna;
    }

    public Stack getOperands() {
        return operands;
    }

    public void setOperands(Stack operands) {
        this.operands = operands;
    }

    public Stack getVals() {
        return vals;
    }

    public void setVals(Stack vals) {
        this.vals = vals;
    }
}
