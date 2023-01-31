package cs16.cs08.mission1;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Optional;
import java.util.Set;

public class FailedClassifierAlpha {

    // 실패 코드!
    // 미션1은 람다식을 직접 사용하기보다는, Stream을 이용해서 계산 메서드만 조금 바꾸면 될 듯.
    public interface Factors {
        Set<Integer> factors(int number);
    }
    public interface Sum {
        int sum(Set<Integer> factors);
    }

    public static void main(String[] args) {

        Factors factors = (number) -> {
            Set<Integer> hashSet = new HashSet<>();
            for (int pod = 1; pod <= Math.sqrt(number); pod++) {
                if ((number % pod) == 0) {
                    hashSet.add(pod);
                    hashSet.add(number / pod);
                }
            }
            return hashSet;
        };

        // factors가 함수명이라 변수명을 hashSet으로 적음..
        Sum sum = (hashSet) -> {
//            Optional<Integer> reduce = factors.stream().reduce((x, y) -> x + y);
//            Optional<Integer> reduce = hashSet.stream().reduce(Integer::sum);
//            reduce.ifPresent(s -> System.out.println("sum: "+ s));

            // stream 사용이 안되서 iterator 사용.
            Iterator iterator = hashSet.iterator();
            int resultSum = 0;
            while (iterator.hasNext()) {
                resultSum += (Integer) iterator.next();
            }

            return resultSum;
        };


    }

//    public static void main(String[] args) {
//        NewClassifierAlpha alpha1 = new NewClassifierAlpha(10);
//        NewClassifierAlpha alpha2 = new NewClassifierAlpha(6);
//
//        System.out.println(alpha1.isPerfect());
//        System.out.println(alpha2.isPerfect());
//    }
}
