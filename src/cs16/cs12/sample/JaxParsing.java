package cs16.cs12.sample;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class JaxParsing {

    public static void main(String[] args) {
        try {

            InputStream ins = JaxParsing.class.getClassLoader().getResourceAsStream("cs16/cs12/sample/staff_list.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            // Document doc = dBuilder.parse(fXmlFile);
            Document doc = dBuilder.parse(ins);
            doc.getDocumentElement().normalize();

            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("staff");
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
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String getTagValue(String sTag, Element eElement) {
        NodeList nlList = eElement.getElementsByTagName(sTag).item(0).getChildNodes();
        Node nValue = (Node) nlList.item(0);
        return nValue.getNodeValue();
    }
}