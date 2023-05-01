public class AVLTreeTester {
    public static void classTester(){
        System.out.println("==== TESTING AVLTree CLASS ====");
        System.out.println("Creating new tree...");
        AVLTree tree = new AVLTree();
        System.out.println("Result of isEmpty(): " + tree.isEmpty());
        System.out.println("Result of getRoot(): " + tree.getRoot());
        System.out.println("current tree: " + tree + "\n");

        tree.setRoot(new AVLNode(5));
        System.out.println("Result of isEmpty(): " + tree.isEmpty());
        System.out.println("Result of getRoot(): " + tree.getRoot());
        System.out.println("current tree: " + tree + "\n");

        // TODO: test max, height, getBalance, and findMin()?

        System.out.println("Inserting 1 in tree...");
        tree.insert(new AVLNode(1));
        System.out.println("current tree: " + tree + "\n");

        System.out.println("Inserting 2 in tree...");
        tree.insert(new AVLNode(2));
        System.out.println("current tree: " + tree + "\n");

        System.out.println("Inserting 10 in tree...");
        tree.insert(new AVLNode(10));
        System.out.println("current tree: " + tree + "\n");
        
        System.out.println("Inserting 15 in tree...");
        tree.insert(new AVLNode(15));
        System.out.println("current tree: " + tree + "\n");

        System.out.println("Inserting 0 in tree...");
        tree.insert(new AVLNode(0));
        System.out.println("current tree: " + tree + "\n");

        System.out.println("Inserting -1 in tree...");
        tree.insert(new AVLNode(-1));
        System.out.println("current tree: " + tree + "\n");

        System.out.println("Done testing AVLTree class.");
    }

    public static void rootRightRotateTester(){
        System.out.println("==== Testing rootRightRotate method ====");
        System.out.println("Creating new tree and setting root to 10...");
        AVLTree tree = new AVLTree();
        tree.setRoot(new AVLNode(10));
        System.out.println("current tree: " + tree + "\n");

        System.out.println("Inserting 5 in the tree...");
        tree.insert(new AVLNode(5));
        System.out.println("current tree: " + tree + "\n");

        System.out.println("Inserting 2 in the tree...");
        tree.insert(new AVLNode(2));
        System.out.println("current tree: " + tree + "\n");
        System.out.println("Done testing rootRightRotate method.");
    }

    public static void rootLeftRotateTester(){
        System.out.println("==== Testing rootLeftRotate method ====");
        System.out.println("Creating new tree and setting root to 10...");
        AVLTree tree = new AVLTree();
        tree.setRoot(new AVLNode(10));
        System.out.println("current tree: " + tree + "\n");

        System.out.println("Inserting 15 in the tree...");
        tree.insert(new AVLNode(15));
        System.out.println("current tree: " + tree + "\n");

        System.out.println("Inserting 20 in the tree...");
        tree.insert(new AVLNode(20));
        System.out.println("current tree: " + tree + "\n");
        System.out.println("Done testing rootLeftRotate method.");
    }

    public static void rootRightLeftRotateTester(){
        System.out.println("==== Testing rootRightLeftRotate method ====");
        System.out.println("Creating new tree and setting root to 10...");
        AVLTree tree = new AVLTree();
        tree.setRoot(new AVLNode(10));
        System.out.println("current tree: " + tree + "\n");

        System.out.println("Inserting 15 in the tree...");
        tree.insert(new AVLNode(15));
        System.out.println("current tree: " + tree + "\n");

        System.out.println("Inserting 12 in the tree...");
        tree.insert(new AVLNode(12));
        System.out.println("current tree: " + tree + "\n");
        System.out.println("Done testing rootRightLeftRotate method.");
    }

    public static void rootLeftRightRotateTester(){
        System.out.println("==== Testing rootLeftRightRotate method ====");
        System.out.println("Creating new tree and setting root to 10...");
        AVLTree tree = new AVLTree();
        tree.setRoot(new AVLNode(10));
        System.out.println("current tree: " + tree + "\n");

        System.out.println("Inserting 2 in the tree...");
        tree.insert(new AVLNode(2));
        System.out.println("current tree: " + tree + "\n");

        System.out.println("Inserting 5 in the tree...");
        tree.insert(new AVLNode(5));
        System.out.println("current tree: " + tree + "\n");
        System.out.println("Done testing rootLeftRightRotate method.");
    }

    public static void rightRotateTester(){
        System.out.println("==== Testing rightRotate method ====");
        // TODO: add tester for right rotating in right subtree? already tested this in driver-- do I need hardcoded example?
        System.out.println("Creating new tree and setting root to 10...");
        AVLTree tree = new AVLTree();
        tree.setRoot(new AVLNode(10));
        System.out.println("current tree: " + tree + "\n");

        System.out.println("Inserting 5 in the tree...");
        tree.insert(new AVLNode(5));
        System.out.println("current tree: " + tree + "\n");

        System.out.println("Inserting 12 in the tree...");
        tree.insert(new AVLNode(12));
        System.out.println("current tree: " + tree + "\n");

        System.out.println("Inserting 2 in the tree...");
        tree.insert(new AVLNode(2));
        System.out.println("current tree: " + tree + "\n");

        System.out.println("Inserting 15 in the tree...");
        tree.insert(new AVLNode(15));
        System.out.println("current tree: " + tree + "\n");

        System.out.println("Inserting 1 in the tree...");
        tree.insert(new AVLNode(1));
        System.out.println("current tree: " + tree + "\n");



        System.out.println("Done testing rightRotate method.");
    }

    public static void leftRotateTester(){
        System.out.println("==== Testing leftRotate method ====");
        System.out.println("Testing left rotate in right subtree...");
        System.out.println("Creating new tree and setting root to 10...");
        AVLTree tree = new AVLTree();
        tree.setRoot(new AVLNode(10));
        System.out.println("current tree: " + tree + "\n");

        System.out.println("Inserting 5 in the tree...");
        tree.insert(new AVLNode(5));
        System.out.println("current tree: " + tree + "\n");

        System.out.println("Inserting 12 in the tree...");
        tree.insert(new AVLNode(12));
        System.out.println("current tree: " + tree + "\n");

        System.out.println("Inserting 2 in the tree...");
        tree.insert(new AVLNode(2));
        System.out.println("current tree: " + tree + "\n");

        System.out.println("Inserting 15 in the tree...");
        tree.insert(new AVLNode(15));
        System.out.println("current tree: " + tree + "\n");

        System.out.println("Inserting 20 in the tree...");
        tree.insert(new AVLNode(20));
        System.out.println("current tree: " + tree + "\n");

        System.out.println("Testing left rotation in left subtree...");
        System.out.println("Creating new tree and setting root to 20...");
        AVLTree t = new AVLTree();
        t.setRoot(new AVLNode(20));
        System.out.println("Inserting 10, 30, 40, and 15 into the tree...");
        t.insert(new AVLNode(10));
        t.insert(new AVLNode(30));
        t.insert(new AVLNode(40));
        t.insert(new AVLNode(15));
        System.out.println("current tree: " + t + "\n");

        System.out.println("Inserting 17 into the tree...");
        t.insert(new AVLNode(17));
        System.out.println("current tree: " + t + "\n");

        System.out.println("Done testing leftRotate method.");
    }

    public static void leftRightRotateTester(){
        System.out.println("==== Testing leftRightRotate function ====");
        System.out.println("Creating new tree and setting root to 10...");
        AVLTree tree = new AVLTree();
        tree.setRoot(new AVLNode(10));
        System.out.println("current tree: " + tree + "\n");

        System.out.println("Inserting 5 in the tree...");
        tree.insert(new AVLNode(5));
        System.out.println("current tree: " + tree + "\n");

        System.out.println("Inserting 12 in the tree...");
        tree.insert(new AVLNode(12));
        System.out.println("current tree: " + tree + "\n");

        System.out.println("Inserting 2 in the tree...");
        tree.insert(new AVLNode(2));
        System.out.println("current tree: " + tree + "\n");

        System.out.println("Inserting 15 in the tree...");
        tree.insert(new AVLNode(15));
        System.out.println("current tree: " + tree + "\n");

        System.out.println("Inserting 3 in the tree...");
        tree.insert(new AVLNode(3));
        System.out.println("current tree: " + tree + "\n");

        System.out.println("Done testing leftRightRotate function.");
    }

    public static void rightLeftRotateTester(){
        System.out.println("==== Testing rightLeftRotate function ====");
        System.out.println("Testing right left rotation in the right subtree...");
        System.out.println("Creating new tree and setting root to 10...");
        AVLTree tree = new AVLTree();
        tree.setRoot(new AVLNode(10));
        System.out.println("current tree: " + tree + "\n");

        System.out.println("Inserting 5 in the tree...");
        tree.insert(new AVLNode(5));
        System.out.println("current tree: " + tree + "\n");

        System.out.println("Inserting 12 in the tree...");
        tree.insert(new AVLNode(12));
        System.out.println("current tree: " + tree + "\n");

        System.out.println("Inserting 2 in the tree...");
        tree.insert(new AVLNode(2));
        System.out.println("current tree: " + tree + "\n");

        System.out.println("Inserting 15 in the tree...");
        tree.insert(new AVLNode(15));
        System.out.println("current tree: " + tree + "\n");

        System.out.println("Inserting 13 in the tree...");
        tree.insert(new AVLNode(13));
        System.out.println("current tree: " + tree + "\n");

        System.out.println("Testing right left rotation in the left subtree...");

        System.out.println("Done testing rightLeftRotate function.");
    }

    public static void deleteRootTester(){
        System.out.println("====TESTING DIFFERENT CASES OF DELETING THE ROOT====");
        System.out.println("Testing deleting root when root has no children...");
        System.out.println("Creating new tree and setting root to 10...");
        AVLTree tree = new AVLTree();
        tree.setRoot(new AVLNode(10));
        System.out.println("current tree: " + tree + "\n");

        System.out.println("Deleting root...");
        tree.delete(10);
        System.out.println("current tree: " + tree + "\n");

        System.out.println("Testing deleting root when root has only a left child...");
        System.out.println("Inserting 5 into the tree...");
        tree.insert(new AVLNode(5));
        System.out.println("current tree: " + tree + "\n");

        System.out.println("Inserting 1 into the tree...");
        tree.insert(new AVLNode(1));
        System.out.println("current tree: " + tree + "\n");

        System.out.println("Deleting root...");
        tree.delete(5);
        System.out.println("current tree: " + tree + "\n");

        System.out.println("Testing deleting root when root only has a right child...");
        System.out.println("Inserting 5 into the tree...");
        tree.insert(new AVLNode(5));
        System.out.println("current tree: " + tree + "\n");

        System.out.println("Deleting root...");
        tree.delete(1);
        System.out.println("current tree: " + tree + "\n");

        // TODO: test these two cases
        System.out.println("Testing deleting root when it has two children...");
        System.out.println("Inserting 3 and 15 into the tree...");
        tree.insert(new AVLNode(3));
        tree.insert(new AVLNode(15));
        System.out.println("current tree: " + tree + "\n");

        System.out.println("Deleting root (5)...");
        tree.delete(5);
        System.out.println("current tree: " + tree + "\n");

        System.out.println("Testing deleting root when it has two subtrees...");
        System.out.println("Inserting 30, 0 , 5, 20, and 40 into the tree...");
        tree.insert(new AVLNode(30));
        tree.insert(new AVLNode(0));
        tree.insert(new AVLNode(5));
        tree.insert(new AVLNode(20));
        tree.insert(new AVLNode(40));
        System.out.println("current tree: " + tree + "\n");

        System.out.println("Deleting root (15)...");
        tree.delete(15);
        System.out.println("current tree: " + tree + "\n");

        System.out.println("Done testing the deletion of the root.");
    }

    public static void deletionOfLeafTester(){
        System.out.println("==== TESTING THE DELETION OF A LEAF ====");
        System.out.println("Creating new tree, setting root to 10, and inserting 1 and 20...");
        AVLTree tree = new AVLTree();
        tree.setRoot(new AVLNode(10));
        tree.insert(new AVLNode(1));
        tree.insert(new AVLNode(20));
        System.out.println("current tree: " + tree + "\n");

        System.out.println("Deleting 1...");
        tree.delete(1);
        System.out.println("current tree: " + tree + "\n");

        System.out.println("Deleting 20...");
        tree.delete(20);
        System.out.println("current tree: " + tree + "\n");

        System.out.println("Inserting 15 in the tree...");
        tree.insert(new AVLNode(15));
        System.out.println("current tree: " + tree + "\n");

        System.out.println("Deleting 15...");
        tree.delete(15);
        System.out.println("current tree: " + tree + "\n");

        System.out.println("Inserting 17, 13, 12, 18, 5, and 11 in the tree...");
        tree.insert(new AVLNode(17));
        tree.insert(new AVLNode(13));
        tree.insert(new AVLNode(12));
        tree.insert(new AVLNode(18));
        tree.insert(new AVLNode(5));
        tree.insert(new AVLNode(11));
        System.out.println("current tree: " + tree + "\n");

        //if you switch this to 5, then you'd be testing if the tree can rebalance itself after deleting a node
        System.out.println("Deleting 5...");
        tree.delete(5);
        System.out.println("current tree: " + tree + "\n");

        System.out.println("Done testing the deletion of a leaf.");
    }

    public static void deletionOfNodeWithOneChildTester(){
        System.out.println("==== TESTING THE DELETION OF A NODE WITH ONE CHILD ====");
        System.out.println("Creating new tree, setting root to 10, and inserting 1, 20, and 30...");
        AVLTree tree = new AVLTree();
        tree.setRoot(new AVLNode(10));
        tree.insert(new AVLNode(1));
        tree.insert(new AVLNode(20));
        tree.insert(new AVLNode(30));
        System.out.println("current tree: " + tree + "\n");

        System.out.println("Deleting 20...");
        tree.delete(20);
        System.out.println("current tree: " + tree + "\n");

        System.out.println("Inserting 0, 5, 20, 40, and 25");
        tree.insert(new AVLNode(0));
        tree.insert(new AVLNode(5));
        tree.insert(new AVLNode(20));
        tree.insert(new AVLNode(40));
        tree.insert(new AVLNode(25));
        System.out.println("current tree: " + tree + "\n");

        System.out.println("Deleting 20...");
        tree.delete(20);
        System.out.println("current tree: " + tree + "\n");

        System.out.println("Done testing the deletion of a node with one child.");
    }

    public static void deletionOfNodeWithTwoChildrenTester(){
        System.out.println("==== TESTING THE DELETION OF A NODE WITH TWO CHILDREN ====");
        System.out.println("Creating new tree, setting root to 10, and inserting 1, 20, 30, and 15...");
        AVLTree tree = new AVLTree();
        tree.setRoot(new AVLNode(10));
        tree.insert(new AVLNode(1));
        tree.insert(new AVLNode(20));
        tree.insert(new AVLNode(30));
        tree.insert(new AVLNode(15));
        System.out.println("current tree: " + tree + "\n");

        System.out.println("Deleting 20...");
        tree.delete(20);
        System.out.println("current tree: " + tree + "\n");

        System.out.println("Inserting 0, 5, 20, 40, and 25");
        tree.insert(new AVLNode(0));
        tree.insert(new AVLNode(5));
        tree.insert(new AVLNode(13));
        tree.insert(new AVLNode(11));
        tree.insert(new AVLNode(14));
        System.out.println("current tree: " + tree + "\n");

        // this isn't working because it's finding the minimum value in the left subtree when it should be doing that in the right subtree
        System.out.println("Deleting 15...");
        tree.delete(15);
        System.out.println("current tree: " + tree + "\n");

        System.out.println("Done testing the deletion of a node with two children.");
    }

    public static void tester(){
        System.out.println("Creating new tree, setting root to 6, and inserting 3, 7, and 5...");
        AVLTree tree = new AVLTree();
        tree.setRoot(new AVLNode(14));
        tree.insert(new AVLNode(3));
        tree.insert(new AVLNode(17));
        tree.insert(new AVLNode(2));
        tree.insert(new AVLNode(6));
        System.out.println("current tree: " + tree + "\n");

        System.out.println("inserting 4...");
        tree.insert(new AVLNode(4));
        System.out.println("current tree: " + tree);
    }

    public static void main(String[] args){
        // classTester();
        // rootRightRotateTester();
        // rootLeftRotateTester();
        // rootRightLeftRotateTester();
        // rootLeftRightRotateTester();
        // rightRotateTester();
        leftRotateTester();
        // leftRightRotateTester();
        // rightLeftRotateTester();
        // deleteRootTester();
        // deletionOfLeafTester();
        // deletionOfNodeWithOneChildTester();
        // deletionOfNodeWithTwoChildrenTester();
        // tester();
    }
}
