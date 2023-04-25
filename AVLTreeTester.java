public class AVLTreeTester {
    public static void classTester(){
        System.out.println("==== TESTING AVLTree CLASS ====");
        System.out.println("Creating new tree and setting root to 5...");
        AVLTree tree = new AVLTree();
        tree.setRoot(new AVLNode(5));
        System.out.println("current tree: " + tree + "\n");

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
        System.out.println("==== Testing leftRightRotate method ====");
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

        System.out.println("Done testing leftRightRotate method.");
    }

    public static void main(String[] args){
        // classTester();
        // rootRightRotateTester();
        // rootLeftRotateTester();
        // rootRightLeftRotateTester();
        // rootLeftRightRotateTester();
        // rightRotateTester();
        // leftRotateTester();
        leftRightRotateTester();
    }
}
