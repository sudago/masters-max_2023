package cs16.cs12;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) throws IOException {
        try{
            URL url = new URL("https://www.naver.com");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String tempStr;
            StringBuilder allStr = new StringBuilder();
            while ((tempStr = br.readLine()) != null) {
                allStr.append(tempStr);
            }

            con.disconnect();
            br.close();

            DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = dBuilder.parse(String.valueOf(allStr));
            doc.getDocumentElement().normalize();

            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("list");
            System.out.println("-----------------------");

            for (int temp = 0; temp < nList.getLength(); temp++) {

                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) nNode;

                    System.out.println("First Name : " + getTagValue("firstname", eElement));
                    System.out.println("Last Name : " + getTagValue("lastname", eElement));
                    System.out.println("Nick Name : " + getTagValue("nickname", eElement));
                    System.out.println("Salary : " + getTagValue("salary", eElement));

                }
            }
        } catch (Exception e) {
            System.out.println("에러처리 추가");
        }
    }
    private static String getTagValue(String sTag, Element eElement) {
        NodeList nlList = eElement.getElementsByTagName(sTag).item(0).getChildNodes();
        Node nValue = (Node) nlList.item(0);
        return nValue.getNodeValue();
    }
}
