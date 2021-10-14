import java.util.Arrays;
import java.util.List;

public class Book {
    private String title;
    private int year;
    private List<String> list;

    public Book(String title, int year, String... list) {
        this.title = title;
        this.year = year;
        this.list = Arrays.asList(list);
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public List<String> getList() {
        return list;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setList(List<String> list) {
        this.list = list;
    }
}
