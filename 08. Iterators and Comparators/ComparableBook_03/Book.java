import java.util.Arrays;
import java.util.List;

public class Book implements Comparable<Book>{
    private String title;
    private int year;
    private List<String> authors;

    public Book(String title, int year, String... authors) {
        this.title = title;
        this.year = year;
        this.authors = Arrays.asList(authors);
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public List<String> getList() {
        return authors;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setList(List<String> authors) {
        this.authors = authors;
    }

    @Override
    public int compareTo(Book o) {
        if(this.getTitle().compareTo(o.getTitle()) == 0){
            return Integer.compare(this.getYear(), o.getYear());
        }
        return this.getTitle().compareTo(o.getTitle());
    }
}
