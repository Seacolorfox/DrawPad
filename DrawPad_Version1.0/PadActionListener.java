import java.awt.*;
import java.awt.event.*;

public class PadActionListener implements ActionListener, MouseListener, MouseMotionListener
{
    private Graphics g;
    private int x1,y1,x2,y2;
    private String storeString;
    private int PenStatus = 1;

    PadActionListener(Graphics g)
    {
        this.g = g;
    }


    @Override
    public void mouseEntered(MouseEvent e) {

    }
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(PenStatus == 1)
        {
            x1 = e.getX();
            y1 = e.getY();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(PenStatus == 1)
        {
            x2 = e.getX();
            y2 = e.getY();
        }
        if("Line".equals(storeString))
        {
            g.drawLine(x1,y1,x2,y2);
        }
        if("Oval".equals(storeString))
        {
            g.drawOval(x1,y1,Math.abs(x2-x1),Math.abs(y2-y1));
        }
        if("Rect".equals(storeString))
        {
            g.drawRect(x1,y1,Math.abs(x2-x1),Math.abs(y2-y1));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if("Curve".equals(storeString))
        {
            int x,y;
            x = e.getX();
            y = e.getY();
            g.drawLine(x1,y1,x,y);
            x1 = x;
            y1 = y;
        }
        if("CurveBug".equals(storeString))
        {
            int x,y;
            x = e.getX();
            y = e.getY();
            g.drawLine(x1,y1,x,y);
            x1 = x;
            x2 = y;       //ERROR: x2 = y   But it's beautiful  and funny XD
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
    @Override
    public void actionPerformed(ActionEvent e) {
       storeString = e.getActionCommand();
    }
}
