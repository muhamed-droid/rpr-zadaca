package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExpressionEvaluatorTest {

    @Test
    public void Test1(){
        ExpressionEvaluator el = new ExpressionEvaluator();
        Assertions.assertEquals(101.0, el.evaluate("( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) ) "));
    }

    @Test
    public void Test2(){
        ExpressionEvaluator el = new ExpressionEvaluator();
        Assertions.assertEquals(2.0, el.evaluate("    ( 10 / 5 ) "));
    }

    @Test
    public void Test3(){
        ExpressionEvaluator el = new ExpressionEvaluator();
        Throwable exception = Assertions.assertThrows(RuntimeException.class,
                ()->{el.evaluate("(1+((2+3)*(4*5)))");});
    }

    @Test
    public void Test4(){
        ExpressionEvaluator el = new ExpressionEvaluator();
        Throwable exception = Assertions.assertThrows(RuntimeException.class,
                ()->{el.evaluate("( 1 + ( ( 2iu76 + 3 ) * ( 4 * 5 ) ) )");});
    }

    @Test void Test5(){
        ExpressionEvaluator el = new ExpressionEvaluator();
        Assertions.assertEquals(2.625, el.evaluate("    ( 10.5 / 4 ) "));
    }

    @Test void Test6(){
        ExpressionEvaluator el = new ExpressionEvaluator();
        Assertions.assertEquals(4.0, el.evaluate(" ( 16 sqrt )"));
    }

}
