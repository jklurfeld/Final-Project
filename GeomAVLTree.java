public class GeomAVLTree extends AVLTree{

    public void setPoints(AVLNode root, int level){
        if (root == null){
            return;
        }
        if (root == getRoot()){
            root.p.x = 250;
            root.p.y = 50;
        }
        if (root.getLeft() != null){
            // this next line of code is going to make it go off the screen, 
            // maybe you could make it so everything shifts right if something's x coordinate is less than 0
            root.getLeft().p.x = root.p.x - 125/level;
            root.getLeft().p.y = root.p.y + 100;
            setPoints(root.getLeft(), level+1);
        }
        if (root.getRight() != null){
            root.getRight().p.x = root.p.x + 125/level;
            root.getRight().p.y = root.p.y + 100;
            setPoints(root.getRight(), level+1);
        }
    }

    public String toString(AVLNode root){
        String result = "";
        if (isEmpty()){
            return "This tree is empty.";
        }
        result += "(" + root.getData() + "{" + getBalance(root) + "}" + "[" + root.getHeight() + "]" + "{" + root.p.x + ", " + root.p.y + "}";
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
