package cs16.cs05;

import java.util.HashSet;
import java.util.Iterator;
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

        // 좌표 사이의 길이 구하는 공식
        return Math.sqrt(Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2));
    }

    // 삼각형 넓이 구하기.
    public double calculateTriangleSize(List<Double> lines) {
        double a = lines.get(0);
        double b = lines.get(1);
        double c = lines.get(2);

        // 헤론의 공식
        return Math.sqrt((a+b+c)*(-a+b+c)*(a-b+c)*(a+b-c)) / 4;
    }

    // 사각형 넓이 구하기
    public double calculateRectangleSize(List<Double> lines) {
        // 두개의 값만 받을 수 있도록 HashSet 사용.
        HashSet<Integer> availableTwoLines = new HashSet<Integer>();

        for (double line : lines) {
            availableTwoLines.add((int)line);
        }

        // HashSet에 들어있는 값을 꺼내기 위해 Iterator 사용.
        Iterator<Integer> iterator = availableTwoLines.iterator();
        // 두개의 값을 곱해서 직사각형의 넓이를 return 한다.
        return iterator.next() * iterator.next();
    }
}
