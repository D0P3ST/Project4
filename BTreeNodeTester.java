
public class BTreeNodeTester {

	public static void main(String[] args) {
		int degree = 4;
		int numTest = 0;
		int testPassed = 0;
		TreeObject practiceObject = new TreeObject(31);
		long key[] = new long[degree * 2 - 1];
		BTreeNode practiceNode = new BTreeNode(degree);
		// Test empty remove
		System.out.println("Test Empty remove");
		numTest++;
		try {
			if (practiceNode.removeNode(practiceObject) == null) {
				System.out.println("Test passed " + '\n');
				testPassed++;
			} else {
				System.out.println('\n' + "Test Failed");
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			System.out.println("node is empty");
		}
		// test input a full node
		for (int i = 0; i < degree * 2 - 1; i++) {
			key[i] = i;
			practiceObject = new TreeObject(key[i]);
			try {
				practiceNode.addNode(practiceObject);
				numTest++;
				testPassed++;
			} catch (Exception e) {
				System.out.println("node is full");
				e.printStackTrace();
			}
		}
		int[] pointers = { 0, 1, 2, 3 };
		practiceNode.setPointers(pointers);
		System.out.println("test input: " + practiceNode.toString());
		System.out.println('\n' + "Test max number");
		numTest++;
		// Test insert full node
		if (practiceNode.getMaxNum() == degree * 2 - 1) {
			System.out.println("Test passed max number = " + practiceNode.getMaxNum() + '\n');
			testPassed++;
		} else {
			System.out.println("Test failed");
		}
		System.out.println("Test full input: ");
		practiceObject = new TreeObject(1);
		numTest++;
		// Test input into a full node. should throw exception.
		try {
			practiceNode.addNode(practiceObject);
			System.out.println("Test Failed ");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Test passed " + '\n');
			testPassed++;
		}
		System.out.println("Test remove first");
		numTest++;
		try {
			practiceNode.removeNode(practiceObject);
			System.out.println("Test Passed" + '\n');
			testPassed++;

		} catch (Exception e) {
			System.out.println("Test Failed" + '\n');
		}
		// add a number
		numTest++;
		if (testNumberInsert(practiceNode, 15, "15") == true) {
			System.out.println("Test Passed ");
			testPassed++;
		} else {
			System.out.println("Test Failed");
		}
		//remove last
		numTest++;
		if (testNumberRemove(practiceNode, practiceNode.getSingleObject(practiceNode.getMaxNum()-2).getKey(), "Remove Last") == true) {
			System.out.println("Test Passed ");
			testPassed++;
		} else {
			System.out.println("Test Failed" + practiceNode.toString());
		}
		System.out.println("The node after all test: " + practiceNode.toString());
		// total number of tests
		System.out.println('\n' + "Test taken: " + numTest + " Test Passed: " + testPassed + " Percent: "
				+ (double) testPassed / numTest);
	}

	static boolean testNumberInsert(BTreeNode practiceNode, long key, String testName) {
		TreeObject practiceObject = new TreeObject(key);
		System.out.println("Test Insert : " + testName);
		try {
			practiceNode.addNode(practiceObject);
			return true;

		} catch (Exception e) {
			System.out.println("node is full");
			return false;
		}
	}

	static boolean testNumberRemove(BTreeNode practiceNode, long key, String testName) {
		TreeObject practiceObject = new TreeObject(key);
		System.out.println("Test remove : " + testName);

		if (practiceNode.removeNode(practiceObject) != null) {
			return true;
		} else {
			System.out.println("Object not found");
			return false;
		}
	}

}
