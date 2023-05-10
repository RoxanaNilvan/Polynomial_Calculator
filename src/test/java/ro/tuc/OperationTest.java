package ro.tuc;

import org.junit.jupiter.api.Test;
import ro.tuc.model.Monomial;
import ro.tuc.model.Operation;
import ro.tuc.model.Polynomial;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OperationTest {
    @Test
    public void addTest(){
        Polynomial p1 = new Polynomial();
        p1.addMonomial(new Monomial(5, 4.0));
        p1.addMonomial(new Monomial(4, -3.0));
        p1.addMonomial(new Monomial(2, 1.0));
        p1.addMonomial(new Monomial(1, -8.0));
        p1.addMonomial(new Monomial(0, 1.0));

        Polynomial p2 = new Polynomial();
        p2.addMonomial(new Monomial(4, 3.0));
        p2.addMonomial(new Monomial(3, -1.0));
        p2.addMonomial(new Monomial(1, 2.0));
        p2.addMonomial(new Monomial(2, 1.0));
        p2.addMonomial(new Monomial(0, -1.0));

        Polynomial p3 = new Polynomial();
        p3.addMonomial(new Monomial(1, -6));
        p3.addMonomial(new Monomial(2, 2));
        p3.addMonomial(new Monomial(3, -1));
        p3.addMonomial(new Monomial(5, 4));

        Polynomial result = Operation.add(p1, p2);
        String res = result.toString();
        String exp = p3.toString();

        assertEquals(exp, res);
    }

    @Test
    public void subtractTest(){
        Polynomial p1 = new Polynomial();
        p1.addMonomial(new Monomial(5, 4.0));
        p1.addMonomial(new Monomial(4, -3.0));
        p1.addMonomial(new Monomial(2, 1.0));
        p1.addMonomial(new Monomial(1, -8.0));
        p1.addMonomial(new Monomial(0, 1.0));

        Polynomial p2 = new Polynomial();
        p2.addMonomial(new Monomial(4, 3.0));
        p2.addMonomial(new Monomial(3, -1.0));
        p2.addMonomial(new Monomial(1, 2.0));
        p2.addMonomial(new Monomial(2, 1.0));
        p2.addMonomial(new Monomial(0, -1.0));

        Polynomial p3 = new Polynomial();
        p3.addMonomial(new Monomial(0, 2));
        p3.addMonomial(new Monomial(1, -10));
        p3.addMonomial(new Monomial(3, 1));
        p3.addMonomial(new Monomial(4, -6));
        p3.addMonomial(new Monomial(5, 4));

        Polynomial result = Operation.subtract(p1, p2);
        String res = result.toString();
        String exp = p3.toString();

        assertEquals(exp, res);

    }

    @Test
    public void multiplicationTest(){
        Polynomial p1 = new Polynomial();
        p1.addMonomial(new Monomial(2, 3.0));
        p1.addMonomial(new Monomial(1, 2.0));
        p1.addMonomial(new Monomial(0, 1.0));

        Polynomial p2 = new Polynomial();
        p2.addMonomial(new Monomial(1, -1.0));
        p2.addMonomial(new Monomial(0, 2.0));

        Polynomial expected = new Polynomial();
        expected.addMonomial(new Monomial(3, -3.0));
        expected.addMonomial(new Monomial(2, 4.0));
        expected.addMonomial(new Monomial(1, 3.0));
        expected.addMonomial(new Monomial(0, 2.0));

        Polynomial result = Operation.multiplication(p1, p2);
        String res = result.toString();
        String exp = expected.toString();
        assertEquals(exp, res);
    }

    @Test
    public void divisionTest(){
        Polynomial p3 = new Polynomial();
        p3.addMonomial(new Monomial(3, 1));
        p3.addMonomial(new Monomial(2, -2));
        p3.addMonomial(new Monomial(1, 6));
        p3.addMonomial(new Monomial(0, -5));

        Polynomial p4 = new Polynomial();
        p4.addMonomial(new Monomial(2, 1));
        p4.addMonomial(new Monomial(0, -1));

        Polynomial []result = Operation.divide(p3, p4);

        Polynomial expectedCat = new Polynomial();
        expectedCat.addMonomial(new Monomial(1, 1));
        expectedCat.addMonomial(new Monomial(0, -2));

        Polynomial expectedRest = new Polynomial();
        expectedRest.addMonomial(new Monomial(1, 7));
        expectedRest.addMonomial(new Monomial(0, -7));

        String expCat = expectedCat.toString();
        String expRest = expectedRest.toString();
        String actualCat = result[0].toString();
        String actualRest = result[1].toString();

        assertEquals(expCat, actualCat);
        assertEquals(expRest, actualRest);
    }

    @Test
    public void derivativeTest(){
        Polynomial p1 = new Polynomial();
        p1.addMonomial(new Monomial(5, 4.0));
        p1.addMonomial(new Monomial(4, -3.0));
        p1.addMonomial(new Monomial(2, 1.0));
        p1.addMonomial(new Monomial(1, -8.0));
        p1.addMonomial(new Monomial(0, 1.0));

        Polynomial p3 = new Polynomial();
        p3.addMonomial(new Monomial(0, -8));
        p3.addMonomial(new Monomial(1, 2));
        p3.addMonomial(new Monomial(3, -12));
        p3.addMonomial(new Monomial(4, 20));

        Polynomial result = Operation.derivative(p1);
        String res = result.toString();
        String exp = p3.toString();

        assertEquals(exp, res);

    }

    @Test
    public void integrateTest(){
        Polynomial p1 = new Polynomial();
        p1.addMonomial(new Monomial(5, 4.0));
        p1.addMonomial(new Monomial(4, -3.0));
        p1.addMonomial(new Monomial(2, 1.0));
        p1.addMonomial(new Monomial(1, -8.0));
        p1.addMonomial(new Monomial(0, 1.0));

        Polynomial p3 = new Polynomial();
        p3.addMonomial(new Monomial(1, 1));
        p3.addMonomial(new Monomial(2, -4));
        p3.addMonomial(new Monomial(3, 0.3333333333333333));
        p3.addMonomial(new Monomial(5, -0.6));
        p3.addMonomial(new Monomial(6, 0.6666666666666666));

        Polynomial result = Operation.integral(p1);
        String res = result.toString();
        String exp = p3.toString();

        assertEquals(exp, res);
    }
}
