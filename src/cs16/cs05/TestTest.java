package cs16.cs05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestTest {
    public static void main(String[] args) throws IOException {
        // input을 받는다.
        Input input = new Input(new BufferedReader(new InputStreamReader(System.in)));
        // 이게 맞는지 모르겠음.
        Polygon polygon = input.polygon;
        // 계산한다.
        polygon.calculate();
        // 콘솔에 자동으로 출력되게 하기.
        polygon.showResultNumber();
    } // main - end
} // TestTest - end
