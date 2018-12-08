
public class BTreeTester {

	@SuppressWarnings("unlikely-arg-type")
	public static void main(String[] args) {
		BTree testTree = null;
		String fileName = "query 1";
		int degree = 4;
		int numTest = 0;
		int testPassed = 0;
		System.out.println("Test: Creating a btree with a file");
		numTest++;
		try {
			testTree = new BTree(degree, fileName, true, 100);
			testPassed++;
			System.out.println(" Test passed " + '\n');
		} catch (Exception e) {
			System.out.println("Test failed" + '\n');
		}

		// Test insert 1
		numTest++;
		try {
			if (testTreeInsert(testTree, 1, "Insert 1")) {
				System.out.println("Test Passed " + '\n');
				testPassed++;
			} else {
				System.out.println("Test Failed " + '\n');
			}
		} catch (Exception e) {
			System.out.println("Test Failed" + '\n');
		}

		// Test insert 2 after 1
		numTest++;
		try {
			if (testTreeInsert(testTree, 2, "Insert 2")) {
				System.out.println("Test Passed " + '\n');
				testPassed++;
			} else {
				System.out.println("Test Failed " + '\n');
			}
		} catch (Exception e) {
			System.out.println("Test Failed" + '\n');
		}
		// Test insert 4 after 2
		numTest++;
		try {
			if (testTreeInsert(testTree, 4, "Insert 4")) {
				System.out.println("Test Passed " + '\n');
				testPassed++;
			} else {
				System.out.println("Test Failed " + '\n');
			}
		} catch (Exception e) {
			System.out.println("Test Failed" + '\n');
		}
		// Test insert 3 after 4
		numTest++;
		try {
			if (testTreeInsert(testTree, 3, "Insert 3")) {
				System.out.println("Test Passed " + '\n');
				testPassed++;
			} else {
				System.out.println("Test Failed " + '\n');
			}
		} catch (Exception e) {
			System.out.println("Test Failed" + '\n');
		}
		// Test insert 0 after 3
		numTest++;
		try {
			if (testTreeInsert(testTree, 0, "Insert 0")) {
				System.out.println("Test Passed " + '\n');
				testPassed++;
			} else {
				System.out.println("Test Failed " + '\n');
			}
		} catch (Exception e) {
			System.out.println("Test Failed" + '\n');
		}
		// Test Insert 20
		numTest++;
		try {
			if (testTreeInsert(testTree, 20, "Insert 20")) {
				System.out.println("Test Passed " + '\n');
				testPassed++;
			} else {
				System.out.println("Test Failed " + '\n');
			}
		} catch (Exception e) {
			System.out.println("Test Failed" + '\n');
		}
		System.out.println("Test Tree after all inserts " + testTree);
		// test search for 1
		numTest++;
		System.out.println("Test for search 1");
		TreeObject testObject = new TreeObject(1);
		if (testTree.search(testTree.getRoot(), testObject.getData()) == testObject) {
			System.out.println("Test Passed" + '\n');
			testPassed++;
		} else {
			System.out.println("Test failed" + '\n');
		}

		// test search for 10
		numTest++;
		System.out.println("Test for search 10");
		testObject = new TreeObject(10);
		if (testTree.search(testTree.getRoot(), testObject.getData()) == testObject) {
			System.out.println("Test Failed" + '\n');

		} else {
			System.out.println("Test passed" + '\n');
			testPassed++;
		}
		// Test delete 2
		numTest++;
		if (testTreeRemove(testTree, 2, "Test remove 2")) {
			System.out.println("Test Passed " + '\n');
			testPassed++;
		} else {
			System.out.println("Test Failed " + '\n');
		}
		// Test delete 0
		numTest++;
		if (testTreeRemove(testTree, 0, "Test remove 0")) {
			System.out.println("Test Passed " + '\n');
			testPassed++;
		} else {
			System.out.println("Test Failed " + '\n');
		}
		// test delete 20
		numTest++;
		if (testTreeRemove(testTree, 20, "Test remove 20")) {
			System.out.println("Test Passed " + '\n');
			testPassed++;
		} else {
			System.out.println("Test Failed " + '\n');
		}
		// Test delete 15
		numTest++;
		if (testTreeRemove(testTree, 15, "Test remove 15")) {
			System.out.println("Test Failed " + '\n');

		} else {
			System.out.println("Test Passed " + '\n');
			testPassed++;
		}
		// Test search for del 3
		numTest++;
		if (testTree.searchForDel(testTree.getRoot(), 3).equals(testObject)) {
			System.out.println("Test Passed " + '\n');
			testPassed++;
		} else {
			System.out.println("Test Failed " + '\n');
		}
		// test get root
		System.out.println("Test to see if the get root matches the printed root " + testTree.getRoot());
		System.out.println("Test Tree after all deletes " + testTree);
		System.out.println("Test taken: " + numTest + " Test Passed: " + testPassed + " Percent passed: "
				+ (double) testPassed / numTest);
	}

	/**
	 * inserts an object from the tree with the specified key
	 * 
	 * @param practiceNode
	 * @param key
	 * @param testName
	 * @return
	 */
	static boolean testTreeInsert(BTree testTree, long key, String testName) {
		TreeObject practiceObject = new TreeObject(key);
		System.out.println("Test Insert : " + testName);
		try {
			testTree.bTreeInsert(practiceObject.getData());
			return true;

		} catch (Exception e) {
			System.out.println("node is full");
			return false;
		}
	}

	/**
	 * removes an object from the btree
	 * 
	 * @param practiceNode
	 * @param key
	 * @param testName
	 * @return
	 */
	static boolean testTreeRemove(BTree testTree, long key, String testName) {
		TreeObject practiceObject = new TreeObject(key);
		System.out.println("Test Remove " + testName);

		try {
			testTree.delete(testTree.getRoot(), practiceObject);
			return true;
		}

		catch (Exception c) {
			System.out.println("Object not found");
			return false;
		}
	}
}
