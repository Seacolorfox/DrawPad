import java.awt.geom.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
/**
 *简单的画图程序
 *@author Eastsun
 *@version .1
 */
public class DrawPanel extends JFrame{
    LinkedList<Shape> shapeList =new LinkedList<Shape>();
    Shape shape;
    Point start,end;
    final String[] type =new String[]{"Line","Rectangle","Ellipse"};
    JComboBox comboBox =new JComboBox(type);
    public DrawPanel(){
        super("DrawPanel");
        JPanel panel =new JPanel(){
            public void paintComponent(Graphics g){
                super.paintComponent(g);
                Graphics2D g2 =(Graphics2D)g;
                g2.setColor(Color.white);
                g2.fillRect(0,0,getWidth(),getHeight());
                g2.setColor(Color.black);
                for(Shape s:shapeList) g2.draw(s);
                g2.draw(shape);
            }
        };
        panel.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent e){
                start =e.getPoint();
            }
            public void mouseReleased(MouseEvent e){
                shapeList.add(shape);
            }
        });
        panel.addMouseMotionListener(new MouseMotionAdapter(){
            public void mouseDragged(MouseEvent e){
                end =e.getPoint();
                Object select =comboBox.getSelectedItem();
                if(select.equals(type[0])) shape =new Line2D.Float(start,end);
                else{
                    if(select.equals(type[1])) shape =new Rectangle();
                    else                 shape =new Ellipse2D.Float();
                    ((RectangularShape)shape).setFrameFromDiagonal(start,end);
                }
                repaint();
            }
        });
        panel.setPreferredSize(new Dimension(320,240));
        add(panel,BorderLayout.NORTH);
        shape =new Rectangle();

        add(comboBox,BorderLayout.SOUTH);

        pack();
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }
    public static void main(String[] args){
        new DrawPanel();
    }
}