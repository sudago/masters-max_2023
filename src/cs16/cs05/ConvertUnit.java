package cs16.cs05;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashSet;

import static java.lang.System.out;

public class ConvertUnit {
    BufferedReader br;
    protected ConvertUnit(BufferedReader br) {
        this.br = br;
    }

    protected int[][] makeFilteredInts() throws IOException {
        int[][] changedInts = new int[0][]; // return 값을 담을 공간 할당.
        boolean availableInt = false; // 진입하도록 합니다..

        while (!availableInt) {
            // String을 int[][] 배열로 만들어준다.
            // ❓✅int로 바꿀 수 없는 String이 들어온다면 어떤 Exception 처리를 해야하지..??
            changedInts = makeStringToInt(br.readLine());

            // 0 ~ 24 사이에 있는지 검사를 한다. boolean으로 flag를 변경한다.
            availableInt = checkNumber(changedInts);

            // 직사각형만 입력을 허용하므로 각 좌표값을 확인한다.
            if (availableInt && changedInts.length == 4) {
                // flag 변경
                availableInt = checkAvailableRectangle(changedInts);
                // 에러 메세지 출력
                if (!availableInt) out.println("직사각형만 허용합니다. 좌표값을 다시 넣으세요.");
            }
        } // while - end

        // 모든 값을 빠져나오면 사용가능한 값이므로, return 해준다.
        return changedInts;
    } // makeFilteredInts() - end

    private int[][] makeStringToInt(String str){
        // str에서 ()를 제외한다.
        str = str.replaceAll("[()]", "");

        // - 를 기준으로 나눈다.
        String[] splitString = str.split("-");

        // 2차원 배열로 만들기
        String[][] reSplitString = new String[splitString.length][2];
        for (int i = 0; i < splitString.length; i++) {
            reSplitString[i] = splitString[i].split(",");
        }

        // String에서 int로 만들기
        int[][] changedInts = new int[reSplitString.length][2];

        // String 값을 전부 int로 바꾼다.
        for (int i = 0; i < reSplitString.length; i++) {
            for (int j = 0; j < reSplitString[i].length; j++) {
                changedInts[i][j] = Integer.parseInt(reSplitString[i][j]);
            } // for2 - end
        } // for1 - end

        return changedInts;
    } // makeStringToInt() - end

    private boolean checkNumber(int[][] rawInts){
        for (int[] testInts : rawInts) {
            for (int testInt : testInts) {
                // 유효하지 않은 값이 들어온 것이므로,
                // availableInt를 false로 만들어서 while문이 계속 돌게 만들기.
                if (!(testInt >= 0 && testInt <= 24)) {

                    // 에러 메세지 출력
                    out.println("0부터 24까지의 값을 넣으세요.");
                    return false;
                } // if - end
            } //for2 - end
        } // for1 - end

        return true;
    } // checkNumber() - end

    // 직사각형이 될 수 있는지, 각 좌표값을 확인하는 메서드.
    protected boolean checkAvailableRectangle(int[][] filteredInts){
        HashSet<Integer> setX = new HashSet<>();
        HashSet<Integer> setY = new HashSet<>();

        for (int[] filteredInt : filteredInts) {
            setX.add(filteredInt[0]);
            setY.add(filteredInt[1]);
        }

        return setX.size() == 2 && setY.size() == 2;
        // 위와 동일
//        if (!(setX.size() == 2 && setY.size() == 2)) {
//            return false;
//        }
//
//        return true;
    }

    protected Polygon checkPolygonType(int[][] filteredInts){
        Polygon polygon = null;
        // arr.length의 개수에 따라 다각형의 하위 클래스가 달라진다.
        if (filteredInts.length == 2) {
            polygon = new Polygon(filteredInts);
        } else if (filteredInts.length == 3) {
            polygon = new Triangle(filteredInts);
        } else if (filteredInts.length == 4) {
            polygon = new Rectangle(filteredInts);
        }
        return polygon; // 좌표가 2개일 때
    }
}
