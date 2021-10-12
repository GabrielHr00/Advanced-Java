import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomList<T extends Comparable<T>> {
    private List<T> elems;

    public CustomList() {
        this.elems = new ArrayList<>();
    }

    public void add(T element){
        this.elems.add(element);
    }

    public T remove(int index){
        T elem = this.elems.get(index);
        this.elems.remove(index);
        return elem;
    }

    public boolean contains(T element){
        return this.elems.contains(element);
    }

    public void swap(int index1, int index2){
        Collections.swap(this.elems, index1, index2);
    }

    public int countGreaterThan(T element){
        return (int)this.elems.stream().filter(e -> e.compareTo(element) > 0).count();
    }

    public T getMax(){
        return Collections.max(this.elems);
    }

    public T getMin(){
        return Collections.min(this.elems);
    }

    public void printsAll(){
        this.elems.stream().forEach(e -> System.out.println(e));
    }
}
