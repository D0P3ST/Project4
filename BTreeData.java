/**
 * 
 *
 * 
 */
public class BTreeData {

	public BTreeData(BTree btree){

	}
	// from long to sequence
	public String longToSeq(long key,int k){
		String bString = " ";
		long hold;
		char c;
		for(int i=0;i<k;i++)
		{
			hold=key;
			hold=hold>>(2*i);
		hold=hold&0x03;
		c=convertBin(hold);
		bString+=c;
		}

		return bString;
	}
	
	
	
	
	
	

	//from sequence to long
	public long seqToLong(String input,int num){
		long key =0x000000;
		long pos;
		byte tbits = 0x00;
		for(int i=0;i<num;i++)
		{
			switch (input.charAt(i))
			{
			case 'a':
				tbits=0x00;
				break;
			case 'c':
				tbits=0x01;
				break;
			case 'g':
				tbits=0x02;
				break;
			case 't':
				tbits=0x03;
				break;
			}
			pos=tbits<<(2*i);
			key=key|pos;
		}
		return key;
	}
	/*
	 * 
	 */
	private char convertBin(long key){
		char tmp = ' ';
		if(key==0x00)
		{
			tmp='a';
		}
		if(key==0x01)
		{
			tmp='c';
		}
		if(key==0x02)
		{
			tmp='g';
		}
		if(key==0x03)
		{
			tmp='t';
		}
		return tmp;
	}

}