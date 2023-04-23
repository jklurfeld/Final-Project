public class AVLNode extends BinTreeNode{
    // you can do class inheritance for the graphics and making the "geometric" classes so you don't need to do it for this class!!! but you did write that you were going to do it in your proposal
    private int height;
    // private int balanceFactor;
    private AVLNode left;
    private AVLNode right;

    public AVLNode(int data){
        super(data);
        // balanceFactor = 0;
        height = 1;
    }

    public int getHeight(){
        return height;
    }

    public void setHeight(int height){
        this.height = height;
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

    // public int getBalanceFactor(){
    //     return balanceFactor;
    // }

    // public void setBalanceFactor(int newFactor){
    //     balanceFactor = newFactor;
    // }

    // this isn't going to work properly because it's only going all the way down the right side instead of 
    // finding the longest path-- you have to do it recursively
    // public int leftTreeHeight(){
    //     int height = 0;
    //     while (this.getLeft() != null){
    //         height++;
    //     }
    //     return height;
    // }

    // public int rightTreeHeight(){
    //     int height = 0;
    //     while (this.getRight() != null){
    //         height++;
    //     }
    //     return height;
    // }

    // public int calculateHeightR(int height, AVLNode node){
    //     if (node == null){
    //         return height;
    //     }
    //     if (getRight() != null){
    //         return calculateHeightR(height+1, node);
    //     }
    //     if (getLeft() != null){
    //         return calculateHeightR(height+1, node);
    //     }
    //     return height;
    // }

    // should this be a static method b/c I'm not really calling it on the object?
    // not working bc same old problem of making a new height variable each time
    // this function needs to start at the root and stop counting once it gets to the node it's at?
    // public int calculateHeightR(int height, AVLNode node){
    //     System.out.println("height: " + height);
    //     // int height = 0;
    //     if (node == null){
    //         return height;
    //     }
    //     if (node.getLeft() != null){
    //         System.out.println("Inside first if statement");
    //         // height++;
    //         calculateHeightR(height+1, node.getLeft());
    //     }
    //     if (node.getRight() != null){
    //         System.out.println("Inside second if statement");
    //         // height++;
    //         calculateHeightR(height+1, node.getRight());
    //     }
    //     return height;
    // }

    // public int calculateHeight(AVLNode node){
    //     return calculateHeightR(0, node);
    // }

    // // public int calculateHeight(AVLNode node){
    // //     return calculateHeightR(0, node);
    // // }

    // public void calculateBalance(){
    //     int leftHeight = calculateHeight(left);
    //     int rightHeight = calculateHeight(right);

    //     balanceFactor = leftHeight-rightHeight;
    // }
}
