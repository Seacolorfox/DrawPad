import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PaintingArea extends JPanel implements MouseListener
{
    int choiceShape = -1;
    Point point[] = new Point[2];

    PaintingArea()
    {
        super();
        this.setBackground(Color.white);
        point[0] = new Point(-1,-1);
        point[1] = new Point(-1,-1);
        addMouseListener(this);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        point[1] = new Point(e.getX(),e.getY());    //MouseReleased --> GetSecondPoint
        repaint();                                  //MouseReleased --> Repaint
    }

    @Override
    public void mouseEntered(MouseEvent e)
    {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        point[0] = new Point(e.getX(),e.getY());       //MousePressed --> GetFirstPoint
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        switch (choiceShape)
        {
            case 0:
                g.drawLine(point[0].x,point[0].y,point[1].x,point[1].y);
                break;

            case 1:
                g.drawOval(point[0].x,point[0].y,Math.abs(point[1].x-point[0].x),Math.abs(point[1].y-point[0].y));
                break;

            case 2:
                g.drawRect(point[0].x,point[0].y,Math.abs(point[1].x-point[0].x),Math.abs(point[1].y-point[0].y));
                break;
        }
    }
    public void drawShape(int choiceShape)
    {
        this.choiceShape = choiceShape;
    }
}
