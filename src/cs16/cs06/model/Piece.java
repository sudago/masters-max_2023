package cs16.cs06.model;

public class Piece {
    public int score;
    protected final String pieceColor;
    Position position;

    public Piece(String color){
        pieceColor = color;
    }

    // 현재 위치 position을 기준으로 이동 할 수 있는 모든 위치를 리턴하는 함수.
    public String possiblePosition(){
        // 다른 말이 있는지 여부는 확인하지 않는다.
        return "말이 이동 할 수 있는 모든 위치";
    }
}
