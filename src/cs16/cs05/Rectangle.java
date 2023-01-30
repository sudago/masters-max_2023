package cs16.cs05;

public class Rectangle extends Polygon {
    public Rectangle(int[][] dots) {
        super(dots);
        calculateResult =
                calculator.calculateRectangleSize(lines);
    }

    // 입력 (10,10)-(22,10)-(22,18)-(10,18)
    @Override
    public void showResult(){
        System.out.println("사각형의 넓이는 " + calculateResult);
    }
}