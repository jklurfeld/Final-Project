// QUESTION: does using an ArrayList for the BinSearchTree class count as a use of a java built in data structure?

public class AVLTree extends BinSearchTree{
    // have to have this new variable because if I just try to use the old one, then Java can't guarantee that it will have fields like
    // height and balance factor or have children that are also AVLNodes
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
    // extending at all, but the problem is I said I would in my proposal
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

    // returns true if all of the balance factors are 0, 1, or -1, returns false otherwise
    // public boolean updateBalanceFactorsR(AVLNode current){
    //     if (current == null){
    //         return true;
    //     }
    //     current.calculateBalance();
    //     if (current.getBalanceFactor() > 1 || current.getBalanceFactor() < -1){
    //         return false;
    //     }
    //     // maybe it should check if any of the balance factors are not 0, 1, or -1 right here and 
    //     // return true/false so you don't have to traverse the tree again to check all of the balance factors
    //     if (current.getLeft() != null){
    //         updateBalanceFactorsR(current.getLeft());
    //     }
    //     if (current.getRight() != null){
    //         updateBalanceFactorsR(current.getRight());
    //     }
    //     return true;
    // }

    // public void updateBalanceFactors(){
    //     updateBalanceFactorsR(getRoot());
    // }

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
        root.setBalanceFactor(getBalance(root));
        int balance = root.getBalanceFactor();

        // right rotation
        if (balance > 1 && node.getData() < root.getLeft().getData()){
            rightRotate(root);
        }

        // left rotation
        if (balance < -1 && node.getData() > root.getRight().getData()){
            leftRotate(root);
        }

        // left right rotation
        if (balance > 1 && node.getData() > root.getLeft().getData()){
            root.setLeft(leftRotate(root.getLeft()));
            rightRotate(root);
        }

        // right left rotation
        if (balance < -1 && node.getData() > root.getRight().getData()){
            root.setRight(rightRotate(root.getRight()));
            leftRotate(root);
        }
    }

    public void insert(AVLNode node){
        insertR(node, getRoot());
    }

    // updated toString() method so the balance factor of each node is also printed in curly braces
    public String toString(AVLNode root, int level){
        String result = "";
        if (isEmpty()){
            return "This tree is empty.";
        }
        result += "(" + root.getData() + 
        "[" + level + "]" + 
        "{" + root.getBalanceFactor() + "}";
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