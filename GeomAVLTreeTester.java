public class GeomAVLTreeTester {
    public static void setPointsTester(){
        System.out.println("==== Testing setPoints() ====");
        System.out.println("Creating new tree and setting root to 10...");
        GeomAVLTree tree = new GeomAVLTree();
        tree.setRoot(new AVLNode(10));
        System.out.println("current tree: " + tree + "\n");

        System.out.println("Inserting 5 in the tree...");
        tree.insert(new AVLNode(5));
        System.out.println("current tree: " + tree + "\n");

        System.out.println("Inserting 2 in the tree...");
        tree.insert(new AVLNode(2));
        System.out.println("current tree: " + tree + "\n");

        System.out.println("Calling setPoints() on this tree...");
        tree.setPoints(tree.getRoot(), 1);
        System.out.println("current tree: " + tree + "\n");
    }
    public static void main(String[] args){
        setPointsTester();
    }
}
