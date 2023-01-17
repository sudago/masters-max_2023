package cs16.cs05;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

import static java.lang.System.*;

public class Input {
    public Polygon polygon;
//    Point point = new Point(x, y);

    public Input(BufferedReader br) throws IOException {
        // 입력 메세지 출력
        out.println("좌표를 (0,0)-(0,0)의 형태로 입력하세요.");
        int[][] filteredInts = makeFilteredInts(br);
        // arr.length의 개수에 따라 다각형이 달라진다.
        if (filteredInts.length == 2) {
            polygon = new Polygon(filteredInts);
        } else if (filteredInts.length == 3) {
            polygon = new Triangle(filteredInts);
        } else if (filteredInts.length == 4) {
            polygon = new Rectangle(filteredInts);
        }
        // controller를 하나로 한다.

    }

    private int[][] makeFilteredInts(BufferedReader br) throws IOException {
        int[][] changedInts = new int[0][]; // return 값을 담을 공간 할당.
        boolean availableInt = false; // 진입하도록 합니다..

        while (!availableInt) {
            availableInt = true; // 일단 허용 가능한 값이라고 가정하기.....

            // String을 int[][] 배열로 만들어준다.
            changedInts = makeStringToInt(br.readLine());

            // 0 ~ 24 사이에 있는지 검사를 한다.
            for (int[] testInts : changedInts) {
                for (int testInt : testInts) {
                    // 유효하지 않은 값이 들어온 것이므로,
                    // availableInt를 false로 만들어서 while문이 계속 돌게 만들기.
                    if (!(testInt >= 0 && testInt <= 24)) {
                        // 에러 메세지 출력
                        out.println("0부터 24까지의 값을 넣으세요.");
                        availableInt = false;
                    } // if - end
                } //for2 - end
            } // for1 - end
        } // while - end

        // 모든 값을 빠져나오면 사용가능한 값이므로, return 해준다.
        return changedInts;
    } // method - end

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
    } // method - end

} // class - end
