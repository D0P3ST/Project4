

public class BTreeNodeTester {

	public static void main(String[] args) {
		int degree = 4;
		int numTest = 0;
		int testPassed = 0;
		TreeObject practiceObject = new TreeObject(31);
		long key[] = new long[degree* 2 -1];
		BTreeNode practiceNode = new BTreeNode(degree);
		//Test empty remove
		System.out.println("Test Empty remove");
		numTest++;
		try {
			if(practiceNode.remove(practiceObject) == null) {
				System.out.println( "Test passed " + '\n');
				testPassed++;
			}
			else {
				System.out.println('\n' + "Test Failed");
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			System.out.println("node is empty");
		}
		//test input a full node
		for(int i = 0; i < degree *2 -1; i++) {
			key[i] = i;
			practiceObject = new TreeObject(key[i]);
			try {
				practiceNode.insert(practiceObject);
				numTest++;
				testPassed++;
			} catch (Exception e) {
				System.out.println("node is full");
				e.printStackTrace();
			}
		}
		int[] pointers = {0,1,2,3};
		practiceNode.setPointers(pointers);
		System.out.println("test input: " + practiceNode.toString());
		System.out.println('\n' + "Test max number");
		numTest++;
		//Test insert full node
		if(practiceNode.getMaxNum() == degree * 2 - 1) {
			System.out.println("Test passed max number = " + practiceNode.getMaxNum() + '\n');
			testPassed++;
		}
		else {
			System.out.println("Test failed");
		}
		System.out.println("Test full input: ");
		practiceObject = new TreeObject(1);
		numTest++;
		//Test input into a full node. should throw exception. 
		try {
			practiceNode.insert(practiceObject);
			System.out.println("Test Failed ");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Test passed " + '\n');
			testPassed++;
		}
		System.out.println("Test remove first");
		numTest++;
		try {
			practiceNode.remove(practiceObject);
			System.out.println("Test Passed" + '\n');
			testPassed++;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Test Failed" + '\n');
		}
		//total number of tests
		System.out.println('\n' + "Test taken: " + numTest + " Test Passed: " + testPassed + " Percent: " + (double) testPassed/numTest );
	}

}
