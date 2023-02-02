package cs16.cs09.mission1;

import java.util.*;

/*
    - map, set, Object 사용하지 말 것.
    - List, ArrayList 만 사용 가능.
 */

/*
 resultAll() 과 멤버변수 result 는 static 아님.
 */
public class SquadSet {
    /*
    1. union 에 a 넣기
    2. union 에 없는 b의 요소들 넣기
     */
    private final List<Integer> result;
    public SquadSet(List<Integer> result) {
        this.result = result;
    }
    public static List<Integer> sum(int[] a, int[] b) { // 공집합
        List<Integer> union = new ArrayList<>();
        Arrays.stream(a)
                .forEach(union::add); // (e -> union.add(e)) 와 같다.
        Arrays.stream(b)
                .filter(e -> !union.contains(e))
                .forEach(union::add);

        return union;
    }

    /*
    1. differenceSet 에 a 넣기
    2. differenceSet 에 없는 b의 요소 넣기.
    3. differenceSet 에서 교집합(= b에 있는 값) 제거.
        -> remove() 시, Integer 로 형변환 안했더니 (원래 의도 = object) index 로 인식해서 오류 남.
     */
    public static List<Integer> complement(int[] a, int[] b) { // 차집합
        List<Integer> differenceSet = new ArrayList<>();
        Arrays.stream(a)
                .forEach(differenceSet::add);
        Arrays.stream(b)
                .filter(e -> !differenceSet.contains(e))
                .forEach(differenceSet::add);
        Arrays.stream(b)
                .filter(differenceSet::contains)
                .forEach(e -> differenceSet.remove((Integer)e));
        return differenceSet;
    }

    /*
    1. a의 각 요소를 탐색한다.
        2. a의 요소와 같은 값이 b에 있으면
            3. intersect 에 넣는다.
     */
    public static List<Integer> intersect(int[] a, int[] b){ // 교집합
        List<Integer> intersect = new ArrayList<>();

        Arrays.stream(a)
                .forEach(e -> {
                    Arrays.stream(b)
                            .filter(element -> e == element)
                            .forEach(intersect::add);
                });
        return intersect;
    }

    public Object[] resultAll() {
        return result.toArray();
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        int[] b = {1, 3};

        SquadSet sum = new SquadSet(sum(a, b));
        SquadSet complement = new SquadSet(complement(a, b));
        SquadSet intersect = new SquadSet(intersect(a, b));

        System.out.println(Arrays.toString(sum.resultAll()));
        System.out.println(Arrays.toString(complement.resultAll()));
        System.out.println(Arrays.toString(intersect.resultAll()));
    }
}
