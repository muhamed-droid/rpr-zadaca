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
        try{
            System.out.println(ev.evaluate(ulazniString));
        }catch(NumberFormatException e){
            throw new RuntimeException("Nevalidan unos");
        } catch(RuntimeException e){
            e.getMessage();
        }
   }
}
