public class AVLNode extends BinTreeNode{
    private int height;
    // private int balanceFactor;
    private AVLNode left;
    private AVLNode right;
    Point p;

    public AVLNode(int data){
        super(data);
        // balanceFactor = 0;
        height = 1;
        p = new Point(0, 0);
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

}
