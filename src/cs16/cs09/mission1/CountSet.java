package cs16.cs09.mission1;

import java.util.Arrays;
import java.util.HashMap;

public class CountSet {
    private final HashMap<Integer, Integer> storedMap;

    public CountSet(HashMap<Integer, Integer> storedMap) {
        this.storedMap = storedMap;
    }

    /* newHashMap.merge() 이렇게 작성한거 수정해줌.
      if (newHashMap.get(key) == null) { // 값이 없을 때도 고려하느라 이렇게 짰음
            newHashMap.put(key, 1);
        } else {
            newHashMap.put(key, newHashMap.get(key) + 1);
        }
     */
    public HashMap<Integer, Integer> append(int[] intArray) {
        HashMap<Integer, Integer> newHashMap = new HashMap<>(storedMap);
        Arrays.stream(intArray).forEach(key -> {
            newHashMap.merge(key, 1, Integer::sum);
        });

        return newHashMap;
    }

    /*
    ?? "만약 0이 되면" 이라는 말은 hashMap이 isEmpty()라는 말일까, 아님 value가 0이 되면이라는 말일까..?
    ?? "제거한 countSet()" 이라는 말은 여태까지 -1 했던 모든 key 들을 말하는 것일까, 아님 0이 된 key 들을 말하는 것일까?
    1. key 가 있으면 value 에 -1을 한다.
    2. value 가 0이 되면 zeroHashMap 에 key와 0을 넣는다.
     */
    public HashMap<Integer, Integer> remove(int[] intArray) {
        HashMap<Integer, Integer> newHashMap = new HashMap<>(storedMap);
        HashMap<Integer, Integer> zeroHashMap = new HashMap<>();

        Arrays.stream(intArray).forEach(key -> {
            if (storedMap.get(key) != null) newHashMap.put(key, storedMap.get(key) - 1);
            if (newHashMap.get(key) == 0) zeroHashMap.put(key, 0);
        });

        if (zeroHashMap.isEmpty()) {
            return newHashMap;
        } else {
            return zeroHashMap;
        }
    }

//
//    public void resultSum(){
//        String a = {"1", "2", "3"}
//    }

    public static void main(String[] args) {
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>() {{
            put(1, 2);
            put(2, 2);
        }};
        System.out.println((hashMap.get(3)));
    }
}
