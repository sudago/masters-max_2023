package cs16.cs05;

public class Triangle extends Polygon{
    public Triangle(int[][] dots) {
        super(dots);
        calculateResult =
                calculator.calculateTriangleSize(lines);
    }

    // 입력 (10,10)-(14,15)-(20,8)
    @Override
    public void showResult(){
        System.out.print("삼각형의 넓이는 ");
        System.out.printf("%.1f%n",calculateResult);
    }
}
