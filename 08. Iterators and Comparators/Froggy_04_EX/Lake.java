import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

public class Lake implements Iterable<Integer> {
    private List<Integer> list;

    public Lake(String in) {
        this.list = Arrays.stream(in.split(", ")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Frog();
    }

    public class Frog implements Iterator<Integer>{
        private int index;

        public Frog() {
            this.index = 0;
        }

        @Override
        public boolean hasNext() {
            return this.index < list.size();
        }

        @Override
        public Integer next() {
            int element = list.get(this.index);
            this.index = isFinishedWithEven.test(list.size(), this.index + 2) ? 1 : this.index + 2;
            return element;
        }
        private BiPredicate<Integer, Integer> isFinishedWithEven = (length, index) -> index >= list.size() && index % 2 == 0;

    }
}
