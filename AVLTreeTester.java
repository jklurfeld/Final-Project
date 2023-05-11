public class AVLTreeTester {

    public static void classTester(){
        System.out.println("==== TESTING AVLTree CLASS ====");
        System.out.println("Creating new tree...");
        AVLTree tree = new AVLTree();
        System.out.println("Result of isEmpty(): " + tree.isEmpty());
        System.out.println("Result of getRoot(): " + tree.getRoot());
        System.out.println("current tree: " + tree + "\n");

        System.out.println("Inserting 5 into the tree..");
        tree.setRoot(new AVLNode(5));
        System.out.println("Result of isEmpty(): " + tree.isEmpty());
        System.out.println("Result of getRoot(): " + tree.getRoot());
        System.out.println("Result of isBalanced(): " + isBalanced(tree, tree.getRoot()));
        System.out.println("Result of isBinSearchTree(): " + isBinSearchTree(tree, tree.getRoot()));
        System.out.println("current tree: " + tree + "\n");

        System.out.println("Inserting 1 in tree...");
        tree.insert(new AVLNode(1));
        System.out.println("Result of isBalanced(): " + isBalanced(tree, tree.getRoot()));
        System.out.println("Result of isBinSearchTree(): " + isBinSearchTree(tree, tree.getRoot()));
        System.out.println("current tree: " + tree + "\n");

        System.out.println("Inserting 2 in tree...");
        tree.insert(new AVLNode(2));
        System.out.println("Result of isBalanced(): " + isBalanced(tree, tree.getRoot()));
        System.out.println("Result of isBinSearchTree(): " + isBinSearchTree(tree, tree.getRoot()));
        System.out.println("current tree: " + tree + "\n");

        System.out.println("Inserting 10 in tree...");
        tree.insert(new AVLNode(10));
        System.out.println("Result of isBalanced(): " + isBalanced(tree, tree.getRoot()));
        System.out.println("Result of isBinSearchTree(): " + isBinSearchTree(tree, tree.getRoot()));
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

        System.out.println("Result of findMin() :" + tree.findMin(tree.getRoot()));
        System.out.println("Result of searching for 10 in the tree: " + tree.search(tree.getRoot(), 10));
        System.out.println("Result of searching for 22 in the tree: " + tree.search(tree.getRoot(), 22));
        System.out.println("Result of isBalanced(): " + isBalanced(tree, tree.getRoot()));
        System.out.println("Result of isBinSearchTree(): " + isBinSearchTree(tree, tree.getRoot()));

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
        AVLTree t = new AVLTree();
        System.out.println("Inserting 10, 5, 13, 8, and 15 into the tree...");
        t.insert(new AVLNode(10));
        t.insert(new AVLNode(5));
        t.insert(new AVLNode(13));
        t.insert(new AVLNode(8));
        t.insert(new AVLNode(15));
        System.out.println("current tree: " + t + "\n");

        System.out.println("Inserting 7 into the tree...");
        t.insert(new AVLNode(7));
        System.out.println("current tree: " + t + "\n");

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
        tree.insert(new AVLNode(20));
        tree.insert(new AVLNode(40));
        tree.insert(new AVLNode(25));
        System.out.println("current tree: " + tree + "\n");

        System.out.println("Deleting 20...");
        tree.delete(20);
        System.out.println("current tree: " + tree + "\n");

        System.out.println("Done testing the deletion of a node with two children.");
    }

    public static void caseThatWasntWorkingTester(){
        System.out.println("Creating new tree, setting root to 14, and inserting 3, 17, 2, and 6...");
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

    public static void leftRightRotateDeletionTester(){
        System.out.println("Creating new tree, setting root to 14, and inserting 3, 17, 2, 6, 20, and 4...");
        AVLTree tree = new AVLTree();
        tree.setRoot(new AVLNode(14));
        tree.insert(new AVLNode(3));
        tree.insert(new AVLNode(17));
        tree.insert(new AVLNode(2));
        tree.insert(new AVLNode(6));
        tree.insert(new AVLNode(20));
        tree.insert(new AVLNode(4));
        System.out.println("current tree: " + tree);

        System.out.println("Deleting 20...");
        tree.delete(20);
        System.out.println("current tree: " + tree);

        System.out.println("Done testing left right rotation after deletion.");
    }

    public static void randomTester(int numTries){
        for (int i = 0; i < numTries; i++){
            int[] data = new int[10];
            AVLTree tree = new AVLTree();
            for (int j = 0; j < 10; j++){
                data[j] = (int)(Math.random()*100);
                tree.insert(new AVLNode(data[j]));
                // System.out.println(tree);
            }
            if (!isBalanced(tree, tree.getRoot())){
                System.out.println("Tree that is not balanced after insertion: " + tree);
                return;
            }
            if (!isBinSearchTree(tree, tree.getRoot())){
                System.out.println("Tree that's not a binSearchTree after insertion: " + tree);
            }
            tree.delete(data[(int)(Math.random()*9)]);
            if (!isBalanced(tree, tree.getRoot())){
                System.out.println("Tree that is not balanced after deletion: " + tree);
                return;
            }
            if (!isBinSearchTree(tree, tree.getRoot())){
                System.out.println("Tree that's not a binSearchTree after deletion: " + tree);
            }
        }
    }

    // the following two methods isBalanced() and isBinSearchTree() are helper methods for the random tester
    public static boolean isBalanced(AVLTree tree, AVLNode root){
        if (tree.getBalance(root) > 1 || tree.getBalance(root) < -1){
            return false;
        }
        else if (root.getRight() != null){
            isBalanced(tree, root.getRight());
        }
        else if (root.getLeft() != null){
            isBalanced(tree, root.getLeft());
        }
        return true;
    }

    public static boolean isBinSearchTree(AVLTree tree, AVLNode root){
        if (root.getRight() != null){
            if (root.getRight().getData() < root.getData()){
                return false;
            }
            isBinSearchTree(tree, root.getRight());
        }
        if (root.getLeft() != null){
            if (root.getLeft().getData() > root.getData()){
                return false;
            }
            isBinSearchTree(tree, root.getLeft());
        }
        return true;
    }

    public static void main(String[] args){
        // classTester();
        // rootRightRotateTester();
        // rootLeftRotateTester();
        // rootRightLeftRotateTester();
        // rootLeftRightRotateTester();
        // rightRotateTester();
        // leftRotateTester();
        // leftRightRotateTester();
        // rightLeftRotateTester();
        // deleteRootTester();
        // deletionOfLeafTester();
        // deletionOfNodeWithOneChildTester();
        // deletionOfNodeWithTwoChildrenTester();
        // caseThatWasntWorkingTester();
        // leftRightRotateDeletionTester();
        randomTester(100);
    }
}
