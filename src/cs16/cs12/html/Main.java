package cs16.cs12.html;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

//        for (int i = 0; i < 8; i++) {
//            System.out.println(getBlog().get(i).toString());
//        }

        try {
//            String URL = "https://jforj.tistory.com/68";
            String URL = "https://www.naver.com";
            Connection conn = Jsoup.connect(URL);

            Document document = conn.get();

            Elements parsingDivs = document.getElementsByClass("special_bg"); // class가 parsingDiv인 element 찾기
            Element parsingDiv = parsingDivs.get(0);

            Elements parsingTitle = parsingDiv.getElementsByClass("group_flex"); // id가 parsingTitle인 element 찾기
            Element test = parsingTitle.get(0);
            Elements parsingContents = test.getElementsByClass("logo_area"); // id가 parsingContents인 element 찾기

            String title = parsingContents.get(0).text(); // 첫 번째 h3태그의 text값 찾기
//            String contents = parsingContents.getElementsByTag("p").get(0).text(); // 첫 번째 p태그의 text값 찾기

            System.out.println("파싱한 제목: " + title);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}