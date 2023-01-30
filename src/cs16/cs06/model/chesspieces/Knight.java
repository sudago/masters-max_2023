package cs16.cs06.model.chesspieces;

import cs16.cs06.model.Piece;

public class Knight extends Piece {
    public Knight (String color) {
        super(color);
        super.score = 3;
    }

    // position
    // 흑: B-1, G-1 백: B-8, G-8

    // move
    // 전진 1칸 + 대각선 1칸 이동 가능.
    // 예외 : 체스 게임과 달리 전진하는 칸이 막혀있으면 움직일 수 없다.
}
