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

    // if the boolean "left" is true then you want to do a rotation on the left subtree, else rotate on the right subtree
    public void rightRotate(boolean left, AVLNode p){
        if (left){
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
        else {
            AVLNode x = p.getRight();
            AVLNode y = x.getLeft();
            AVLNode b = y.getRight();
            p.setRight(y);
            y.setRight(x);
            x.setLeft(b);
            p.setHeight(max(height(p.getLeft()), height(p.getRight())) + 1);
            x.setHeight(max(height(x.getLeft()), height(x.getRight())) + 1);
            y.setHeight(max(height(y.getLeft()), height(y.getRight())) + 1);
        }
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

    // if the boolean "left" is true then you want to do a rotation on the left subtree, else rotate on the right subtree
    public void leftRotate(boolean left, AVLNode p){
        if (left){
            AVLNode x = p.getLeft();
            AVLNode y = x.getRight();
            AVLNode b = y.getLeft();
            p.setLeft(y);
            y.setLeft(x);
            x.setRight(b);
            p.setHeight(max(height(p.getLeft()), height(p.getRight())) + 1);
            x.setHeight(max(height(x.getLeft()), height(x.getRight())) + 1);
            y.setHeight(max(height(y.getLeft()), height(y.getRight())) + 1);
        }
        else {
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

    // TODO: stop supporting inserting two nodes with the same data?
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
        // System.out.println("Tree after insertion but before rotations: " + this.toString());

        // check the balances and perform rotations
        performRotations(AVLroot, node);
    }

    // for use in deletions
    public void performRotations(AVLNode root){
        if (root == AVLroot){
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
        }
        if (root.getRight() != null){
            if (getBalance(root.getRight()) < -1){
                if (getBalance(root.getRight().getRight()) <= 0){
                    System.out.println("Performing left rotation in right subtree...");
                    leftRotate(false, root);
                }
                else {
                    System.out.println("Performing right left rotation in right subtree...");
                    root.getRight().setRight(rightLeftRotate(root.getRight()));
                    leftRotate(false, root);
                }
            }
            if (getBalance(root.getRight()) > 1){
                if (getBalance(root.getRight().getLeft()) >= 0){
                    System.out.println("Performing right rotation in right subtree...");
                    // this isn't working because your "right rotate" function only works for when the rotation needs to be in the left subtree
                    rightRotate(false, root);
                }
                else {
                    System.out.println("Performing left right rotation in right subtree...");
                    root.getRight().setLeft(leftRightRotate(root.getRight()));
                    rightRotate(false, root);
                }
            }
            performRotations(root.getRight());
        }
        if (root.getLeft() != null){
            if (getBalance(root.getLeft()) > 1){
                if (getBalance(root.getLeft().getLeft()) >= 0){
                    System.out.println("Performing right rotation in left subtree...");
                    rightRotate(true, root);
                }
                else {
                    System.out.println("Performing left right rotation in left subtree...");
                    root.getLeft().setLeft(leftRightRotate(root.getLeft()));
                    rightRotate(true, root);
                }
            }
            if (getBalance(root.getLeft()) < -1){
                if (getBalance(root.getLeft().getRight()) <= 0){
                    System.out.println("Performing left rotation in left subtree...");
                    leftRotate(true, root);
                }
                else {
                    System.out.println("Performing right left rotation in left subtree...");
                    root.getLeft().setRight(rightLeftRotate(root.getLeft()));
                    leftRotate(true, root);
                }
            }
            performRotations(root.getLeft());
        }
    }

    // for use in insertions
    public void performRotations(AVLNode root, AVLNode newNode){
        if (root == AVLroot){
            int rootBalance = getBalance(AVLroot);
            if (rootBalance > 1){
                if (newNode.getData() < root.getLeft().getData()){
                    System.out.println("Performing root right rotation...");
                    rootRightRotate(AVLroot);
                }
                else {
                    // left right rotation
                    System.out.println("Performing root left right rotation...");
                    // AVLroot.setLeft(rootLeftRotate(AVLroot.getLeft()));
                    leftRotate(true, AVLroot);
                    rootRightRotate(AVLroot);
                }
            }
            else if (rootBalance < -1){
                if (newNode.getData() > root.getRight().getData()){
                    System.out.println("Performing root left rotation...");
                    rootLeftRotate(AVLroot);
                }
                else {
                    System.out.println("Performing root right left rotation...");
                    // AVLroot.setRight(rootRightRotate(AVLroot.getRight()));
                    rightRotate(false, AVLroot);
                    rootLeftRotate(AVLroot);
                }
            }
        }
        if (root.getRight() != null){
            if (getBalance(root.getRight()) < -1){
                if (newNode.getData() > root.getRight().getRight().getData()){
                    System.out.println("Performing left rotation in right subtree...");
                    leftRotate(false, root);
                }
                else {
                    System.out.println("Performing right left rotation in right subtree...");
                    root.getRight().setRight(rightLeftRotate(root.getRight()));
                    leftRotate(false, root);
                }
            }
            if (getBalance(root.getRight()) > 1){
                if (newNode.getData() < root.getRight().getLeft().getData()){
                    System.out.println("Performing right rotation in right subtree...");
                    // this isn't working because your "right rotate" function only works for when the rotation needs to be in the left subtree
                    rightRotate(false, root);
                }
                else {
                    System.out.println("Performing left right rotation in right subtree...");
                    root.getRight().setLeft(leftRightRotate(root.getRight()));
                    rightRotate(false, root);
                }
            }
            performRotations(root.getRight(), newNode);
        }
        if (root.getLeft() != null){
            if (getBalance(root.getLeft()) > 1){
                if (newNode.getData() < root.getLeft().getLeft().getData()){
                    System.out.println("Performing right rotation in left subtree...");
                    rightRotate(true, root);
                }
                else {
                    System.out.println("Performing left right rotation in left subtree...");
                    root.getLeft().setLeft(leftRightRotate(root.getLeft()));
                    rightRotate(true, root);
                }
            }
            if (getBalance(root.getLeft()) < -1){
                if (newNode.getData() > root.getLeft().getRight().getData()){
                    System.out.println("Performing left rotation in left subtree...");
                    leftRotate(true, root);
                }
                else {
                    System.out.println("Performing right left rotation in left subtree...");
                    root.getLeft().setRight(rightLeftRotate(root.getLeft()));
                    leftRotate(true, root);
                }
            }
            performRotations(root.getLeft(), newNode);
        }
    }

    public void deleteR(AVLNode root, int data){
        // TODO: figure out how to make a case for when the data you're looking for doesn't exist in the tree so your code doesn't throw an exception when this happens?

        if (root.getLeft() != null && root.getLeft().getData() == data){
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
                AVLNode newRoot = findMin(nodeToBeDeleted.getRight());
                boolean bigger;
                if (newRoot.getData() > nodeToBeDeleted.getData()){
                    bigger = true;
                }
                else {
                    bigger = false;
                }
                nodeToBeDeleted.setData(newRoot.getData());
                // deleteR(root.getRight(), newRoot.getData());
                deleteR(nodeToBeDeleted, newRoot.getData(), bigger);
            }
            performRotations(AVLroot);
            return;
        }
        else if (root.getRight() != null && root.getRight().getData() == data){
            // System.out.println("inside root.getRight() == data if statement");
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
                AVLNode newRoot = findMin(nodeToBeDeleted.getRight());
                boolean bigger;
                if (newRoot.getData() > nodeToBeDeleted.getData()){
                    bigger = true;
                }
                else {
                    bigger = false;
                }
                nodeToBeDeleted.setData(newRoot.getData());
                // deleteR(root.getRight(), newRoot.getData());
                // System.out.println("tree before deleting extra copied node: " + this.toString());
                deleteR(nodeToBeDeleted, newRoot.getData(), bigger);
            }
            performRotations(AVLroot);
            // when you return here, you don't get to perform the rotations
            return;
        }
        else if (data < root.getData()){
            deleteR(root.getLeft(), data);
        }
        else if (data > root.getData()){
            deleteR(root.getRight(), data);
        }

        // check the balances and perform rotations
        performRotations(AVLroot);
    }

    // if larger is true, then the new root's data is larger than the old one
    public void deleteR(AVLNode root, int data, boolean larger){
        // TODO: figure out how to make a case for when the data you're looking for doesn't exist in the tree so your code doesn't throw an exception when this happens?

        // TODO: remember to update the heights of the nodes when you manipulate them!
        if (root.getLeft() != null && root.getLeft().getData() == data){
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
                AVLNode newRoot = findMin(nodeToBeDeleted.getRight());
                boolean bigger;
                if (newRoot.getData() > nodeToBeDeleted.getData()){
                    bigger = true;
                }
                else {
                    bigger = false;
                }
                nodeToBeDeleted.setData(newRoot.getData());
                // deleteR(root.getRight(), newRoot.getData());
                deleteR(nodeToBeDeleted, newRoot.getData(), bigger);
            }
            performRotations(AVLroot);
            return;
        }
        else if (root.getRight() != null && root.getRight().getData() == data){
            // System.out.println("inside root.getRight() == data if statement");
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
                AVLNode newRoot = findMin(nodeToBeDeleted.getRight());
                boolean bigger;
                if (newRoot.getData() > nodeToBeDeleted.getData()){
                    bigger = true;
                }
                else {
                    bigger = false;
                }
                nodeToBeDeleted.setData(newRoot.getData());
                // deleteR(root.getRight(), newRoot.getData());
                // System.out.println("tree before deleting extra copied node: " + this.toString());
                deleteR(nodeToBeDeleted, newRoot.getData(), bigger);
            }
            performRotations(AVLroot);
            return;
        }
        else if (!larger){
            deleteR(root.getLeft(), data);
        }
        else if (larger){
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
        if (AVLroot.getData() == data){
            if (AVLroot.getLeft() == null && AVLroot.getRight() == null){
                AVLroot = null;
                return;
            }
            else if (AVLroot.getLeft() == null && AVLroot.getRight() != null){
                // if the root only has one child, then that child will not have any children
                AVLroot = AVLroot.getRight();
                AVLroot.setHeight(max(height(AVLroot.getLeft()), height(AVLroot.getRight())) + 1);
            }
            else if (AVLroot.getLeft() != null && AVLroot.getRight() == null){
                AVLroot = AVLroot.getLeft();
                AVLroot.setHeight(max(height(AVLroot.getLeft()), height(AVLroot.getRight())) + 1);
            }
            else {
                // maybe you should have a function that does the stuff required for when a node to be deleted has two children
                // and then here you'd just call that function and update the root

                // maybe you should just have function for all of these cases?      
                AVLNode newRoot = findMin(AVLroot.getRight());
                boolean bigger;
                if (newRoot.getData() > AVLroot.getData()){
                    bigger = true;
                }
                else {
                    bigger = false;
                }
                // System.out.println("minimum of right subtree: " + newRoot);
                AVLroot.setData(newRoot.getData());
                // System.out.println("IN WRAPPER tree after setting data of root to the min of the right subtree: " + this.toString());
                AVLroot.setHeight(max(height(AVLroot.getLeft()), height(AVLroot.getRight())) + 1);
                deleteR(AVLroot, newRoot.getData(), bigger);
            }
            // AVLroot.setHeight(max(height(AVLroot.getLeft()), height(AVLroot.getRight())) + 1);
            performRotations(AVLroot);
            return;
        }
        deleteR(getRoot(), data); 
    }

    // to find the min you can just keep going to the left until you hit a null, you don't need a whole function
    // double check: I think this is going to work because I don't there are going to be any cases where there could be a subtree that needs to be rotated
    public AVLNode findMin(AVLNode root){
        AVLNode min = root;
        while (min.getLeft() != null){
            min = min.getLeft();
            // System.out.println("new min: " + min);
        }
        return min;
    }

    // helper method for delete so if the node isn't in the tree, delete will still work
    public boolean search(AVLNode root, int data){
        if (root == null){
            return false;
        }
        if (root.getData() == data){
            return true;
        }
        if (root.getData() < data){
            return search(root.getRight(), data);
        }
        else if (root.getData() > data){
            return search(root.getLeft(), data);
        }
        return false;
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