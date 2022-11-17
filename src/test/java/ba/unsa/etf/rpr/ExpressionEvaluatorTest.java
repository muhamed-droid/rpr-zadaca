package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * This class is for testing ExpressionEvaluator class
 * @author Muhamed Masnopita
 */

public class ExpressionEvaluatorTest {


    /**
     * This is a method that tests if method evaluates calculates correct
     *
     */
    @Test
    public void Test1(){
        ExpressionEvaluator el = new ExpressionEvaluator();
        Assertions.assertEquals(101.0, el.evaluate("( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) ) "));
    }

    /**
     * This is a method that tests if method evaluates calculates correct
     *
     */
    @Test
    public void Test2(){
        ExpressionEvaluator el = new ExpressionEvaluator();
        Assertions.assertEquals(2.0, el.evaluate("    ( 10 / 5 ) "));
    }

    /**
     * This is a method that tests if method evaluates calculates correct
     *
     */
    @Test
    public void Test3(){
        ExpressionEvaluator el = new ExpressionEvaluator();
        Throwable exception = Assertions.assertThrows(RuntimeException.class,
                ()->{el.evaluate("(1+((2+3)*(4*5)))");});
    }

    /**
     * This is a method that tests if method evaluates calculates correct
     *
     */
    @Test
    public void Test4(){
        ExpressionEvaluator el = new ExpressionEvaluator();
        Throwable exception = Assertions.assertThrows(RuntimeException.class,
                ()->{el.evaluate("( 1 + ( ( 2iu76 + 3 ) * ( 4 * 5 ) ) )");});
    }

    /**
     * This is a method that tests if method evaluates calculates correct
     *
     */
    @Test
    public void Test5(){
        ExpressionEvaluator el = new ExpressionEvaluator();
        Assertions.assertEquals(2.625, el.evaluate("    ( 10.5 / 4 ) "));
    }

    /**
     * This is a method that tests if method evaluates calculates correct
     *
     */
    @Test
    public void Test6(){
        ExpressionEvaluator el = new ExpressionEvaluator();
        Assertions.assertEquals(4.0, el.evaluate(" ( 16 sqrt )"));
    }

    /**
     * This is a method that tests if method evaluates calculates correct
     *
     */
    @Test
    public void Test7(){
        ExpressionEvaluator el = new ExpressionEvaluator();
        Throwable exception = Assertions.assertThrows(RuntimeException.class,
                ()->{el.evaluate("( 1 + 2 + 3 )");});
    }

    /**
     * This is a method that tests if method evaluates calculates correct
     *
     */
    @Test
    public void Test8(){
        ExpressionEvaluator el = new ExpressionEvaluator();
        Throwable exception = Assertions.assertThrows(RuntimeException.class,
                ()->{el.evaluate("( 1 + 2 * / 1 )");});
    }

    /**
     * This is a method that tests if method evaluates calculates correct
     *
     */
    @Test
    public void Test9(){
        ExpressionEvaluator el = new ExpressionEvaluator();
        Assertions.assertEquals(5.0, el.evaluate("( ( 4 sqrt ) + ( 21 / 7 ) )"));
    }

    /**
     * This is  a method that tests if method evaluates calculates correct
     *
     */
    @Test
    public void Test10(){
        ExpressionEvaluator el = new ExpressionEvaluator();
        Assertions.assertEquals(101.0, el.evaluate(" ( 1 + ( 5 * 20 ) )"));
    }

}
