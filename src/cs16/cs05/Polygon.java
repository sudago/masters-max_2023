package cs16.cs05;

import java.util.ArrayList;
import java.util.List;

public class Polygon {
// Point를 담는 List를 만든다. Point는 x, y 두개의 인자 값을 가진다.
    List<Point> points = new ArrayList<>();
    List<Double> lines = new ArrayList<>();
    Calculator calculator = new Calculator();
    double calculateResult;

    // 생성자
    public Polygon(int[][] dots) {
        for (int i = 0; i < dots.length; i++) {
            // 좌표들을 points list에 넣는다.
            this.points.add(new Point(dots[i][0], dots[i][1]));
        } // for - end
    } // 생성자 end

    // 메소드
    public void calculate(){
        // 모든 점들의 거리를 계산해서 line에 넣는다.
        for (int i = 0; i < this.points.size(); i += 2) {
            Point coordinate1 = this.points.get(i);
            Point coordinate2 = this.points.get(i+1);
            // 일단 선까지만 구현 했다. calculateResult에 넣었다.
            // 이 double 값 자체도 소수 점 아래 6자리까지만 끊는 방법을 생각해보자.
            this.calculateResult = calculator.calculateDistance(coordinate1, coordinate2);
            lines.add(calculateResult);
        }
        // Polygon을 상속받은 각각의 class의 calculate 메소드를 override 한다.
//        System.out.println(points);
    }

    public void showResultNumber(){
        // String.format("%6f",calculateNumber); 썼는데 context actions 눌렀더니 바꿔줌.
        System.out.printf("%6f%n",calculateResult);
    }

}
