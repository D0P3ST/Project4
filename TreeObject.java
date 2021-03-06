/**
 * The object class used by BTree
 *
 * 
 */
public class TreeObject<T> implements Comparable<TreeObject>
{
    private int frequency;
    private long data;

    /**
     * @param data
     * @param frequency
     */
    public TreeObject(long data, int frequency)
    {
        this.data = data;
        this.frequency = frequency;
    }

    /**
     * @param data
     */
    public TreeObject(long data)
    {
        this.data = data;
        this.frequency = 1;
    }

    /**
     * updates frequency
     */
    public void increaseFrequency()
    {
        this.frequency++;
    }

    /**
     * @return frequency
     */
    public int getFrequency()
    {
        return frequency;
    }

    /**
     * @return data
     */
    public long getData()
    {
        return data;
    }

    public int compareTo(TreeObject that)
    {
        if (this.data < that.data)
            return -1;
        else if (this.data > that.data)
            return 1;
        else
            return 0;
    }

    public String toString()
    {
        String s = new String();
        s += "Key: " + data + " Frequency: " + frequency;
        return s;
    }
   
}
