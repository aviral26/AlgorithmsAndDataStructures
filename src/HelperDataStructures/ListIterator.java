package HelperDataStructures;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class ListIterator<T> implements Iterator<T> {

	private Node<T> current;

    public ListIterator(Node<T> first) {
        current = first;
    }

    public boolean hasNext(){ 
    	return current != null;
    }
    
    public void remove(){ 
    	throw new UnsupportedOperationException();
    }

    public T next() {
        if (!hasNext()) throw new NoSuchElementException();
        T item = current.value;
        current = current.next; 
        return item;
    }
}
