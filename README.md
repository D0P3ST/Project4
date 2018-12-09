# Project4

Project Overview:
This is the BTree project. It takes the following command line argumetns to to run and store bioinformatics information.

java GeneBankCreateBTree [0 | 1(no/with Cache)] [degree] [gbk file] [sequence length] [ | cache size] [ | debug level]
or
java GeneBankSearch [0 | 1(no/with Cache)] [btree file] [query file] [ | cache size] [ | debug level]

*NOTE: To ensure a correct result, you must ensure the btree file and query length are matching. 
Example: java GeneBankSearch 1 test1.gbk.btree.data.3.2 query3 100 1

Cache Speed:
Through testing we dicovered that useing the cache does help with time completion in seemingly all cases, but the size of the cache does not impact that time to completion at all.

Project Files:
- BTree: The BTree constructor class.
- BTreeTester: The test class for BTree.
- BTreeCache: The cache class used by the BTree.
- BTreeConvert: Class that converts between String and long integer representation of gene sequences.
- BtreeData: The BTree Data parsing class.
- BTreeNode: The node class used by BTree.
- BTreeNodeTester: The BTreeNode test class.
- GeneBankSearch: Searches BTree with a given sequence.
- GeneBankCreateBTree: Creates a BTree from a gbk file.
- TreeObject: The object class used by BTree.
- README: This file.

Reflections:

Chris: 
I made the BTreeNodeTesterClass along with Sean. I also did the UML/README, along with the javadocs and making sure everything worked in tandem. I felt pretty good about the project, but felt not doing to much with the main BTree class ment I didn't have a deep understanding of BTree logic in practice as I would have liked.

Van:
I felt like this project is kind of hard and it requires a huge amount of time to debug. The most interesting thing I learnt from this project is how to write/read data from a file and use bitwise operations to convert data into binary encoded sequence.

Sean: I worked on all of the test classes with Chris. I felt that the project went pretty smooth. I really wanted to get some more practice in writing test case. I just wish we would have had a little more time to put more tests in. 
