import java.util.ArrayList;

public class BinSearchTree extends BinTree {
    public void insert(BinTreeNode node, BinTreeNode root){
        if (isEmpty()){
            setRoot(node);
            return;
        }
        if (node.getData() > root.getData()){
            if (root.getRight() == null){
                addRight(node, root);
            }
            else {
                insert(node, root.getRight());
            }
        }
        if (node.getData() <= root.getData()){
            if (root.getLeft() == null){
                addLeft(node, root);
            }
            else {
                insert(node, root.getLeft()); 
            }
        }
    }

    public void insertW(BinTreeNode node){
        insert(node, getRoot());
    }

    public ArrayList<Integer> traverseW(){
        ArrayList<Integer> list = new ArrayList<>();
        return traversev2(list, getRoot());
    }

    public ArrayList<Integer> traversev2(ArrayList<Integer> list, BinTreeNode current){
        if (current == null){
            return null;
        }
        if (current.getLeft() != null){
            traversev2(list, current.getLeft());
        }
        list.add(current.getData());
        // System.out.println(list);
        if (current.getRight() != null){
            traversev2(list, current.getRight());
        }
        return list;
    }
}
