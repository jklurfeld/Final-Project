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
        // TODO: fix this function so it works when the balance is -2 for a left node and 2 when it's a right node
        if (root.getRight() != null){
            if (getBalance(root.getRight()) < -1){
                if (root.getRight().getRight().getRight() != null){
                    System.out.println("Performing left rotation in right subtree...");
                    leftRotate(root);
                }
                else {
                    System.out.println("Performing right left rotation in right subtree...");
                    root.getRight().setRight(rightLeftRotate(root.getRight()));
                    leftRotate(root);
                }
            }
            if (getBalance(root.getRight()) > 1){
                if (root.getRight().getLeft().getLeft() != null){
                    System.out.println("Performing right rotation in right subtree...");
                    // this isn't working because your "right rotate" function only works for when the rotation needs to be in the left subtree
                    rightRotate(root);
                }
                else {
                    System.out.println("Performing left right rotation in right subtree...");
                    root.getLeft().setLeft(leftRightRotate(root.getLeft()));
                    rightRotate(root);
                }
            }
            performRotations(root.getRight());
        }
        if (root.getLeft() != null){
            if (getBalance(root.getLeft()) > 1){
                if (root.getLeft().getLeft().getLeft() != null){
                    System.out.println("Performing right rotation in left subtree...");
                    rightRotate(root);
                }
                else {
                    System.out.println("Performing left right rotation in left subtree...");
                    root.getLeft().setLeft(leftRightRotate(root.getLeft()));
                    rightRotate(root);
                }
            }
            if (getBalance(root.getLeft()) < -1){
                if (root.getLeft().getRight().getRight() != null){
                    System.out.println("Performing left rotation in left subtree...");
                    leftRotate(root);
                }
                else {
                    System.out.println("Performing right left rotation in left subtree...");
                    root.getRight().setRight(rightLeftRotate(root.getRight()));
                    leftRotate(root);
                }
            }
            performRotations(root.getLeft());
        }
    }

    public void deleteR(AVLNode root, int data){
        // TODO: figure out how to make a case for when the data you're looking for doesn't exist in the tree so your code doesn't throw an exception when this happens?

        // TODO: remember to update the heights of the nodes when you manipulate them!

        // myabe this case should be in the wrapper?
        if (root.getData() == data){
            if (root.getLeft() == null && root.getRight() == null){
                AVLroot = null;
            }
            else if (root.getLeft() == null && root.getRight() != null){
                // if the root only has one child, then that child will not have any children
                AVLroot = root.getRight();
            }
            else if (root.getLeft() != null && root.getRight() == null){
                AVLroot = root.getLeft();
            }
            else {
                // maybe you should have a function that does the stuff required for when a node to be deleted has two children
                // and then here you'd just call that function and update the root

                // maybe you should just have function for all of these cases?
                AVLNode newRoot = findMin(root.getRight());
                AVLroot.setData(newRoot.getData());
                deleteR(root.getRight(), newRoot.getData());
            }
            root.setHeight(max(height(root.getLeft()), height(root.getRight())) + 1);
            return;
        }
        else if (root.getLeft() != null && root.getLeft().getData() == data){
            AVLNode nodeToBeDeleted = root.getLeft();
            if (nodeToBeDeleted.getRight() == null && nodeToBeDeleted.getLeft() == null){
                root.setLeft(null);
                // TODO: change this to just say root.setHeight = height(root.getRight()) + 1? and if you change this and it works, change other instances of it too
                root.setHeight(max(height(root.getLeft()), height(root.getRight())) + 1);
            }
            else if (nodeToBeDeleted.getLeft() == null && nodeToBeDeleted.getRight() != null){
                nodeToBeDeleted.setData(nodeToBeDeleted.getRight().getData());
                nodeToBeDeleted.setRight(null);
                nodeToBeDeleted.setHeight(max(height(nodeToBeDeleted.getLeft()), height(nodeToBeDeleted.getRight())) + 1);
            }
            else if (nodeToBeDeleted.getLeft() != null && nodeToBeDeleted.getRight() == null){
                nodeToBeDeleted.setData(nodeToBeDeleted.getLeft().getData());
                nodeToBeDeleted.setLeft(null);
                nodeToBeDeleted.setHeight(max(height(nodeToBeDeleted.getLeft()), height(nodeToBeDeleted.getRight())) + 1);
            }
            else {
                AVLNode newRoot = findMin(root.getRight());
                root.setData(newRoot.getData());
                deleteR(root.getRight(), newRoot.getData());
            }
            return;
        }
        else if (root.getRight() != null && root.getRight().getData() == data){
            AVLNode nodeToBeDeleted = root.getRight();
            if (nodeToBeDeleted.getRight() == null && nodeToBeDeleted.getLeft() == null){
                root.setRight(null);
                root.setHeight(max(height(root.getLeft()), height(root.getRight())) + 1);
            }
            else if (nodeToBeDeleted.getLeft() == null && nodeToBeDeleted.getRight() != null){
                nodeToBeDeleted.setData(nodeToBeDeleted.getRight().getData());
                nodeToBeDeleted.setRight(null);
                nodeToBeDeleted.setHeight(max(height(nodeToBeDeleted.getLeft()), height(nodeToBeDeleted.getRight())) + 1);
            }
            else if (nodeToBeDeleted.getLeft() != null && nodeToBeDeleted.getRight() == null){
                nodeToBeDeleted.setData(nodeToBeDeleted.getLeft().getData());
                nodeToBeDeleted.setLeft(null);
                nodeToBeDeleted.setHeight(max(height(nodeToBeDeleted.getLeft()), height(nodeToBeDeleted.getRight())) + 1);
            }
            else {
                AVLNode newRoot = findMin(root.getRight());
                root.setData(newRoot.getData());
                deleteR(root.getRight(), newRoot.getData());
            }
            return;
        }
        else if (data < root.getData()){
            deleteR(root.getLeft(), data);
        }
        else if (data > root.getData()){
            deleteR(root.getRight(), data);
        }

        // check the balances and perform rotations
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
        performRotations(AVLroot);
    }

    public void delete(int data){
        deleteR(getRoot(), data); 
    }

    // to find the min you can just keep going to the left until you hit a null, you don't need a whole function
    // double check: I think this is going to work because I don't there are going to be any cases where there could be a subtree that needs to be rotated
    public AVLNode findMin(AVLNode root){
        AVLNode min = root;
        while (root.getLeft() != null){
            min = root.getLeft();
        }
        return min;
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