package cs16.cs05;

import java.io.BufferedReader;
import java.io.IOException;

import static java.lang.System.*;

public class Input {
    private final ConvertUnit convertUnit;
    private final int[][] filteredInts;

    public Input(BufferedReader br) throws IOException {
        // 입력 메세지 출력
        out.println("좌표를 (0,0)-(0,0)의 형태로 입력하세요.");
        // ConvertUnit 클래스를 따로 만들어서 input을 필터링 한다.
        convertUnit = new ConvertUnit(br);
        // 사용 가능한 int[][] 배열이 return 된다.
        filteredInts = convertUnit.makeFilteredInts();
    } // Constructor - end

    public Polygon takePolygonType() {
        return convertUnit.checkPolygonType(filteredInts);
    } // takePolygonType() - end

} // class - end
