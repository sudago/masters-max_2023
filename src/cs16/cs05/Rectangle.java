package cs16.cs05;

public class Rectangle extends Polygon {
    public Rectangle(int[][] dots) {
        super(dots);
    }
    @Override
    public void calculate() {
        super.calculate();
        // super.lines에 들어있는 값으로 사각형 넓이 구하기.
        // super.calculator.calculateRectangleSize(); 하기
    }
}
