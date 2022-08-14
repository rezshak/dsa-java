package main.java.numeric;

import java.util.ArrayList;
import java.util.List;

final class PrimeFactors {

    static List<Integer> primeFactors(int num) {
        List<Integer> primeFactors = new ArrayList<>();
        for (int i = 2; i< num; i++) {
            while(num % i == 0) {
                primeFactors.add(i);
                num /= i;
            }
        }
        if (num > 2) primeFactors.add(num);
        return primeFactors;
    }

    public static void main(String[] args) {
        System.out.println(primeFactors(24));
    }

}
