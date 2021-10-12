public class Sorter<T> {

    public static<T extends Comparable<T>> void sort(CustomList<T> customList){
        for (int i = 0; i < customList.size(); i++) {
            T temp = customList.get(i);
            for (int j = i + 1; j < customList.size(); j++) {
                T next = customList.get(j);
                if(temp.compareTo(next) > 0){
                    customList.swap(i, j);
                }
            }
        }
    }
}
