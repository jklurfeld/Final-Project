import java.awt.*;
import javax.swing.JPanel;

public class MyPanel extends JPanel{
    Color outlineColor = Color.black;
    Color nodeColor = Color.pink;
    Color edgeColor = Color.gray;

    GeomAVLTree tree;

    MyPanel(){
        this.setPreferredSize(new Dimension(500,500));
    }

    MyPanel(GeomAVLTree t){
        this.setPreferredSize(new Dimension(500,500));
        tree = t;
    }

    public void paint(Graphics g){
        Graphics2D g2D = (Graphics2D) g;
        g2D.setStroke(new BasicStroke(3));
        drawTree(tree.getRoot(), g2D);
    }

    public void drawTree(AVLNode crt, Graphics2D g){
        if (crt == null){
            return;
        }
        drawNode(crt, g);
        if (crt.getLeft() != null){
            drawEdge(crt, crt.getLeft(), g);
            drawTree(crt.getLeft(), g);
        }
        if (crt.getRight() != null){
            drawEdge(crt, crt.getRight(), g);
            drawTree(crt.getRight(), g);
        }
    }

    public void drawNode(AVLNode node, Graphics2D g){
        g.setPaint(nodeColor);
        g.fillOval(node.p.x, node.p.y, 50,50);
        g.setPaint(Color.black);
        g.drawOval(node.p.x, node.p.y, 50,50);
        g.drawString(node.getData() + "", node.p.x, node.p.y);
    }

    public void drawEdge(AVLNode parent, AVLNode child, Graphics2D g){
        g.setPaint(edgeColor);
        g.drawLine(parent.p.x + 25, parent.p.y + 25, child.p.x + 25, child.p.y + 25);
    }
}
