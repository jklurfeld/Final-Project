public class GeomAVLTree extends AVLTree{
    /* this would be inefficient, but in order to determine what level each node is and what y-coordinate it needs, you could traverse the tree and assign each node a "level" variable 
     * and then when you are assigning points to each node, the y-coordinate would be whatever the lowest y-coordinate is * level,
     * so I think I should have a GeomAVLNode class? and then update their points and levels from this class?
    */
}
