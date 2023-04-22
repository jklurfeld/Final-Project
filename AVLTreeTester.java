public class AVLTreeTester {
    public static void tester(){
        System.out.println("==== TESTING AVLTree CLASS ====");
        System.out.println("Creating new tree and setting root to 5...");
        AVLTree tree = new AVLTree();
        tree.setRoot(new AVLNode(5));
        System.out.println("current tree: " + tree);
        System.out.println("Inserting 1 in tree...");
        tree.insert(new AVLNode(1));
        System.out.println("current tree: " + tree);
        System.out.println("Inserting 2 in tree...");
        System.out.println("current tree: " + tree);
    }

    public static void main(String[] args){
        tester();
    }
}
