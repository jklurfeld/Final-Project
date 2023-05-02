public class GeomAVLTree extends AVLTree{
    /* this would be inefficient, but in order to determine what level each node is and what y-coordinate it needs, 
    you could traverse the tree and assign each node a "level" variable 
     * and then when you are assigning points to each node, the y-coordinate would be whatever the lowest y-coordinate is * level,
     * so I think I should have a GeomAVLNode class? and then update their points and levels from this class?
    */

    public void setPoints(AVLNode root, int level){
        if (root == null){
            return;
        }
        if (root == getRoot()){
            root.p.x = 250;
            root.p.y = 50;
        }
        if (root.getLeft() != null){
            // this next line of code is going to make it go off the screen
            root.getLeft().p.x = root.p.x - 250/level;
            root.getLeft().p.y = root.p.y + 100;
            setPoints(root.getLeft(), level+1);
        }
        if (root.getRight() != null){
            root.getRight().p.x = root.p.x + 250/level;
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
