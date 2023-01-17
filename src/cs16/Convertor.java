package cs16;

import java.util.Arrays;

public class Convertor {
    public static boolean[] dec2bin(int decimal) {
        boolean[] answer = {};
        int booleanLength = 0;
        for (int i = 1; i <= 9; i++) { // boolean 배열 길이 구하기.
            if (decimal < Math.pow(2, i)) {
                booleanLength = i;
                break;
            }
        } // for - end
        answer = new boolean[booleanLength];

        for (int i = 0; i < booleanLength; i++) {
            answer[i] = decimal % 2 != 0; // (decimal % 2 == 0) ? false : true; 와 같다.
            decimal /= 2;
        }
        return answer;
    }

    public static int bin2dec(boolean[] binary) {
        int answer = 0;
        for (int i = 0; i < binary.length; i++) {
            if (binary[i]) {
                answer += Math.pow(2, i);
            } // if - end
        } // for - end
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(dec2bin(173)));
        boolean[] testBoolean = {true,true,true,true,false,true,false,true};
        System.out.println(bin2dec(testBoolean));
    }
}
