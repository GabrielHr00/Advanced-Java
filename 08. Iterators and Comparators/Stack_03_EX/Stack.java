import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Stack implements Iterable<Integer>{
    private List<Integer> list;

    public Stack() {
        this.list = new ArrayList<>();
    }

    public void push(String elements){
        int[] arr = Arrays.stream(elements.split(", ")).mapToInt(Integer::parseInt).toArray();
        for (var o : arr) {
            list.add(o);
        }
    }

    public void pop(){
        try{
            this.getList().remove(getList().size() - 1);
        } catch(IndexOutOfBoundsException e){
            System.out.println("No elements");
        }
    }

    public List<Integer> getList() {
        return list;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new StackIterator();
    }

    public class StackIterator implements Iterator<Integer>{
        int index;

        public StackIterator() {
            index = getList().size() - 1;
        }

        @Override
        public boolean hasNext() {
            return index >= 0;
        }

        @Override
        public Integer next() {
            return getList().get(this.index--);
        }
    }
}
