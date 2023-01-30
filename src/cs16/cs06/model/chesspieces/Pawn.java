package cs16.cs06.model.chesspieces;

import cs16.cs06.model.Piece;

public class Pawn extends Piece {
    public Pawn (String color) {
        super(color);
        super.score = 1;

        // position
        // 흑: rank - 2, 백: rank - 7

        // move
        // 앞으로 1칸만 이동 가능.
        // 예외1 : 체스 게임과 달리 처음에도 1칸만 움직일 수 있고, 다른 말을 잡을 때도 대각선이 아니라 직선으로 움직일 때 잡는다고 가정한다.

        /* 예외2
        - Pawn이 상대편 Rank에 도착하면 같은 색 Queen으로 변신한다.
            - 흑색 Pawn이 2-rank에서 시작해서 8-rank에 도착할 경우
            - 백색 Pawn이 7-rank에서 시작해서 1-rank에 도착할 경우
         */
    }
}
