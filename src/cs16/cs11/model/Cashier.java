package cs16.cs11.model;

// 주문이 들어오면 OrderQueue 에 넘긴다.
public class Cashier {
    public void orderCustomer(String[] order){
        // 0 : 메뉴명, 1 : 음료 개수, 2 : 주문자 ID
        int[] orderArray = new int[3];

        switch (order[0]) {
            case "아메리카노" -> orderArray[0] = Menu.AMERICANO.getSec();
            case "라떼" -> orderArray[0] = Menu.LATTE.getSec();
            case "프라푸치노" -> orderArray[0] = Menu.FRAPPUCCINO.getSec();
        }

        orderArray[1] = Integer.parseInt(order[1]);
        orderArray[2] = Integer.parseInt(order[2]);

//        OrderQueue.push(orderArray);
    }
}
