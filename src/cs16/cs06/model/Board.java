package cs16.cs06.model;

public class Board {
    Position[][] board = new Position[8][8];
    Piece whiteChess = new Piece("white");
    Piece blackChess = new Piece("black");

    public Board(){}

    // 현재 체스판 구성을 보여주는 함수.
    public void display(){
        // 적절한 데이터 구조로
        // return (1~8 rank 까지) 전체 rank
    }

    // 특정 위치에 특정 말을 생성하는 함수1.
    public void initPiece(Piece piece, Position position) {
        /* rank == row, file == column */
        // 1,2 rank에 흑색 체스말, 7,8 rank에는 백색 체스말

        /* 체스말 초기 위치가 아니면 생성하지 않는다.
        이미 해당 위치에 다른 말이 있으면 생성하지 않는다.
        체스말 종류별로 최대 개수보다 많이 생성할 수는 없다.
        Pawn는 색상별로 8개. Knight, Bishop, Rook는 색상별로 2개, Queen는 색상별로 1개만 가능하다.
        생성하지 않는 경우는 exception 예외처리로 상위에서 어떤 예외상황인지 판단한다.
         */
    }

    // 특정 위치에 특정 말을 생성하는 함수2.
    public void setPiece(Piece piece, Position position){
        /*
        initPiece()와 다르게 체스말은 어느 위치에 놓아도 상관없다.
        이미 해당 위치에 다른 말이 있으면 생성하지 않는다.
        체스말 최대 개수도 고려하지 않는다.
         */
    }

    // 특정 말을 옮길 때 사용하는 함수.
    public void move(Position fromPosition, Position toPosition){
        /*
        같은 색상의 말이 to 위치에 다른 말이 이미 있으면 옮길 수 없다.
        말을 옮길 수 있으면 true, 옮길 수 없으면 false를 리턴한다.
        만약, 다른 색상의 말이 to 위치에 있는 경우는 기존에 있던 말을 제거하고 이동한다.
        다른 색상의 말을 제거한 경우는 흑과 백 점수를 출력한다.
         */
    }

}
