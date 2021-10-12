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
        for (T el: this.values) {
            sb.append(String.format("%s: %s", el.getClass().getName(), el.toString())).append(System.lineSeparator());
        }
        return sb.toString();
    }

    public void swap(int first, int second){
        T objectt = this.values.get(first);
        this.values.set(first, this.values.get(second));
        this.values.set(second, objectt);
    // Collections.swap(this.values, first, second);
    }
}
