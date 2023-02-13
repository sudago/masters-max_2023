package cs16.cs12.html;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class Connect {
    public static void main(String[] args) throws Exception {
        try {
            URL url = new URL("https://www.naver.com/");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            connection.addRequestProperty("Content-Type", "text/xml; charset=uft-8");

            String inputLine;
            String returnStr = "";
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8));

            while ((inputLine = in.readLine()) != null) {
                returnStr += inputLine;
            }

            InputSource is = new InputSource(new StringReader(returnStr));
            DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = dBuilder.parse(is);

            if (doc == null) {
                throw new Exception("ERROR :: document is null");
            }
            System.out.println(returnStr);
        } catch (IOException | ParserConfigurationException | SAXException e) {
            throw new RuntimeException(e);
        }

    }
}