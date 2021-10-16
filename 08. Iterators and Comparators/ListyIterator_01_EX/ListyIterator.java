import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ListyIterator{
    List<String> list;
    private int index;

    public ListyIterator(String[] list) {
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

    public List<String> getList() {
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

}
