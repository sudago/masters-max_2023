package cs16.cs11.controller;

import cs16.cs11.model.Cashier;
import cs16.cs11.view.CustomerOrder;
import cs16.cs11.view.CustomerReturn;

import java.io.IOException;

/* 카페에서 일어나는 일
    1. 고객이 Cashier 에게 음료를 주문한다. (음료의 종류, 음료의 개수)
    2. Cashier 는 받은 주문을 OrderQueue 에 넘긴다.
    3. OrderQueue 에 들어 온 순서대로 Manager 가 받아서 Barista 에게 넘겨준다.
        - Manager 는 1초 동안 OrderQueue 를 확인한다.
    4. Barista 는 만든 음료를 Manager 에게 전달한다.
    5. Manager 는 만든 음료를 고객에게 전달한다. (= 출력한다.)
    - 주문이 3초 동안 들어오지 않으면 프로그램이 종료한다.
 */

public class InsideCafe {
    public static void main(String[] args) throws IOException {
        CustomerReturn customerReturn = new CustomerReturn();
        // 주문 할 수 있는 메뉴 종류는 1가지, 개수는 여러 개 가능하다고 가정.
        CustomerOrder customerOrder = new CustomerOrder();
        Cashier cashier = new Cashier();
        cashier.orderCustomer(customerOrder.usableOrder());

    }
}
