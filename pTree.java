public class pTree{
	int value;
	pTree left, right, parent;
	pTree(int value, pTree l, pTree r, pTree p){
		this.value = value;
		left = l;
		right = r;
		parent = p;
	}
}