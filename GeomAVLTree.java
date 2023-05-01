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
            root.p.x = 100;
            root.p.y = 100;
        }
        if (root.getLeft() != null){
            root.getLeft().p.x = 
            root.getLeft().p.y = 100 * (level+1);
            setPoints(root.getLeft(), level+1);
        }
        if (root.getRight() != null){
            root.getRight().p.x = 
            root.getRight().p.y = 100 * (level+1);
            setPoints(root.getRight(), level+1);
        }
    }
}
