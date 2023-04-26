public class AVLTree extends BinSearchTree{
    AVLNode AVLroot;

    // TODO: write testers for all these getters, setters, and helper methods
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

    // I thought I only needed these functions for testing and then I didn't use them for testing, but for some reason my tester code is breaking without them
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

    public AVLNode rootRightRotate(AVLNode node){
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

    public void rightRotate(AVLNode p){
        AVLNode x = p.getLeft();
        AVLNode y = x.getLeft();
        AVLNode b = y.getRight();
        p.setLeft(y);
        y.setRight(x);
        x.setLeft(b);
        p.setHeight(max(height(p.getLeft()), height(p.getRight())) + 1);
        x.setHeight(max(height(x.getLeft()), height(x.getRight())) + 1);
        y.setHeight(max(height(y.getLeft()), height(y.getRight())) + 1);
    }

    public AVLNode rootLeftRotate(AVLNode x) {
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

    public void leftRotate(AVLNode p){
        AVLNode x = p.getRight();
        AVLNode y = x.getRight();
        AVLNode b = y.getLeft();
        p.setRight(y);
        y.setLeft(x);
        x.setRight(b);
        p.setHeight(max(height(p.getLeft()), height(p.getRight())) + 1);
        x.setHeight(max(height(x.getLeft()), height(x.getRight())) + 1);
        y.setHeight(max(height(y.getLeft()), height(y.getRight())) + 1);
    }

    public AVLNode leftRightRotate(AVLNode p){
        AVLNode x = p.getLeft();
        AVLNode y = x.getRight();
        AVLNode b = y.getLeft();
        p.setLeft(y);
        y.setLeft(x);
        x.setRight(b);
        p.setHeight(max(height(p.getLeft()), height(p.getRight())) + 1);
        x.setHeight(max(height(x.getLeft()), height(x.getRight())) + 1);
        y.setHeight(max(height(y.getLeft()), height(y.getRight())) + 1);
        return y;
    }

    public AVLNode rightLeftRotate(AVLNode p){
        AVLNode x = p.getRight();
        AVLNode y = x.getLeft();
        AVLNode b = y.getRight();
        p.setRight(y);
        y.setRight(x);
        x.setLeft(b);
        p.setHeight(max(height(p.getLeft()), height(p.getRight())) + 1);
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

        // start at the root of the tree again and then start going down and checking if your children are balanced

        root.setHeight(1 + max(height(root.getLeft()), height(root.getRight())));
    }

    public void insert(AVLNode node){
        // insert the new node
        insertR(node, getRoot());
        System.out.println("Tree after insertion but before rotations: " + this.toString());

        // maybe you should put all of these in the perform rotations function so you can use it after you delete a node?
        int rootBalance = getBalance(AVLroot);
        if (rootBalance > 1){
            if (AVLroot.getLeft().getLeft() != null){
                System.out.println("Performing root right rotation...");
                rootRightRotate(AVLroot);
            }
            else {
                // left right rotation
                System.out.println("Performing root left right rotation...");
                AVLroot.setLeft(rootLeftRotate(AVLroot.getLeft()));
                rootRightRotate(AVLroot);
            }
        }
        else if (rootBalance < -1){
            if (AVLroot.getRight().getRight() != null){
                System.out.println("Performing root left rotation...");
                rootLeftRotate(AVLroot);
            }
            else {
                System.out.println("Performing root right left rotation...");
                AVLroot.setRight(rootRightRotate(AVLroot.getRight()));
                rootLeftRotate(AVLroot);
            }
        }

        // check the balances and perform rotations
        performRotations(AVLroot);
    }

    public void performRotations(AVLNode root){
        if (root.getRight() != null){
            if (getBalance(root.getRight()) < -1){
                if (root.getRight().getRight().getRight() != null){
                    System.out.println("Performing left rotation...");
                    leftRotate(root);
                }
                else {
                    System.out.println("Performing right left rotation...");
                    root.getRight().setRight(rightLeftRotate(root.getRight()));
                    leftRotate(root);
                }
                // check if it's a left or a right left rotation
                // leftRotate(root);
            }
            performRotations(root.getRight());
        }
        if (root.getLeft() != null){
            if (getBalance(root.getLeft()) > 1){
                if (root.getLeft().getLeft().getLeft() != null){
                    System.out.println("Performing right rotation...");
                    rightRotate(root);
                }
                else {
                    System.out.println("Performing left right rotation...");
                    root.getLeft().setLeft(leftRightRotate(root.getLeft()));
                    rightRotate(root);
                }
            }
            performRotations(root.getLeft());
        }
    }

    public void deleteR(AVLNode root, int data){
        // AVLNode toBeDeleted = search(data);
        // if (toBeDeleted == null){
        //     return;
        // }
        if (root.getData() == data){
            
        }
        else if (root.getLeft().getData() == data){

        }
        else if (root.getRight().getData() == data){

        }
        else if (data < root.getData()){
            deleteR(root.getLeft(), data);
        }
        else if (data > root.getData()){
            deleteR(root.getRight(), data);
        }
    }

    public void delete(int data){
        deleteR(getRoot(), data); 
    }

    // you have to return parent of the node to be deleted for the same reason as insertion
    // maybe you could make checks in the delete function itself if the node to be deleted is the root instead of doing it within the search function
    // if you return a node, then you have to do another check in the delete function if the node you really want to delete is the right or left child
    public AVLNode searchR(int data, AVLNode root){
        if (root == null){
            return null;
        }
        // what do you do if you want to delete the root node?
        if (root.getData() == data){
            return root;
        }
        else if (root.getData() < data){
            return searchR(data, root.getRight());
        }
        else {
            return searchR(data, root.getLeft());
        }
    }

    public AVLNode search(int data){
        return searchR(data, AVLroot);
    }

    // updated toString() method so the balance factor of each node is also printed in curly braces 
    // and the height is between two []
    public String toString(AVLNode root){
        String result = "";
        if (isEmpty()){
            return "This tree is empty.";
        }
        result += "(" + root.getData() + "{" + getBalance(root) + "}" + "[" + root.getHeight() + "]";
        if (root.getLeft() != null){
            result += toString(root.getLeft()) + "";
        }
        else {
            result += "_ ";
        }
        if (root.getRight() != null){
            result += toString(root.getRight()) + "";
        }
        else{
            result += "_ ";
        }
        return result + ")";
    }

    public String toString(){
        return toString(AVLroot);
    }
}