package cs16.cs06.model.chesspieces;

import cs16.cs06.model.Piece;

public class Bishop extends Piece{
    public Bishop(String color){
        super(color);
        super.score = 3;

        // position
        // 흑: c-1, f-1, 백: c-8, f-8

        // move
        // 대각선으로만 이동 가능.
    }
}
