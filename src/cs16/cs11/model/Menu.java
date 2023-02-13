package cs16.cs11.model;

// 해당 메뉴를 확인하면 sec 를 넘겨준다.
public enum Menu {
    AMERICANO(3), LATTE(5), FRAPPUCCINO(7);

    private final int menu;
    Menu(int menu){
        this.menu = menu;
    }

    public int getSec(){
        return menu;
    }
}
