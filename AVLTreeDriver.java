import java.util.Scanner;

public class AVLTreeDriver {
    public static void printOptions(){
        System.out.println("OPTIONS MENU:");
        System.out.println("- insert");
        System.out.println("- delete");
        System.out.println("- sort");
        System.out.println("- print options");
        System.out.println("- print tree");
        System.out.println("- quit");
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        boolean quit = false;

        GeomAVLTree tree = new GeomAVLTree();
        System.out.println("What value do you want at the root? (Enter an integer)");
        tree.setRoot(new AVLNode(input.nextInt()));
        input.nextLine();

        printOptions();

        while (quit == false){
            String option = input.nextLine().toLowerCase();

            switch(option){
                case "insert":
                    System.out.println("insert the data of the new node:");
                    tree.insert(new AVLNode(input.nextInt()));
                    input.nextLine();
                    tree.setPoints(tree.getRoot(), 1);
                    break;
                case "delete":
                    System.out.println("insert the data of the node to be deleted:");
                    tree.delete(input.nextInt());
                    input.nextLine();
                    tree.setPoints(tree.getRoot(), 1);
                    break;
                case "sort":
                    System.out.println("current tree sorted: " + tree.traverseW());
                    break;
                case "print options":
                    printOptions();
                    break;
                case "print tree":
                    System.out.println(tree);
                    break;
                case "quit":
                    quit = true;
                    MyFrame demoFrame = new MyFrame(tree);
                    break;
                default:
                    System.out.println("This is not a known command.");
                    printOptions();
                    break;
            }
        }
        input.close();
    }
}
