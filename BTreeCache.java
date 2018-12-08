import java.util.Iterator;
import java.util.LinkedList;

/**
 * The cache class is implemented for the sake of the Cache
 *
 * 
 */
public class BTreeCache implements Iterable<BTreeNode>
{
	private LinkedList<BTreeNode> cacheList;
	private int numHits, numMisses;
    private final int MAX_CACHE_SIZE;
   	private int size;
   

    /**
     * @param MAX_SIZE
     */
    public BTreeCache(int MAX_SIZE)
    {
        this.size=0;
    	this.MAX_CACHE_SIZE = MAX_SIZE;
        cacheList = new LinkedList<BTreeNode>();
    }

   

    /**
     * clears cache
     */
    public void clearCache()
    {
        cacheList.clear();
    }

   
    /**
     * @param nodeOffset
     * @return n
     */
    public BTreeNode readNode(int nodeOffset)
    {
        for (BTreeNode n : cacheList)
        {
            if (n.getOffset() == nodeOffset)
            {
                cacheList.remove(n); // the remove method of linked list
                cacheList.addFirst(n); // the add method of linked list
                increaseNumHits();
                return n;
            }
        }
        increaseNumMisses();
        return null;
    }

    /**
     * @param nodeToAdd
     * @param offset
     * @return nodeToReturn
     */
    public BTreeNode add(BTreeNode nodeToAdd, int offset)
    {
        BTreeNode nodeToReturn = null;
        if (isFull()) {
            nodeToReturn = cacheList.removeLast();}
        
	cacheList.addFirst(nodeToAdd);
        size++;
	return nodeToReturn;
    }

    /**
     * @return boolean
     */
    public boolean isFull()
    {
        return (size == MAX_CACHE_SIZE);
    }
    /**
     * @return numHits + numMisses
     */
    public int getNumHitsMiss()
    {
        return numHits + numMisses;
    }

    /**
     * increments numHits
     */
    private void increaseNumHits()
    {
        numHits++;
    }

    /**
     * increments numMisses
     */
    private void increaseNumMisses()
    {
        numMisses++;
    }

    /**
     * @return numHits
     */
    public int getNumHits()
    {
        return numHits;
    }

    /**
     * @return numMisses
     */
    public int getNumMisses()
    {
        return numMisses;
    }

    /**
     * @return ratio
     */
    public double getHitRatio()
    {
        double ratio = ((double) getNumHits()) / getNumHitsMiss();
        return ratio;
    }


    //The iterator constructor
    @Override
    public Iterator<BTreeNode> iterator()
    {
        return cacheList.iterator();
    }
}       
