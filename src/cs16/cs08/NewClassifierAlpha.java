package cs16.cs08;

import java.util.*;

public class NewClassifierAlpha {
    private int number;
    private int resultSum;

    public NewClassifierAlpha(){};
    public NewClassifierAlpha(int number) {
        this.number = number;
        this.resultSum = sumElements(factors(number)) - number;
    }

    public boolean isFactor(int potentialFactor) {
        return number % potentialFactor == 0;
    }

    // 내 생각으로는 factors()는 줄일 수 없을 것 같다..
    public HashSet<Integer> factors(int number) {
        HashSet<Integer> factors = new HashSet<>();
        for (int pod=1; pod <= Math.sqrt(number); pod++) {
            if (isFactor(pod)) {
                factors.add(pod);
                factors.add(number / pod);
            }
        }
        return factors;
    }

    static public int sumElements(Set<Integer> factors) {
        // mapToInt(): Stream 을 IntStream 으로 변환해준다.
        return factors.stream().mapToInt(e -> e).sum(); // 엄청 애먹음.
    }

    public boolean isPerfect() {
        return resultSum == number;
    }

    public boolean isAbundant() {
        return resultSum > number;
    }

    public boolean isDeficient() {
        return resultSum < number;
    }
    public static void main(String[] args) {
//        NewClassifierAlpha alpha1 = new NewClassifierAlpha(10);
//        NewClassifierAlpha alpha2 = new NewClassifierAlpha(6);
//
//        System.out.println(alpha1.isPerfect());
//        System.out.println(alpha2.isPerfect());

        int i = 1;
        while (i <= 100) {
            NewClassifierAlpha alpha = new NewClassifierAlpha(i);
            System.out.println(alpha.isPerfect());
            i++;
        }
    }
}
