package cs16.cs09.mission1;

import java.util.*;

public class CountSet {
    private final HashMap<Integer, Integer> storedMap;

    public CountSet(HashMap<Integer, Integer> storedMap) {
        this.storedMap = storedMap;
    }

    /* append() 2번 방법. - 굳이 storedMap을 해부해가지고 새로운 List<Integer> key, value 각각 만들어가지고 element 있는지 확인하고,
        완성된 key, value 를 new hashMap() 해가지고 일일히 다시 넣음. - 이게 맞나..?
     */
    public CountSet append(int element) {
        List<Integer> key = new ArrayList<>();
        List<Integer> value = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : storedMap.entrySet()) { // storedMap.forEach()로 사용 안됐음.
            key.add(entry.getKey());
            value.add(entry.getValue());
        } // 여기까지 key, value 값 각각 넣음.

        if (key.contains(element)) {
            int index = key.indexOf(element);
            value.set(index, value.get(index) + 1);
        } else {
            key.add(element);
            value.add(1);
        }

        // 여기서부터 map에 key, value 넣기.
        HashMap<Integer,Integer> newHashMap = new HashMap<>();
        for (int i = 0; i < key.size(); i++) {
            newHashMap.put(key.get(i), value.get(i));
        }

        return new CountSet(newHashMap);
    }



    public CountSet remove(int element) {
        List<Integer> key = new ArrayList<>();
        List<Integer> value = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : storedMap.entrySet()) {
            key.add(entry.getKey());
            value.add(entry.getValue());
        } // 여기까지 key, value 값 각각 넣음.

        if (key.contains(element)) {
            int index = key.indexOf(element);
            value.set(index, value.get(index) - 1);
        } // else - "요소가 없으면" 경우는 고려하지 않음.

        if (value.contains(0)) {
            int index = value.indexOf(0);
            key.remove(index);
            value.remove(index);
        }

        // 여기서부터 map에 key, value 넣기.
        HashMap<Integer,Integer> newHashMap = new HashMap<>();
        for (int i = 0; i < key.size(); i++) {
            newHashMap.put(key.get(i), value.get(i));
        }

        return new CountSet(newHashMap);
    }


    public int countFor(int element) {
        List<Integer> key = new ArrayList<>();
        List<Integer> value = new ArrayList<>();
        int resultNumber;

        for (Map.Entry<Integer, Integer> entry : storedMap.entrySet()) {
            key.add(entry.getKey());
            value.add(entry.getValue());
        } // 여기까지 key, value 값 각각 넣음.


        int index = key.indexOf(element);
        resultNumber = value.get(index);
        // else - "요소가 없으면" 경우는 고려하지 않음.

        return resultNumber;
    }

    public CountSet sum(CountSet b) { // 합집합
        List<Integer> key = new ArrayList<>();
        List<Integer> value = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : storedMap.entrySet()) {
            key.add(entry.getKey());
            value.add(entry.getValue());
        } // 여기까지 this.storedMap 의 key, value 값 각각 넣음.
        for (Map.Entry<Integer, Integer> entry : b.storedMap.entrySet()) {
            if (key.contains(entry.getKey())) {
                int index = key.indexOf(entry.getKey());
                value.set(index, value.get(index)+entry.getValue());
            } else {
                key.add(entry.getKey());
                value.add(entry.getValue());
            }
        } // 여기까지 CountSet b 의 key, value 값 각각 넣음.

        // 여기서부터 map에 key, value 넣기.
        HashMap<Integer,Integer> newHashMap = new HashMap<>();
        for (int i = 0; i < key.size(); i++) {
            newHashMap.put(key.get(i), value.get(i));
        }
        return new CountSet(newHashMap);
    }
    public CountSet complement(CountSet b) { // 차집합
        List<Integer> key = new ArrayList<>();
        List<Integer> value = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : storedMap.entrySet()) {
            key.add(entry.getKey());
            value.add(entry.getValue());
        } // 여기까지 this.storedMap 의 key, value 값 각각 넣음.
        for (Map.Entry<Integer, Integer> entry : b.storedMap.entrySet()) {
            if (key.contains(entry.getKey())) {
                int index = key.indexOf(entry.getKey());
                if (0 >= (value.get(index) - entry.getValue())){
                    key.remove(index);
                    value.remove(index);
                } else {
                    value.set(index, value.get(index) - entry.getValue());
                }
            } // else - "요소가 없으면" 경우는 고려하지 않음.
        } // 여기까지 CountSet b 의 key, value 값 각각 넣음.

        // 여기서부터 map에 key, value 넣기.
        HashMap<Integer,Integer> newHashMap = new HashMap<>();
        for (int i = 0; i < key.size(); i++) {
            newHashMap.put(key.get(i), value.get(i));
        }
        return new CountSet(newHashMap);
    }
    public CountSet intersect(CountSet b) { // 교집합
        List<Integer> key = new ArrayList<>();
        List<Integer> value = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : storedMap.entrySet()) {
            key.add(entry.getKey());
            value.add(entry.getValue());
        } // 여기까지 this.storedMap 의 key, value 값 각각 넣음.
        List<Integer> newKey = new ArrayList<>();
        List<Integer> newValue = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : b.storedMap.entrySet()) {
            int entryKey = entry.getKey();
            if (key.contains(entryKey)) {
                int index = key.indexOf(entryKey);
                newKey.add(entryKey);
                newValue.add(1);
            } // else - "요소가 없으면" 경우는 고려하지 않음.
        } // 여기까지 CountSet b 의 key, value 값 각각 넣음.

        // 여기서부터 map에 key, value 넣기.
        HashMap<Integer,Integer> newHashMap = new HashMap<>();
        for (int i = 0; i < newKey.size(); i++) {
            newHashMap.put(newKey.get(i), newValue.get(i));
        }
        return new CountSet(newHashMap);
    }

    public Object[] resultAll(){
        List<String> stringList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : storedMap.entrySet()) {
            stringList.add(entry.getKey() + " : " + entry.getValue());
        }
        return stringList.toArray();
    }

    public static void main(String[] args) {
        HashMap<Integer, Integer> hashMapA = new HashMap<Integer, Integer>() {{
            put(1, 2);
            put(2, 2);
            put(3, 2);
        }};
        HashMap<Integer, Integer> hashMapB = new HashMap<Integer, Integer>() {{
            put(1, 1);
            put(3, 3);
        }};
        CountSet countSetA = new CountSet(hashMapA);
        CountSet countSetB = new CountSet(hashMapB);

        System.out.println("A Count 집합 = " + countSetA.storedMap);
        System.out.println("B Count 집합 = " + countSetB.storedMap);

        System.out.println("합집합 sum = " + Arrays.toString(countSetA.sum(countSetB).resultAll()));
        System.out.println("차집합 complement = " + Arrays.toString(countSetA.complement(countSetB).resultAll()));
        System.out.println("교집합 intersect = " + Arrays.toString(countSetA.intersect(countSetB).resultAll()));
    }
}
