import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Box<T extends Comparable<T>> {
    private List<T> values;

    public Box() {
        this.values = new ArrayList<>();
    }

    public void add(T element) {
        values.add(element);
    }

    public void swap(int first, int second){
        Collections.swap(this.values, first, second);
    }
    public int countOfGreater(T element){
        return (int)values.stream().filter(e -> e.compareTo(element) > 0).count();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T el: this.values) {
            sb.append(String.format("%s: %s", el.getClass().getName(), el.toString())).append(System.lineSeparator());
        }
        return sb.toString();
    }


}
