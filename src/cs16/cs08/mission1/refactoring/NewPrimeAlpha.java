package cs16.cs08.mission1.refactoring;

import java.util.HashSet;
import java.util.Set;

public class NewPrimeAlpha {

    public static boolean isPrime(int number) {
        Set<Integer> primeSet = new HashSet<Integer>(){ {add(1); add(number);} };

        return number > 1 && NewClassifierAlpha.factors(number).equals(primeSet);
    }

    public static void main(String[] args) {
        int i = 1;
        while (i <= 100) {
            System.out.println(i + ": " + isPrime(i));
            i++;
        }
    }
}
