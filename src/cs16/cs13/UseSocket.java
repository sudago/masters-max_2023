package cs16.cs13;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class UseSocket {
    public static void main(String[] args) throws IOException {
        InetAddress address;

        {
            try {
                address = InetAddress.getByName("www.disney.co.kr");
                String hostName = address.getHostName();
                String IPAddress = address.getHostAddress();
                System.out.println(hostName);
                System.out.println(IPAddress);

//                address = InetAddress.getByName("http://m.naver.com"); // ?? UnknownHostException 발생.

                Socket socket = new Socket(hostName, 80);
                OutputStream output = socket.getOutputStream(); // 서버에 데이터를 보내기 위함
                PrintWriter writer = new PrintWriter(output, true);
                String requestStr = getRequestMessage(hostName);
//                System.out.println(requestStr);
                writer.println(requestStr);

                InputStream input = socket.getInputStream(); // 서버에서 받은 데이터를 읽기 위함
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }

                socket.close();


            } catch (UnknownHostException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static String getRequestMessage(String hostName) {
        // 리퀘스트 양식 다 적기

        return "GET " + "/" + " HTTP/1.1" + "\n" +
                "Accept: " + "text/html" + "\n" +
                "Host: " + hostName + "\n" +
                "User-Agent: " + "Java/*" + "\n" +
                "Connection: " + "close" + "\n";
    }
}