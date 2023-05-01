import java.awt.*;
import javax.swing.JPanel;
import java.util.ArrayList;
import java.util.LinkedList;

public class MyPanel extends JPanel{
    Color outline = Color.black;
    Color vertex = Color.pink;
    Color edge = Color.gray;

    ArrayList<Point> points;
    ArrayList<Vertex> vertices;
    LinkedList<Edge> edges;

    MyPanel(){
        this.setPreferredSize(new Dimension(500,500));
    }

    public MyPanel(GeomGraph g){
        this.setPreferredSize(new Dimension(500,500));
        points = g.points;
        edges = g.edges;
        vertices = g.vertices;
    }

    //pass in the GeomGraph so that you can fill in the arrays for point, string, and edge so that you can pass it into your draw function

    

    public void paint(Graphics g){
        Graphics2D g2D = (Graphics2D) g;
        g2D.setStroke(new BasicStroke(3));

        // Point p1 = new Point(50,50);
        // Point p2 = new Point(300,200);
        // Point p3 = new Point (150, 50);
        // Point p4 = new Point (50,400);

        // Point[] setOfPoints = {p1, p2, p3, p4};

        // drawScene(setOfPoints, g2D);
        // drawLabel("A", p1, g2D);
        // drawLabel("B", p2, g2D);
        // drawLabel("C", p3, g2D);
        // drawLabel("D", p4, g2D);
        // drawEdge(p1, p2, g2D);
        // drawEdge(p3, p4, g2D);
        // drawEdge(p1, p4, g2D);
        // drawEdge(p3, p1, g2D);
        drawGraph(g2D);
    }

    public void drawGraph(Graphics2D g){
        for (int i = 0; i < edges.size(); i++){
            Edge currentEdge = edges.get(i);
            currentEdge.drawEdge(points.get(currentEdge.getHead()), points.get(currentEdge.getTail()), g);
        }
        for (int i = 0; i < vertices.size(); i++){
            if (vertices.get(i) != null){
                vertices.get(i).drawVertex(points.get(i), g);
                g.setPaint(Color.black);
                g.drawString(vertices.get(i).getName(), points.get(i).x, points.get(i).y);
            }
        }
    }

    public void drawVertex(Point p, Graphics2D g){
        g.setPaint(Color.pink);
        g.fillOval(p.x, p.y, 50,50);
        g.setPaint(Color.black);
        g.drawOval(p.x, p.y, 50,50);
    }

    public void drawEdge(Point p1, Point p2, Graphics2D g){
        g.setPaint(Color.gray);
        g.drawLine(p1.x + 25, p1.y + 25, p2.x + 25, p2.y + 25);
    }
}
