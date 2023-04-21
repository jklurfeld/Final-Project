public class AVLNode extends BinTreeNode{
    int balanceFactor;

    public AVLNode(int data){
        super(data);
        balanceFactor = 0;
    }

    public int getBalanceFactor(){
        return balanceFactor;
    }

    public void setBalanceFactor(int newFactor){
        balanceFactor = newFactor;
    }

    
}
