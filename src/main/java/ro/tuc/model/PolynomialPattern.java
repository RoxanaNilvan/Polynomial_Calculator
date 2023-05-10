package ro.tuc.model;
import java.util.regex.*;

public class PolynomialPattern {
    public static Polynomial parse(String givenString) {
        Polynomial result = new Polynomial();
        String pattern = "([+-]?\\d*\\.?\\d*)x\\^(\\d+)";
        Pattern r = Pattern.compile(pattern);
        Matcher m1 = r.matcher(givenString);
        while (m1.find()) {
            String coefficientString = m1.group(1);
            String degreeString = m1.group(2);
            double coefficient;
            if (coefficientString.equals("")) {
                coefficient = 1.0;
            } else if (coefficientString.equals("-")) {
                coefficient = -1.0;
            } else {
                coefficient = Double.parseDouble(coefficientString);
            }
            int degree = Integer.parseInt(degreeString);
            Monomial monomial = new Monomial(degree, coefficient);
            result.addMonomial(monomial);
        }
        return result;
    }
}
