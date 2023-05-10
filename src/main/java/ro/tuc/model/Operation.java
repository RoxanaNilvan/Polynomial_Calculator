package ro.tuc.model;
import ro.tuc.model.Monomial;
import ro.tuc.model.Polynomial;

import java.util.HashMap;

public class Operation {
    public static Polynomial add(Polynomial p1, Polynomial p2) {
        Polynomial result = new Polynomial();
        for (HashMap.Entry<Integer, Monomial> entry : p1.getPolynomials().entrySet()) {
            int degree = entry.getKey();
            Monomial monomial = entry.getValue();

            result.addMonomial(new Monomial(degree, monomial.getCoefficient()));
        }

        for (HashMap.Entry<Integer, Monomial> entry : p2.getPolynomials().entrySet()) {
            int degree = entry.getKey();
            Monomial monomial = entry.getValue();

            if (result.getPolynomials().containsKey(degree)) {
                Monomial existingMonomial = result.getPolynomials().get(degree);
                double newCoefficient = existingMonomial.getCoefficient() + monomial.getCoefficient();
                result.getPolynomials().put(degree, new Monomial(degree, newCoefficient));
            }
            else {
                result.addMonomial(new Monomial(degree, monomial.getCoefficient()));
            }
        }
        result.removeMonomialsWithZeroCoefficient();
        return result;
    }

    public static Polynomial subtract(Polynomial polynomial1, Polynomial polynomial2){
        Polynomial result = new Polynomial();

        for(HashMap.Entry<Integer, Monomial> entry : polynomial1.getPolynomials().entrySet()){
            int degree = entry.getKey();
            Monomial monomial = entry.getValue();

            result.addMonomial(new Monomial(degree, monomial.getCoefficient()));
        }
        for(HashMap.Entry<Integer, Monomial> entry : polynomial2.getPolynomials().entrySet()){
            int degree = entry.getKey();
            Monomial monomial = entry.getValue();

            if(result.getPolynomials().containsKey(degree)){
                Monomial existingMonomial = result.getPolynomials().get(degree);
                double newCoefficient = existingMonomial.getCoefficient() - monomial.getCoefficient();
                result.getPolynomials().put(degree, new Monomial(degree, newCoefficient));
            }
            else {
                monomial.setCoefficient(monomial.getCoefficient() * (-1));
                result.addMonomial(new Monomial(degree, monomial.getCoefficient()));
            }
        }

        result.removeMonomialsWithZeroCoefficient();
        return result;
    }

    public static Polynomial multiplication(Polynomial polynomial1, Polynomial polynomial2){
        Polynomial result = new Polynomial();

        for(HashMap.Entry<Integer, Monomial> entry1 : polynomial1.getPolynomials().entrySet()){
            int degreeMonomial1 = entry1.getKey();
            Monomial monomial1 = entry1.getValue();

            for(HashMap.Entry<Integer, Monomial> entry2  : polynomial2.getPolynomials().entrySet()){
                int degreeMonomial2 = entry2.getKey();
                Monomial monomial2 = entry2.getValue();

                int newDegree = degreeMonomial1 + degreeMonomial2;
                double coefficient = monomial1.getCoefficient() * monomial2.getCoefficient();
                if(result.getPolynomials().containsKey(newDegree)){
                    Monomial currentMonomial = result.getPolynomials().get(newDegree);
                    double newCoefficient = currentMonomial.getCoefficient() + coefficient;
                    result.getPolynomials().put(newDegree, new Monomial(newDegree, newCoefficient));
                } else{
                    result.addMonomial(new Monomial(newDegree, coefficient));
                }
            }
        }
        result.removeMonomialsWithZeroCoefficient();
        return result;
    }

    public static Polynomial multiplyWithMonomial(Polynomial polynomial, Monomial monomial) {
        Polynomial resultPolynomial = new Polynomial();

        for (int degree : polynomial.getPolynomials().keySet()) {
            Monomial auxiliaryMonomial = polynomial.getPolynomials().get(degree);
            int newDegree = degree + monomial.getDegree();
            double newCoefficient = auxiliaryMonomial.getCoefficient() * monomial.getCoefficient();

            if (newCoefficient != 0) {
                Monomial newMonomial = new Monomial(newDegree, newCoefficient);
                resultPolynomial.addMonomial(newMonomial);
            }
        }

        return resultPolynomial;
    }


    public static Polynomial[] divide(Polynomial polynomial1, Polynomial polynomial2) {
        Polynomial[] polynomials = new Polynomial[2];
        Polynomial rest = new Polynomial();

        while (polynomial1.degree() >= polynomial2.degree()){
            Monomial firstMaxMonomial = polynomial1.getLeadingCoefficient();
            Monomial secondMaxMonomial = polynomial2.getLeadingCoefficient();
            Monomial divideMonomials = firstMaxMonomial.divideMonomials(secondMaxMonomial);

            rest.addMonomial(divideMonomials);

            Polynomial multiply = multiplyWithMonomial(polynomial2, divideMonomials);

            polynomial1 = subtract(polynomial1, multiply);
        }

        polynomials[0] = rest;
        polynomials[1] = polynomial1;

        return polynomials;
    }

    public static Polynomial derivative(Polynomial polynomial){
        Polynomial result = new Polynomial();

        for(HashMap.Entry<Integer, Monomial> entry : polynomial.getPolynomials().entrySet()){
            int degree = entry.getKey();
            Monomial monomial = entry.getValue();

            if(degree > 0){
                double newCoefficient = monomial.getCoefficient() * degree;
                degree--;
                result.addMonomial(new Monomial(degree, newCoefficient));
            }
        }
        result.removeMonomialsWithZeroCoefficient();
        return result;
    }

    public static Polynomial integral(Polynomial polynomial){
        Polynomial result = new Polynomial();

        for(HashMap.Entry<Integer, Monomial> entry : polynomial.getPolynomials().entrySet()){
            int degree = entry.getKey();
            Monomial monomial = entry.getValue();
            degree++;
            double newCoefficient = monomial.getCoefficient()/ degree;
            result.addMonomial(new Monomial(degree, newCoefficient));
        }
        result.removeMonomialsWithZeroCoefficient();
        return result;
    }

}
