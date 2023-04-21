public class AVLNode extends BinTreeNode{
    int balanceFactor;
    private AVLNode left;
    private AVLNode right;

    public AVLNode(int data){
        super(data);
        balanceFactor = 0;
    }

    public AVLNode getLeft(){
        return left;
    }

    public void setLeft(AVLNode n){
        left = n;
    }

    public AVLNode getRight(){
        return right;
    }

    public void setRight(AVLNode n){
        right = n;
    }

    public int getBalanceFactor(){
        return balanceFactor;
    }

    public void setBalanceFactor(int newFactor){
        balanceFactor = newFactor;
    }

    // this isn't going to work properly because it's only going all the way down the right side instead of 
    // finding the longest path-- you have to do it recursively
    public int leftTreeHeight(){
        int height = 0;
        while (this.getLeft() != null){
            height++;
        }
        return height;
    }

    public int rightTreeHeight(){
        int height = 0;
        while (this.getRight() != null){
            height++;
        }
        return height;
    }

    public void calculateBalance(){
        int leftHeight = leftTreeHeight();
        int rightHeight = rightTreeHeight();

        balanceFactor = leftHeight-rightHeight;
    }
}
