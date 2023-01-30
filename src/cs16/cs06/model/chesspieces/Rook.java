package cs16.cs06.model.chesspieces;

import cs16.cs06.model.Piece;

public class Rook extends Piece {
    public Rook (String color) {
        super(color);
        super.score = 5;
    }

    // position
    // 흑: a-1, h-1, 백: a-8, h-8

    // move
    // 상하좌우 이동 가능.
}
