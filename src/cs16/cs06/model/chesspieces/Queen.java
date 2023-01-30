package cs16.cs06.model.chesspieces;

import cs16.cs06.model.Piece;

public class Queen extends Piece {
    public Queen (String color) {
        super(color);
        super.score = 9;
    }
    // position
    // 흑: E1, 백: E8

    // move
    // 대각선(Bishop), 상하좌우(Rook) 이동 가능.
}
