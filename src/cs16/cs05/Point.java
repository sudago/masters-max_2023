package cs16.cs05;

public record Point(int x, int y) {
}

/* 이렇게 작성하니 context action으로 record를 추천해줬다.
public class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getx(){
        return x;
    }

    public int gety(){
        return y;
    }
}
 */
