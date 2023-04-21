public class BinTree {
    private BinTreeNode root;

    public BinTree(){
        root = null;
    }

    public BinTree(BinTreeNode root){
        this.root = root;
    }

    public boolean isEmpty(){
        if (root == null){
            return true;
        }
        return false;
    }

    public BinTreeNode getRoot(){
        return root;
    }

    public void setRoot(BinTreeNode newRoot){
        root = newRoot;
    }

    public BinTreeNode goLeft(BinTreeNode current){
        if (current.getLeft() == null){
            System.out.println("There is no left child.");
            return current;
        }
        return current.getLeft();
    }

    public BinTreeNode goRight(BinTreeNode current){
        if (current.getRight() == null){
            System.out.println("There is no right child.");
            return current;
        }
        return current.getRight();
    }

    public void addLeft(int data, BinTreeNode parent){
        parent.setLeft(new BinTreeNode(data));
    }

    public void addLeft(BinTreeNode child, BinTreeNode parent){
        parent.setLeft(child);
    }

    public void addRight(int data, BinTreeNode parent){
        parent.setRight(new BinTreeNode(data));
    }

    public void addRight(BinTreeNode child, BinTreeNode parent){
        parent.setRight(child);
    }

    public String toString(BinTreeNode root, int level){
        String result = "";
        if (isEmpty()){
            return "This tree is empty.";
        }
        result += "(" + root.getData() + "[" + level + "]";
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
        return toString(root, 0);
    }
}
