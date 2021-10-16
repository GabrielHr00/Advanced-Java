import java.util.Comparator;
import java.util.Locale;

public class NameComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        if(Integer.compare(o1.getName().length(), o2.getName().length()) == 0){
            return Character.compare(o1.getName().toLowerCase().charAt(0), o2.getName().toLowerCase().charAt(0));
        }
        return Integer.compare(o1.getName().length(), o2.getName().length());
    }
}
