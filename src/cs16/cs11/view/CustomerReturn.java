package cs16.cs11.view;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class CustomerReturn {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public CustomerReturn() throws IOException {
        orderExample();
    }

    public void orderExample() throws IOException {
        bw.write("☕️Menu☕️ : 아메리카노, 카페라떼, 프라푸치노\n");
        bw.write("💁‍♀️ : 주문하시겠어요?\n");
        bw.write("입력 예시) 아메리카노 2잔 => 아메리카노 2\n");
        bw.flush();
    }

}
