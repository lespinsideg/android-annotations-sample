package lesp.androidannotationssample.vo;

public class Book {
    private String title;
    private String author;
    private String contents;

    public Book(String title, String author, String contents) {
        this.title = title;
        this.author = author;
        this.contents = contents;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getContents() {
        return contents;
    }
}
