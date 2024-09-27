package com.test.recursion;

/**
 * Given a number find its count of factors recursively
 */
public class CountOfFactors {


    public static void main(String[] args) {
        int a = 15;
        CountOfFactors cf = new CountOfFactors();
        System.out.println("Count of Factors of "+ a + " = "+cf.solve(a));
    }

    private int solve(int a) {

        return fact(a,1);
    }

    private int fact(int a, int i) {

        if(i * i > a)
            return 0;

        if(a%i == 0) {
            if(a/i == i) {
                return 1+fact(a,i+1);
            } else {
                return 2+fact(a,i+1);
            }
        }

        return fact(a, i+1);
    }
}
