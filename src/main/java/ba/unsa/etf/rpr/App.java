package ba.unsa.etf.rpr;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Scanner ulaz = new Scanner(System.in);
        String ulazniString = ulaz.nextLine();
        ExpressionEvaluator ev = new ExpressionEvaluator();
        System.out.println(ev.evaluate(ulazniString));

            /* for(int i = 0; i < ulazniString.length(); i++){
                String s="";
                while(ulazniString.charAt(i)>='0' &&ulazniString.charAt(i)<='9' || ulazniString.charAt(i)=='.') {
                    s=s+ulazniString.charAt(i);
                    if(i==ulazniString.length()-1) break;
                    i++;
                }
                Double broj = Double.parseDouble(s);
                System.out.println(broj);
            } */


    }
}
