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

    // returns true if all of the balance factors are 0, 1, or -1, returns false otherwise
    public boolean updateBalanceFactorsR(AVLNode current){
        if (current == null){
            return true;
        }
        current.calculateBalance();
        if (current.getBalanceFactor() > 1 || current.getBalanceFactor() < -1){
            return false;
        }
        // maybe it should check if any of the balance factors are not 0, 1, or -1 right here and 
        // return true/false so you don't have to traverse the tree again to check all of the balance factors
        if (current.getLeft() != null){
            updateBalanceFactorsR(current.getLeft());
        }
        if (current.getRight() != null){
            updateBalanceFactorsR(current.getRight());
        }
        return true;
    }

    public void updateBalanceFactors(){
        updateBalanceFactorsR(getRoot());
    }

    public void insert(AVLNode node){
        super.insert(node);
        updateBalanceFactors();

    }

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