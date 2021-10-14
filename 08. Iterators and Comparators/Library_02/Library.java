import java.util.Iterator;

public class Library implements Iterable<Book>{
    private Book[] books;

    public Library(Book... books) {
        this.books = books;
    }

    public Iterator<Book> iterator(){
        return new LibIterator();
    }

    private class LibIterator implements Iterator{
        private int count = 0;

        @Override
        public boolean hasNext() {
            return count < books.length;
        }

        @Override
        public Book next() {
            Book newB = null;
            if(this.hasNext()){
                newB = books[count];
                count++;
            }
            return newB;
        }
    }
}
