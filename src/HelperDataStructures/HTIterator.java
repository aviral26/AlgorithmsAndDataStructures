package HelperDataStructures;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class HTIterator implements Iterator<String> {

		private HT.Node current;

	    public HTIterator(HT.Node first) {
	        current = first;
	    }

	    public boolean hasNext(){ 
	    	return current != null;
	    }
	    
	    public void remove(){ 
	    	throw new UnsupportedOperationException();
	    }

	    public String next() {
	        if (!hasNext()) throw new NoSuchElementException();
	        HT.Node item = current;
	        current = current.next; 
	        return item.value;
	    }
	
}
