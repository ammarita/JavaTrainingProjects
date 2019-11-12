package fractioncalcapp;

public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;

        if(denominator == 0) {
            throw new IllegalArgumentException("Denominator can't be 0!");
        }

        if(denominator < 0) {
            this.numerator *= -1;
            this.denominator *= -1;
        }
    }

    public Fraction(int numerator) {
        this.numerator = numerator;
        this.denominator = 1;
    }

    public Fraction() {
        this.numerator = 0;
        this.denominator = 1;
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    public double toDouble() {
        return numerator / denominator;
    }

    public Fraction add(Fraction other) {
        int num = this.numerator * other.denominator + other.numerator * this.denominator;
        int den = this.denominator * other.denominator;
        return new Fraction(num, den);
    }

    public Fraction subtract(Fraction other) {
        int num = this.numerator * other.denominator - other.numerator * this.denominator;
        int den = this.denominator * other.denominator;
        return new Fraction(num, den);
    }

    public Fraction multiply(Fraction other) {
        int num = this.numerator * other.numerator;
        int den = this.denominator * other.denominator;
        return new Fraction(num, den);
    }

    public Fraction divide(Fraction other) {
        int num = this.numerator * other.denominator;
        int den = this.denominator * other.numerator;
        return new Fraction(num, den);
    }

    // method determines whether or not two fractions are equal
    @Override
    public boolean equals(Object other) {
        boolean isEqual = false;

        if(other instanceof Fraction) {
            if(this.numerator / this.denominator == ((Fraction) other).numerator / ((Fraction) other).denominator) {
                isEqual = true;
            }
        }

        return isEqual;
    }

    //converts the current fraction to the lowest terms
    public void toLowestTerms() {
        numerator /= gcd(numerator, denominator);
        denominator /= gcd(numerator,denominator);
    }

    //method to find greatest common divisor (factor) by Euclidean algorithm
    private static int gcd(int num, int den){
        while(num != 0 && den != 0) {
            int reminder = num % den;
            num = den;
            den = reminder;
        }
        return num;
    }
}