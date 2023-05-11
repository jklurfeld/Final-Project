public class AVLTree extends BinSearchTree{
    AVLNode AVLroot;

    // TODO: write testers for all these getters, setters, and helper methods
    public AVLNode getRoot(){
        return AVLroot;
    }

    public void setRoot(AVLNode newRoot){
        AVLroot = newRoot;
        AVLroot.setParent(null);
    }

    public boolean isEmpty(){
        if (AVLroot == null){
            return true;
        }
        return false;
    }

    // addLeft() and addRight() are helper functions for insertR()
    public void addLeft(AVLNode child, AVLNode parent){
        parent.setLeft(child);
        child.setParent(parent);
    }

    public void addRight(AVLNode child, AVLNode parent){
        parent.setRight(child);
        child.setParent(parent);
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
        node.setParent(x);
        node.setLeft(T2);
        if (T2 != null){
            T2.setParent(node);
        }
        // T2.setParent(node);

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
            y.setParent(p);
            y.setRight(x);
            x.setParent(y);
            x.setLeft(b);
            if (b != null){
                b.setParent(x);
            }
            p.setHeight(max(height(p.getLeft()), height(p.getRight())) + 1);
            x.setHeight(max(height(x.getLeft()), height(x.getRight())) + 1);
            y.setHeight(max(height(y.getLeft()), height(y.getRight())) + 1);
        }
        else {
            AVLNode x = p.getRight();
            AVLNode y = x.getLeft();
            AVLNode b = y.getRight();
            p.setRight(y);
            y.setParent(p);
            y.setRight(x);
            x.setParent(y);
            x.setLeft(b);
            if (b != null){
                b.setParent(x);
            }
            p.setHeight(max(height(p.getLeft()), height(p.getRight())) + 1);
            x.setHeight(max(height(x.getLeft()), height(x.getRight())) + 1);
            y.setHeight(max(height(y.getLeft()), height(y.getRight())) + 1);
        }
    }

    public void rightRotate(AVLNode p, AVLNode child){
        if (p.getLeft() == child){
            AVLNode x = p.getLeft();
            AVLNode y = x.getLeft();
            AVLNode b = y.getRight();
            p.setLeft(y);
            y.setParent(p);
            y.setRight(x);
            x.setParent(y);
            x.setLeft(b);
            if (b != null){
                b.setParent(x);
            }
            p.setHeight(max(height(p.getLeft()), height(p.getRight())) + 1);
            x.setHeight(max(height(x.getLeft()), height(x.getRight())) + 1);
            y.setHeight(max(height(y.getLeft()), height(y.getRight())) + 1);
        }
        else {
            AVLNode x = p.getRight();
            AVLNode y = x.getLeft();
            AVLNode b = y.getRight();
            p.setRight(y);
            y.setParent(p);
            y.setRight(x);
            x.setParent(y);
            x.setLeft(b);
            if (b != null){
                b.setParent(x);
            }
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
        x.setParent(y);
        x.setRight(T2);
        if (T2 != null){
            T2.setParent(x);
        }
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
            y.setParent(p);
            y.setLeft(x);
            x.setParent(y);
            x.setRight(b);
            if (b != null){
                b.setParent(x);
            }
            p.setHeight(max(height(p.getLeft()), height(p.getRight())) + 1);
            x.setHeight(max(height(x.getLeft()), height(x.getRight())) + 1);
            y.setHeight(max(height(y.getLeft()), height(y.getRight())) + 1);
        }
        else {
            AVLNode x = p.getRight();
            AVLNode y = x.getRight();
            AVLNode b = y.getLeft();
            p.setRight(y);
            y.setParent(p);
            y.setLeft(x);
            x.setParent(y);
            x.setRight(b);
            if (b != null){
                b.setParent(x);
            }
            p.setHeight(max(height(p.getLeft()), height(p.getRight())) + 1);
            x.setHeight(max(height(x.getLeft()), height(x.getRight())) + 1);
            y.setHeight(max(height(y.getLeft()), height(y.getRight())) + 1);
        }
    }

    public void leftRotate(AVLNode p, AVLNode child){
        if (p.getLeft() == child){
            AVLNode x = p.getLeft();
            AVLNode y = x.getRight();
            AVLNode b = y.getLeft();
            p.setLeft(y);
            y.setParent(p);
            y.setLeft(x);
            x.setParent(y);
            x.setRight(b);
            if (b != null){
                b.setParent(x);
            }
            p.setHeight(max(height(p.getLeft()), height(p.getRight())) + 1);
            x.setHeight(max(height(x.getLeft()), height(x.getRight())) + 1);
            y.setHeight(max(height(y.getLeft()), height(y.getRight())) + 1);
        }
        else {
            AVLNode x = p.getRight();
            AVLNode y = x.getRight();
            AVLNode b = y.getLeft();
            p.setRight(y);
            y.setParent(p);
            y.setLeft(x);
            x.setParent(y);
            x.setRight(b);
            if (b != null){
                b.setParent(x);
            }
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
        y.setParent(p);
        y.setLeft(x);
        x.setParent(y);
        x.setRight(b);
        if (b != null){
            b.setParent(x);
        }
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
        y.setParent(p);
        y.setRight(x);
        x.setParent(y);
        x.setLeft(b);
        if (b != null){
            b.setParent(x);
        }
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
        if (node.getData() < root.getData()){
            if (root.getLeft() == null){
                addLeft(node, root);
            }
            else {
                insertR(node, root.getLeft()); 
            }
        }

        root.setHeight(1 + max(height(root.getLeft()), height(root.getRight())));
        performRotations(root, node);
    }

    // wrapper for insertR()
    public void insert(AVLNode node){
        // doesn't support the insertion of two nodes with the same data
        if (search(AVLroot, node.getData())){
            System.out.println("There is a node with this data already in the tree.");
            return;
        }

        insertR(node, getRoot());
    }

    // for use in deletions
    public void performRotations(AVLNode root){
        if (root == AVLroot){
            int rootBalance = getBalance(AVLroot);
            if (rootBalance > 1){
                if (getBalance(root.getLeft())>= 0){
                    // root right rotation
                    rootRightRotate(AVLroot);
                }
                else {
                    // root left right rotation
                    AVLroot.setLeft(rootLeftRotate(AVLroot.getLeft()));
                    rootRightRotate(AVLroot);
                }
            }
            else if (rootBalance < -1){
                if (getBalance(root.getRight()) <= 0){
                    // root left rotation
                    rootLeftRotate(AVLroot);
                }
                else {
                    // root right left rotation
                    AVLroot.setRight(rootRightRotate(AVLroot.getRight()));
                    rootLeftRotate(AVLroot);
                }
            }
        }
        if (getBalance(root) < -1){
            if (getBalance(root.getRight()) <= 0){
                // left rotation
                leftRotate(root.getParent(), root);
            }
            else {
                // right left rotation
                root.setRight(rightLeftRotate(root));
                leftRotate(root.getParent(), root);
            }
        }
        if (getBalance(root) > 1){
            if (getBalance(root.getRight()) >= 0){
                // right rotation
                rightRotate(root.getParent(), root);
            }
            else {
                // left right rotation
                root.setLeft(leftRightRotate(root));
                rightRotate(root.getParent(), root);
            }
        }
    }

    // for use in insertions
    // this perform rotations method also takes in the parameter newNode because it determines where to do rotations based on
    // where newNode was inserted
    public void performRotations(AVLNode root, AVLNode newNode){
        if (root == AVLroot){
            int rootBalance = getBalance(AVLroot);
            if (rootBalance > 1){
                if (newNode.getData() < root.getLeft().getData()){
                    // root right rotation
                    rootRightRotate(AVLroot);
                }
                else {
                    // root left right rotation
                    leftRotate(true, AVLroot);
                    rootRightRotate(AVLroot);
                }
            }
            else if (rootBalance < -1){
                if (newNode.getData() > root.getRight().getData()){
                    // root left rotation
                    rootLeftRotate(AVLroot);
                }
                else {
                    // root right left rotation
                    rightRotate(false, AVLroot);
                    rootLeftRotate(AVLroot);
                }
            }
        }
        if (getBalance(root) < -1){
            if (newNode.getData() > root.getRight().getData()){
                // left rotation
                leftRotate(root.getParent(), root);
            }
            else {
                // right left rotation
                root.setRight(rightLeftRotate(root));
                leftRotate(root.getParent(), root);
            }
        }
        if (getBalance(root) > 1){
            if (newNode.getData() < root.getLeft().getData()){
                // right rotation
                rightRotate(root.getParent(), root);
            }
            else {
                // left right rotation
                root.setLeft(leftRightRotate(root));
                rightRotate(root.getParent(), root);
            }
        }
    }

    // recursive delete function
    public void deleteR(AVLNode root, int data){
        if (root.getLeft() != null && root.getLeft().getData() == data){
            AVLNode nodeToBeDeleted = root.getLeft();
            if (nodeToBeDeleted.getRight() == null && nodeToBeDeleted.getLeft() == null){
                root.setLeft(null);
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
                nodeToBeDeleted.setData(newRoot.getData());
                deleteR(nodeToBeDeleted, newRoot.getData());
            }
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
                AVLNode newRoot = findMin(nodeToBeDeleted.getRight());
                nodeToBeDeleted.setData(newRoot.getData());
                deleteR(nodeToBeDeleted, newRoot.getData());
            }
        }
        else if (data < root.getData()){
            deleteR(root.getLeft(), data);
        }
        else if (data > root.getData()){
            deleteR(root.getRight(), data);
        }

        // this case happens when you "deleted" a node by replacing it's data with the minimum from its right subtree,
        // and now you're going back through that right subtree to really delete the node that you took the data from
        else if (data == root.getData()){
            deleteR(root.getRight(), data);
        }

        // check the balances and perform rotations
        performRotations(root);
    }

    // wrapper for deleteR()
    public void delete(int data){
        // search the tree and if the data that you want to be deleted is not in the tree, then return
        if (!search(AVLroot, data)){
            System.out.println("The data inputted is not in this tree.");
            return;
        }

        // cases for deleting the root
        if (AVLroot.getData() == data){
            if (AVLroot.getLeft() == null && AVLroot.getRight() == null){
                AVLroot = null;
                return;
            }
            else if (AVLroot.getLeft() == null && AVLroot.getRight() != null){
                // if the root only has one child, then that child will not have any children because then the tree wouldn't be balanced
                AVLroot = AVLroot.getRight();
                AVLroot.setHeight(max(height(AVLroot.getLeft()), height(AVLroot.getRight())) + 1);
            }
            else if (AVLroot.getLeft() != null && AVLroot.getRight() == null){
                AVLroot = AVLroot.getLeft();
                AVLroot.setHeight(max(height(AVLroot.getLeft()), height(AVLroot.getRight())) + 1);
            }
            else {      
                AVLNode newRoot = findMin(AVLroot.getRight());
                AVLroot.setData(newRoot.getData());
                AVLroot.setHeight(max(height(AVLroot.getLeft()), height(AVLroot.getRight())) + 1);
                deleteR(AVLroot, newRoot.getData());
            }
            performRotations(AVLroot);
            return;
        }
        deleteR(getRoot(), data); 
    }

    // helper function for when you need to delete a node that has two children, because you want to replace the node to be deleted's
    // data with the minimum from the right subtree
    public AVLNode findMin(AVLNode root){
        AVLNode min = root;
        while (min.getLeft() != null){
            min = min.getLeft();
            // System.out.println("new min: " + min);
        }
        return min;
    }

    // helper method for insert and delete so if the node isn't in the tree, delete will still work
    // and if there is a node with the data you're trying to insert already in the tree, you will get
    // an error message
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