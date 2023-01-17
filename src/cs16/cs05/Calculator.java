package cs16.cs05;

import java.util.List;

public class Calculator {
    // 기본 생성자
    public Calculator(){}

    // 계산 메소드 분리.
    // Distance, Triangle, Rectangle에 따라 다른 계산기를 만들기.
    public double calculateDistance(Point point1, Point point2) {
        int x1 = point1.x();
        int y1 = point1.y();
        int x2 = point2.x();
        int y2 = point2.y();

        return Math.sqrt(Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2));
    }

    // 삼각형 넓이 구하기
    public void calculateTriangleSize() {
        System.out.println("");
    }

    // 사각형 넓이 구하기
    public void calculateRectangleSize() {
        System.out.println("");
    }
}
