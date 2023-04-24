// QUESTION: does using an ArrayList for the BinSearchTree class count as a use of a java built in data structure?
// because I didn't write that code for this assignment specifically, it was just already there and I am using it as an extension

public class AVLTree extends BinSearchTree{
    // have to have this new variable because if I just try to use the old one, then Java can't guarantee that it will have fields like
    // height and have children that are also AVLNodes
    AVLNode AVLroot;

    public AVLNode getRoot(){
        return AVLroot;
    }

    public void setRoot(AVLNode newRoot){
        AVLroot = newRoot;
    }

    public boolean isEmpty(){
        if (AVLroot == null){
            return true;
        }
        return false;
    }

    // I think my code isn't working without these because my left and rights of each node are different variables than in the original class
    // because they have to be AVLNodes. It seems like the only thing I'm extending is the field for data, which makes me think I shouldn't be 
    // extending at all
    public void addLeft(int data, AVLNode parent){
        parent.setLeft(new AVLNode(data));
    }

    public void addLeft(AVLNode child, AVLNode parent){
        parent.setLeft(child);
    }

    public void addRight(int data, AVLNode parent){
        parent.setRight(new AVLNode(data));
    }

    public void addRight(AVLNode child, AVLNode parent){
        parent.setRight(child);
    }

    public int max(int a, int b){
        if (a > b){
            return a;
        }
        return b;
    }

    // is this function necesssary? maybe yes for saying if the node is null then return 0
    public int height(AVLNode node){
        if (node == null){
            return 0;
        }
        return node.getHeight();
    }

    public int getBalance(AVLNode node){
        if (node == null){
            return 0;
        }
        return height(node.getLeft()) - height(node.getRight());
    }

    // TODO: fix this function so it actually works
    public AVLNode rightRotate(AVLNode node){
        AVLNode x = node.getLeft();
        if (node.equals(AVLroot)){
            setRoot(x);
        }
        AVLNode T2 = x.getRight();
        x.setRight(node);
        node.setLeft(T2);

        node.setHeight(max(height(node.getLeft()), height(node.getRight())) + 1);
        x.setHeight(max(height(x.getLeft()), height(x.getRight())) + 1);
        return x;
    }

    // TODO: fix this function
    public AVLNode leftRotate(AVLNode x) {
        AVLNode y = x.getRight();
        if (x.equals(AVLroot)){
            setRoot(y);
        }
        AVLNode T2 = y.getLeft();
        y.setLeft(x);
        x.setRight(T2);
        x.setHeight(max(height(x.getLeft()), height(x.getRight())) + 1);
        y.setHeight(max(height(y.getLeft()), height(y.getRight())) + 1);
        return y;
    }

    public void insertR(AVLNode node, AVLNode root){
        if (root == null){
            setRoot(node);
            return;
        }
        if (node.getData() > root.getData()){
            if (root.getRight() == null){
                addRight(node, root);
            }
            else {
                insertR(node, root.getRight());
            }
        }
        if (node.getData() <= root.getData()){
            if (root.getLeft() == null){
                addLeft(node, root);
            }
            else {
                insertR(node, root.getLeft()); 
            }
        }
        root.setHeight(1 + max(height(root.getLeft()), height(root.getRight())));
        int balance = getBalance(root);

        // right rotation
        // maybe you could change the numbers it looks for for balance so it looks at the node that is one node up and then rotates?
        if (balance > 1 && node.getData() < root.getLeft().getData()){
            System.out.println("performing right rotation...");
            rightRotate(root);
        }

        // left rotation
        else if (balance < -1 && node.getData() > root.getRight().getData()){
            System.out.println("performing left rotation...");
            leftRotate(root);
        }

        // traverse tree and find what's pointing to the old head and change it so it's pointing to the new head

        // left right rotation
        else if (balance > 1 && node.getData() > root.getLeft().getData()){
            System.out.println("performing left right rotation...");
            root.setLeft(leftRotate(root.getLeft()));
            rightRotate(root);
        }

        // right left rotation
        else if (balance < -1 && node.getData() > root.getRight().getData()){
            System.out.println("performing right left rotation...");
            root.setRight(rightRotate(root.getRight()));
            leftRotate(root);
        }
    }

    public void insert(AVLNode node){
        insertR(node, getRoot());
    }

    // updated toString() method so the balance factor of each node is also printed in curly braces 
    // and the height is between two ! because I ran out of types of brackets
    public String toString(AVLNode root, int level){
        String result = "";
        if (isEmpty()){
            return "This tree is empty.";
        }
        result += "(" + root.getData() + "[" + level + "]" 
        + "{" + getBalance(root) + "}" 
        + "!" + root.getHeight() + "!";
        if (root.getLeft() != null){
            result += toString(root.getLeft(), level+1) + "";
        }
        else {
            result += "_ ";
        }
        if (root.getRight() != null){
            result += toString(root.getRight(), level+1) + "";
        }
        else{
            result += "_ ";
        }
        return result + ")";
    }

    public String toString(){
        return toString(AVLroot, 0);
    }
}