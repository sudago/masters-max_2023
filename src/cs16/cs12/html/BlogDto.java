package cs16.cs12.html;

public class BlogDto {

    private String title;
    private String contents;

    public BlogDto() {
    }

    public BlogDto(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }

    public String getTitle() {
        return title;
    }

    public String getContents() {
        return contents;
    }

    @Override
    public String toString() {
        return "제목: " + title + "\n" +
                "내용: " + contents + "\n" +
                "--------------------------------------------";
    }
}