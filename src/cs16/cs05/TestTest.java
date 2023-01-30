package cs16.cs05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestTest {
    public static void main(String[] args) throws IOException {
        // input을 받는다.
        Input input = new Input(new BufferedReader(new InputStreamReader(System.in)));

        // input 받은 좌표의 개수에 따라 polygon의 Type이 결정됨.
        Polygon polygon = input.takePolygonType();

        // 계산한다.
        // 콘솔에 polygon type에 따라 다른 결과가 출력된다.
        polygon.showResult();

        // 클래스 확인
        // System.out.println(polygon.getClass().getName());

    } // main - end
} // TestTest - end
