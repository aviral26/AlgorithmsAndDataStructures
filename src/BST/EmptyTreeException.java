package BST;

public class EmptyTreeException extends Exception {
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		public EmptyTreeException(){
			System.out.println("Looks like you're trying to remove from an empty tree!");
		}
}
