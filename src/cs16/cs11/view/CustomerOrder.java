package cs16.cs11.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// 문자열 처리를 한 다음에 Cashier 한테 넘겨준다.
public class CustomerOrder {
    private static int defaultCustomerID = 1;
    private final int customerID;
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public CustomerOrder() {
        customerID = defaultCustomerID;
        defaultCustomerID++;
    }

    public String[] usableOrder() throws IOException {
        String order = br.readLine();
        List<String> orderMenu = new ArrayList<>(List.of(order.split(" ")));

        while (orderMenu.size() != 2
                || !(orderMenu.get(0).equals("아메리카노")
                    || orderMenu.get(0).equals("라떼") || orderMenu.get(0).equals("프라푸치노"))) {
            System.out.println("주문을 다시 해 주세요");
            order = br.readLine();
            orderMenu = new ArrayList<>(List.of(order.split(" ")));
        }

        orderMenu.add(String.valueOf(customerID));
        return orderMenu.toArray(new String[0]);
    }
}
