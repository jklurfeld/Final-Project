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

        // TODO: test max, height, and getBalance?

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

        System.out.println("Done testing leftRightRotate function.");
    }

    // public static void searchTester(){
    //     System.out.println("==== Testing search method ====");
    //     System.out.println("Creating new tree and setting root to 10...");
    //     AVLTree tree = new AVLTree();
    //     tree.setRoot(new AVLNode(10));

    //     System.out.println("Inserting 5 in the tree...");
    //     tree.insert(new AVLNode(5));

    //     System.out.println("Inserting 12 in the tree...");
    //     tree.insert(new AVLNode(12));

    //     System.out.println("Inserting 2 in the tree...");
    //     tree.insert(new AVLNode(2));

    //     System.out.println("Inserting 15 in the tree...");
    //     tree.insert(new AVLNode(15));
    //     System.out.println("current tree: " + tree + "\n");

    //     System.out.println("Searching for 2 in the tree...");
    //     System.out.println("Result of searching for 2: " + tree.search(2).getData());

    //     System.out.println("Searching for 20 in the tree...");
    //     System.out.println("Result of searching for 2: " + tree.search(20));

    //     System.out.println("Done testing search method.");
    // }

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
        // searchTester();
        deleteRootTester();
    }
}
