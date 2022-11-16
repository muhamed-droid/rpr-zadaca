package ba.unsa.etf.rpr;

import java.util.Stack;

import static java.lang.String.valueOf;

public class ExpressionEvaluator {


    private java.util.Stack operands;
    private java.util.Stack vals;

    public ExpressionEvaluator(){
        operands = new Stack<String>();
        vals = new Stack<Double> ();
    }

    public Double evaluate(String string){
        string = string.trim();
        if(!string.startsWith("(")) {
            throw new RuntimeException("Nevalidan unos");
        }



        boolean razmak = false;

        for(int i = 0; i < string.length(); i++) {
            String s = "";

            //validacija razmaka
            if(string.charAt(i)==' ' && string.charAt(i+1)==' ') throw new RuntimeException("Nevalidan unos");


            //hvatanje stringa koji se nalazi izmedju razmaka u jedan string
            while (string.charAt(i) != ' ') {
                s = s + string.charAt(i);
                if (i == string.length() - 1) break;
                i++;
            }

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
                } else vals.push(Double.parseDouble(s));
            } else {
                throw new RuntimeException("Nevalidan unos");
            }
        }

        return (Double) vals.pop();
    }
}
