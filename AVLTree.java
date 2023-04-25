import java.util.ArrayList;

public class AVLTree extends BinSearchTree{
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
        // System.out.println("current tree: " + this.toString());
        // int balance = getBalance(root);
        // System.out.println("current root node: " + root.getData());

        // // right rotation
        // if (balance > 1 && node.getData() < root.getLeft().getData()){
        //     System.out.println("performing right rotation...");
        //     rightRotate(root);
        // }

        // // left rotation
        // else if (balance < -1 && node.getData() > root.getRight().getData()){
        //     System.out.println("performing left rotation...");
        //     leftRotate(root);
        // }

        // // left right rotation
        // else if (balance > 1 && node.getData() > root.getLeft().getData()){
        //     System.out.println("performing left right rotation...");
        //     root.setLeft(leftRotate(root.getLeft()));
        //     rightRotate(root);
        // }

        // // right left rotation
        // else if (balance < -1 && node.getData() > root.getRight().getData()){
        //     System.out.println("performing right left rotation...");
        //     root.setRight(rightRotate(root.getRight()));
        //     leftRotate(root);
        // }
    }

    public void insert(AVLNode node){
        // insert the new node
        insertR(node, getRoot());
        System.out.println("Tree after insertion but before rotations: " + this.toString());

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
                leftRotate(AVLroot);
            }
        }

        // check the balances and perform rotations
        performRotations(AVLroot);
    }

    public void performRotations(AVLNode root){
        if (root.getRight() != null){
            if (getBalance(root.getRight()) < -1){
                if (root.getRight().getRight() != null){
                    System.out.println("Performing left rotation...");
                    leftRotate(root);
                }
                else {
                    System.out.println("Performing right left rotation...");
                    rootRightRotate(root.getRight());
                    leftRotate(root);
                }
                // check if it's a left or a right left rotation
                // leftRotate(root);
            }
            performRotations(root.getRight());
        }
        if (root.getLeft() != null){
            if (getBalance(root.getLeft()) > 1){
                if (root.getLeft().getLeft() != null){
                    System.out.println("Performing right rotation...");
                    rightRotate(root);
                }
                else {
                    System.out.println("Performing left right rotation...");
                    rootLeftRotate(root.getLeft());
                    rightRotate(root);
                }
            }
            performRotations(root.getLeft());
        }
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