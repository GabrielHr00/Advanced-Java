import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class ListyIterator<T> implements Iterable<T>{
    List<T> list;
    private int index;

    public ListyIterator(T... list) {
        this.list = Arrays.asList(list);
        this.index = 0;
    }

    public ListyIterator() {
        this.list = new ArrayList<>();
        index = 0;
    }

    public int getIndex() {
        return index;
    }

    public List<T> getList() {
        return list;
    }

    public boolean move(){
        if(hasNext()){
            index++;
            return true;
        }
        return false;
    }

    public void print(){
        try{
            System.out.println(list.get(this.getIndex()));
        }
        catch(IndexOutOfBoundsException e){
            System.out.println("Invalid Operation!");
        }
    }

    public boolean hasNext(){
        return this.index + 1 < list.size();
    }

    @Override
    public Iterator<T> iterator() {
        return new Iteratory();
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        Iterable.super.forEach(action);
    }

    private class Iteratory implements Iterator<T>{
        private int index = 0;

        @Override
        public boolean hasNext() {
            return this.index + 1 < list.size();
        }

        @Override
        public T next() {
            return list.get(this.index++);
        }
    }
}
