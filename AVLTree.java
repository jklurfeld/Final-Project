public class AVLTree extends BinSearchTree{
    AVLNode root;

    public AVLNode getRoot(){
        return root;
    }

    public void updateBalanceFactorsR(AVLNode current){
        if (current == null){
            return;
        }
        current.calculateBalance();
        // maybe it should check if any of the balance factors are not 0, 1, or -1 right here and 
        // return true/false so you don't have to traverse the tree again to check all of the balance factors
        if (current.getLeft() != null){
            updateBalanceFactorsR(current.getLeft());
        }
        if (current.getRight() != null){
            updateBalanceFactorsR(current.getRight());
        }
    }

    public void updateBalanceFactors(){
        updateBalanceFactorsR(getRoot());
    }

    public void insert(AVLNode node){
        super.insert(node);
        updateBalanceFactors();

    }
}