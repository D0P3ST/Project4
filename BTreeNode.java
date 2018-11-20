import java.util.Arrays;
/** 
 * The BTreeNode class
 * 
 */
public class BTreeNode {

	public TreeObject keys[]; 
	public int pointers[]; 
	public boolean isLeaf; 
	private int numOfObjects; 
	private int maxNum;

	/**
	 * 
	 * Basic a constructor to create a B- Tree Node
	 * @param degree(utilize all the capacity in each node [optimal t degree])
	 */
	public BTreeNode(int degree) {
		this.maxNum=degree*2-1;
		this.keys = new TreeObject[degree*2-1];// maximum key = 2*degree -1
		// Create a list of Tree Objects
		for(int i=0; i<(degree*2-1); i++) {
			this.keys[i]= new TreeObject(0);
		}
		this.pointers = new int[degree*2]; // A list of pointers with the parent pointer is 4 bytes
		this.isLeaf = true; // every new created node is a leaf
		this.numOfObjects = 0;// the number of objects in each node
	}

	/**
	 * Get an object from TreeObject class
	 * @return objects
	 */
	public TreeObject[] getKeys() {
		return keys;
	}

	/**
	 * Set object to the given value
	 * @param objects
	 */
	public void setObjects(TreeObject[] objects) {
		this.keys = objects;
	}

	/**
	 * Get a pointer
	 * @return pointer
	 */
	public int[] getPointers() {
		return pointers;
	}

	/**
	 * Set pointers to the given value
	 * @param pointers
	 */
	public void setPointers(int[] pointers) {
		this.pointers = pointers;
	}

	/**
	 * Get a isLeaf
	 * @return isLeaf 
	 */
	public boolean isLeaf()
	{
		return isLeaf;
	}

	/**
	 * Set isLeaf to the given value
	 * @param isLeaf
	 */
	public void setIsLeaf(boolean isLeaf)
	{
		this.isLeaf = isLeaf;
	}

	/**
	 * Get the number of objects
	 * @return numOfobject
	 */
	public int getNumOfObjects() 
	{
		return numOfObjects;
	}

	/**
	 * Set the number of object to the given value
	 * @param numOfObjects
	 */
	public void setNumOfObjects(int numOfObjects) {
		this.numOfObjects = numOfObjects;
	}
	
	/**
	 * Check if the node is full
	 * @return true if the node is full 
	 */
	public boolean isFull() {
		return(numOfObjects==maxNum);
	}

	/** Overwrite the toString method
	 * Return the string to print out
	 */
	@Override
	public String toString() {
		return "BTreeNode [objects=" + Arrays.toString(keys) + ", pointers=" + Arrays.toString(pointers)
		+ ", isLeaf=" + isLeaf + ", numOfObjects=" + numOfObjects + "]";
	}
}