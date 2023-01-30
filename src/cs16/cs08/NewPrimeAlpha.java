package cs16.cs08;

import java.util.HashSet;
import java.util.Set;

public class NewPrimeAlpha {
    private int number;

    public NewPrimeAlpha(int number) {
        this.number = number;
    }

    public boolean isPrime() {
        Set<Integer> primeSet = new HashSet<Integer>(){ {add(1); add(number);} };

        // 이렇게 하는게 맞나..?
        NewClassifierAlpha newClassifierAlpha = new NewClassifierAlpha();
        return number > 1 && newClassifierAlpha.factors(number).equals(primeSet);
    }

//    public boolean isFactor(int potentialFactor) {
//        return number % potentialFactor == 0;
//    }
//
//    public Set<Integer> factors() {
//        HashSet<Integer> factors = new HashSet<>();
//        for (int pod=1; pod <= Math.sqrt(number); pod++) {
//            if (isFactor(pod)) {
//                factors.add(pod);
//                factors.add(number / pod);
//            }
//        }
//        return factors;
//    }

    public static void main(String[] args) {
//        NewPrimeAlpha prime1 = new NewPrimeAlpha(10);
//        NewPrimeAlpha prime2 = new NewPrimeAlpha(7);
//
//        System.out.println(prime1.isPrime());
//        System.out.println(prime2.isPrime());
        int i = 1;
        while (i <= 100) {
            NewPrimeAlpha prime = new NewPrimeAlpha(i);
            System.out.println(prime.isPrime());
            i++;
        }
    }
}
