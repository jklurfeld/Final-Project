public class AVLNodeTester {
    public static void tester(){
        System.out.println("=== Testing AVLNode class ===");
        System.out.println("Creating a new node called node and setting its data to 10...");
        AVLNode node = new AVLNode(10);
        System.out.println("Current node: " + node);
        System.out.println("Setting right child to a node with the data 2 and setting that child's parent to the parent node...");
        AVLNode right = new AVLNode(2);
        node.setRight(right);
        right.setParent(node);
        System.out.println("node.getRight(): " + node.getRight());
        System.out.println("node.getRight().getParent(): " + node.getRight().getParent());
        System.out.println("Setting height of the parent node to 2...");
        node.setHeight(2);
        System.out.println("node.getHeight(): " + node.getHeight());
        System.out.println("Setting left child to a node with the data 5 and setting that child's parent to the parent node...");
        AVLNode left = new AVLNode(5);
        node.setLeft(left);
        left.setParent(node);
        System.out.println("node.getLeft(): " + node.getLeft());
        System.out.println("node.getLeft().getParent(): " + node.getLeft().getParent());
        System.out.println("Making a new node with the data 9 and setting the original node's right child to now be the 9 node and setting 9's parent to be the original node...");
        AVLNode newRight = new AVLNode(9);
        node.setRight(newRight);
        newRight.setParent(node);
        System.out.println("node.getRight(): " + node.getRight());
        System.out.println("node.getRight().getParent(): " + node.getRight().getParent());
        System.out.println("Done testing AVLNode class.");
    }
    
    public static void main(String[] args){
        tester();
    }
}
