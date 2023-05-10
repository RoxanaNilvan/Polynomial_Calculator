package ro.tuc.model;
import ro.tuc.model.Monomial;

import java.util.HashMap;

public class Polynomial {
    private HashMap<Integer, Monomial> polynomials;

    public Polynomial() {
        polynomials = new HashMap<Integer, Monomial>();
    }

    public Polynomial(Monomial monomial) {
        polynomials = new HashMap<>();
        polynomials.put(monomial.getDegree(), monomial);

    }

    public HashMap<Integer, Monomial> getPolynomials() {
        return polynomials;
    }

    public void setPolynomials(HashMap<Integer, Monomial> polynomials) {
        this.polynomials = polynomials;
    }

    public void addMonomial(Monomial m){
        polynomials.put(m.getDegree(), m);
    }

    public void getMonomial(Monomial m){
        polynomials.get(m);
    }

    public int degree() {
        int degree = -1;
        for (int d : polynomials.keySet()) {
            if (d > degree) {
                degree = d;
            }
        }
        return degree;
    }

    public Monomial getLeadingCoefficient() {
        if (polynomials.isEmpty()) {
            return null;
        }
        int maxDegree = degree();
        return polynomials.get(maxDegree);
    }

    public void removeMonomialsWithZeroCoefficient() {
        polynomials.entrySet().removeIf(entry -> entry.getValue().getCoefficient() == 0.0);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int degree : polynomials.keySet()) {
            Monomial monomial = polynomials.get(degree);

            double coefficient = monomial.getCoefficient();
            if (coefficient == 0.0) {
                continue;
            }
            else if (coefficient > 0.0 && sb.length() > 0) {
                sb.append(" + ");
            }
            if (coefficient == 1.0 && degree > 0) {
                sb.append("x");
            }
            else if (coefficient == -1.0 && degree > 0) {
                sb.append("-x");
            }
            else {
                sb.append(coefficient);
                if (degree > 0) {
                    sb.append("x");
                }
            }
            if (degree > 1) {
                sb.append("^" + degree);
            }
        }
        if (sb.length() == 0) {
            sb.append("0");
        }
        return sb.toString();
    }
}