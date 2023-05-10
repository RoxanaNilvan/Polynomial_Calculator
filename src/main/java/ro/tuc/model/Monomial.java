package ro.tuc.model;

public class Monomial  {
    private int degree;
    private double coefficient;

    public Monomial(int degree, double coefficient) {
        this.degree = degree;
        this.coefficient = coefficient;
    }

    public int getDegree() {
        return degree;
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }

    public double getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(double coefficient) {
        this.coefficient = coefficient;
    }

    public Monomial divideMonomials(Monomial monom) {
        int resultDegree = degree - monom.getDegree();
        double resultCoefficient = coefficient / monom.getCoefficient();

        return new Monomial(resultDegree, resultCoefficient);
    }

    @Override
    public String toString() {
        return "Monomial{" +
                "degree=" + degree +
                ", coefficient=" + coefficient +
                '}';
    }
}
