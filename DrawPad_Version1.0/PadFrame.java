import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PadFrame extends JFrame
{
    private JButton jb = new JButton("Line");
    private JButton jb2 = new JButton("Oval");
    private JButton jb3 = new JButton("Rect");
    private JButton CurveButton = new JButton("Curve");
    private JButton jb4 = new JButton("CurveBug");
    PadFrame()
    {
        initUI();

        Graphics g = this.getGraphics();

        PadActionListener padActionListener = new PadActionListener(g);     //Add Action Listener
        this.addMouseListener(padActionListener);                           //Mouse Action Listener
        this.addMouseMotionListener(padActionListener);
        jb.addActionListener(padActionListener);
        jb2.addActionListener(padActionListener);
        jb3.addActionListener(padActionListener);
        CurveButton.addActionListener(padActionListener);
        jb4.addActionListener(padActionListener);

    }
    public void initUI()
    {
        this.setTitle("Java DrawPad Version1.0");
        this.setSize(1000,700);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);  //Exit the App
        this.setLocationRelativeTo(null);              //CENTER

        FlowLayout flowLayout = new FlowLayout(FlowLayout.LEFT);
        this.setLayout(flowLayout);

        this.add(jb);
        this.add(jb2);
        this.add(jb3);
        this.add(CurveButton);
        this.add(jb4);


        this.setVisible(true);
    }


}
