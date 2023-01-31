package cs16.cs08.mission2;

import cs16.cs08.mission1.refactoring.NewClassifierAlpha;
import cs16.cs08.mission1.refactoring.NewPrimeAlpha;

import java.util.stream.Stream;

public class TestMission2 {

    public static boolean isSquared(int number){
        return number % Math.sqrt(number) == 0;
    }

    public static void main(String[] args) {

        int i = 2;
        while (i <= 100) {
            Stream.of(i + " : ",
                    NewClassifierAlpha.isPerfect(i) ? "perfect" : "",
                    NewClassifierAlpha.isAbundant(i) ? "abundant" : "",
                    NewClassifierAlpha.isDeficient(i) ? "deficient" : "",
                    NewPrimeAlpha.isPrime(i) ? "prime" : "",
                    isSquared(i) ? "squared" : "")
                    .reduce((x, y) -> x + (y.equals("") ? y : y + ", "))
                    .ifPresent(e -> {
                        System.out.println((e.replaceAll(",\s$", "")));
                    });
            i++;
        }
    }
}
