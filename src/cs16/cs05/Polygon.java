package cs16.cs05;

import java.util.ArrayList;
import java.util.List;

public class Polygon {
// Point를 담는 List를 만든다. Point는 x, y 두개의 인자 값을 가진다.
    List<Point> points = new ArrayList<>(); // 좌표 (꼭짓점)
    List<Double> lines = new ArrayList<>(); // 좌표 사이의 거리 == 변 (line)
    Calculator calculator = new Calculator();
    double calculateResult;

    // 생성자
    public Polygon(int[][] dots) {
        for (int i = 0; i < dots.length; i++) {
            // 좌표들을 points list에 넣는다.
            this.points.add(new Point(dots[i][0], dots[i][1]));
        } // for - end
        calculateLineNumber();
    } // 생성자 end

    // ❓✅접근 제어자 고려
    protected void calculateLineNumber(){
        // 모든 점들의 거리를 계산해서 line에 넣는다.
        for (int i = 0; i < points.size(); i++) {
            Point coordinate1 = points.get(i);
            // i가 points 배열의 index의 마지막이라면, points 배열의 맨 처음 index를 넣는다.
            Point coordinate2 = points.get(0);
            if (i != points.size() - 1) { // i가 points 배열의 index의 마지막이 아니라면
                coordinate2 = points.get(i+1); // 그 다음 index를 받는다.
            }
            // 일단 선까지만 구현 했다. calculateResult에 넣었다.
            // ❓✅double 값 자체도 소수 점 아래 6자리까지만 끊는 방법을 생각해보자.
            double lineLength = calculator.calculateDistance(coordinate1, coordinate2);
            lines.add(lineLength);
        }
    } // calculateLineNumber() - end

    // 결과를 호출한다.
    // 입력 (10,10)-(14,15)
    protected void showResult(){
        // type이 그냥 Polygon 일 때는 좌표가 2개이므로 == (result 값이) 선 길이.
        calculateResult = lines.get(0);

        System.out.print("두 점 사이의 거리는 ");
        // String.format("%6f",calculateNumber); 썼는데 context actions 눌렀더니 바꿔줌.
        System.out.printf("%.6f%n",calculateResult);
    } // showResultNumber() - end

}
