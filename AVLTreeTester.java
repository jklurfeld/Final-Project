public class AVLTreeTester {
    public static void tester(){
        System.out.println("==== TESTING AVLTree CLASS ====");
        AVLTree tree = new AVLTree();
        tree.setRoot(new AVLNode(5));
        System.out.println(tree);
        tree.addLeft(new AVLNode(2), tree.getRoot());
        System.out.println(tree);
        System.out.println("tree.getLeft(): " + tree.getRoot().getLeft());
        System.out.println("height of left tree: " + tree.getRoot().calculateHeight(tree.getRoot().getLeft()));
        System.out.println("root's balance: " + tree.getRoot().getBalanceFactor());
        System.out.println(tree);
    }

    public static void main(String[] args){
        tester();
    }
}
