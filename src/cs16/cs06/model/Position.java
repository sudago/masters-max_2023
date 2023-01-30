package cs16.cs06.model;

public class Position {
    public String[] defaultPosition = new String[2];
    public String[] currentPosition = new String[2];
    public String[][] movablePosition = new String[4][2];

    /*
    - Position은 file은 A~H,rank는 1~8까지 입력이 가능하다.
        - file이 column, rank가 row 인 것 같다.
    - file과 rank는 enum으로 선언한다.
     */

    // 1. default position (생성자)
    public Position(){
        // type (Piece의 하위클래스, Piece의 색깔)에 따라, 가지는 default 위치가 다르다.
        // switch - case 문 써볼까 생각중.
    }

    // 2. currentPosition - 현재 위치
    public void makeCurrentPosition(){

    }

    // 3. movablePosition - 이동 가능한 위치
    public void makeMovablePosition(){

    }
}
