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

    // helper functions for insertR()
    public void addLeft(AVLNode child, AVLNode parent){
        parent.setLeft(child);
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
    // I did it this way because the node "p" you're passing in as a parameter is really the parent of the unbalanced node,
    // so I thought passing in this boolean as a parameter would be easier than checking the balance factors of the right and
    // left children again
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
    }

    public void insert(AVLNode node){
        // doesn't support the insertion of two nodes with the same data
        if (search(AVLroot, node.getData())){
            System.out.println("There is a node with this data is already in the tree.");
            return;
        }

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
                if (getBalance(root.getLeft())>= 0){
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
                if (getBalance(root.getRight()) <= 0){
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
    // this perform rotations method also takes in the parameter newNode because it determines where to do rotations based on
    // where newNode was inserted
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
            performRotations(AVLroot);
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
                AVLNode newRoot = findMin(nodeToBeDeleted.getRight());
                nodeToBeDeleted.setData(newRoot.getData());
                deleteR(nodeToBeDeleted, newRoot.getData());
                // System.out.println("tree before deleting extra copied node: " + this.toString());
            }
            performRotations(AVLroot);
            return;
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
        performRotations(AVLroot);
    }

    // wrapper for delete
    public void delete(int data){
        // search the tree and if the data that you want to be deleted is not in the tree, then return
        if (!search(AVLroot, data)){
            System.out.println("The data inputted is not in this tree.");
            return;
        }

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
                AVLNode newRoot = findMin(AVLroot.getRight());
                // System.out.println("minimum of right subtree: " + newRoot);
                AVLroot.setData(newRoot.getData());
                AVLroot.setHeight(max(height(AVLroot.getLeft()), height(AVLroot.getRight())) + 1);
                deleteR(AVLroot, newRoot.getData());
            }
            // AVLroot.setHeight(max(height(AVLroot.getLeft()), height(AVLroot.getRight())) + 1);
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