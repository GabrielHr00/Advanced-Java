import java.util.ArrayList;
import java.util.List;

public class Box<T> {
    private List<T> values;

    public Box() {
        this.values = new ArrayList<>();
    }

    public void add(T element) {
        values.add(element);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T el: values) {
            sb.append(String.format("%s: %s", el.getClass().getName(), el.toString())).append(System.lineSeparator());
        }
        return sb.toString();
    }
}
