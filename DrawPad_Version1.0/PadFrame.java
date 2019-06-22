import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PadFrame extends JFrame
{
    PaintingArea paintingArea = new PaintingArea();

    private JPanel NorthJpanel = new JPanel();
    private JPanel InNorthJpanel = new JPanel();

    private JButton jb = new JButton("Line");
    private JButton jb2 = new JButton("Oval");
    private JButton jb3 = new JButton("Rect");
    private JButton jb4 = new JButton("Clean");
    PadFrame()
    {
        initUI();
        NorthJpanel.setLayout(new FlowLayout(FlowLayout.LEFT,1,0));
        NorthJpanel.setBackground(new Color(1,240,240));
        this.add(NorthJpanel,BorderLayout.NORTH);

        InNorthJpanel.setLayout(new FlowLayout(FlowLayout.LEFT,1,0));
        InNorthJpanel.setPreferredSize(new Dimension(200,75));
        InNorthJpanel.setBackground(new Color(1,1,1));

        InNorthJpanel.add(jb);
        InNorthJpanel.add(jb2);
        InNorthJpanel.add(jb3);
        InNorthJpanel.add(jb4);

        PadListener padListener = new PadListener();
        jb.addActionListener(padListener);
        jb2.addActionListener(padListener);
        jb3.addActionListener(padListener);
        jb4.addActionListener(padListener);

        NorthJpanel.add(InNorthJpanel);



    }
    public void initUI()
    {
        this.setTitle("Java DrawPad Demo");
        this.setSize(1000,700);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);  //Exit the App
        this.setLocationRelativeTo(null);              //CENTER
        this.setLayout(new BorderLayout());
//        this.add(NorthJpanel);
        this.add(paintingArea,BorderLayout.CENTER);
        this.setVisible(true);
    }
//Inner Class
    public class PadListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==jb)
            {
                paintingArea.drawShape(0);

            }
            if(e.getSource()==jb2)
            {
                paintingArea.drawShape(1);
            }
            if(e.getSource()==jb3)
            {
                paintingArea.drawShape(2);
            }
            if(e.getSource()==jb4)
            {

            }
        }
    }

}
