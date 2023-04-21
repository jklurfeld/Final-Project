public class BinTreeNode{
    private int data;
    private BinTreeNode left;
    private BinTreeNode right;

    public BinTreeNode(int data){
        this.data = data;
    }

    public int getData(){
        return data;
    }

    public void setData(int s){
        data = s;
    }

    public BinTreeNode getLeft(){
        return left;
    }

    public void setLeft(BinTreeNode n){
        left = n;
    }

    public BinTreeNode getRight(){
        return right;
    }

    public void setRight(BinTreeNode n){
        right = n;
    }

    public String toString(){
        return "" + data;
    }
}