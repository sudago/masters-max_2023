package cs16.cs08.mission1.refactoring;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NewClassifierAlpha {

    public static Set<Integer> factors(int number) {
        /* 욕심껏 한줄로 작성.
         그러나 1부터 number 만큼 다 넣고, filter로 거르는 방식이
         큰 값이 들어온다면 엄청나게 메모리를 차지할 것 같아서 완전히 마음에 들지는 않음.

        return IntStream.rangeClosed(1, number)
                .filter(increaseNumber -> number % increaseNumber == 0)
                .boxed()
                .collect(Collectors.toSet()); */

        // 2번 방법. 원래의 메서드에 쓰여있던 대로, 제곱근 값까지만 판별한다.
        Set<Integer> factors = new HashSet<>();
        IntStream.rangeClosed(1, (int) Math.sqrt(number))
                .filter(i -> number % i == 0)
                .forEach(i -> {
                    factors.add(i);
                    factors.add(number / i);
                });
        return factors;
    }

    public static int sumElements(Set<Integer> factors) {

        // 실패1 : OptionalInt를 int로 바꾸는 방법을 모르겠음.
        // 실패2 : Stream -> String -> Integer 3단으로 바꿈.
//        return Integer.parseInt(factors.stream().reduce((x, y) -> x+y).toString());

        // 성공! : reduce()에 accumulate 값을 넣지 않아서 생긴 문제였다.
        return factors.stream().reduce(0, Integer::sum);

        /* 성공? : 잘은 모르겠지만 sum()은 int로 return되나 보다.
        return factors.stream().mapToInt(e -> e).sum(); // 엄청 애먹음.
        mapToInt(): Stream 을 IntStream 으로 변환해준다.   */
    }

    public static boolean isPerfect(int number) {
        return sumElements(factors(number)) - number == number;
    }

    public static boolean isAbundant(int number) {
        return sumElements(factors(number)) - number > number;
    }

    public static boolean isDeficient(int number) {
        return sumElements(factors(number)) - number < number;
    }

    public static void main(String[] args) {
        int i = 1;
        while (i <= 100) {
            System.out.println(i + ": " + isPerfect(i));
            i++;
        }
    }
}
