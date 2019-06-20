import javax.swing.*;
import java.awt.*;

public class PadFrame extends JFrame
{
    private JPanel NorthJpanel = new JPanel();
    private JPanel InNorthJpanel = new JPanel();
    private JButton jb = new JButton("text");
    PadFrame()
    {
        initUI();
        NorthJpanel.setLayout(new FlowLayout(FlowLayout.LEFT,1,0));
        NorthJpanel.setBackground(new Color(1,240,240));
        this.add(NorthJpanel,BorderLayout.NORTH);

        InNorthJpanel.setLayout(new FlowLayout(FlowLayout.LEFT,1,0));
        InNorthJpanel.setPreferredSize(new Dimension(900,150));
        InNorthJpanel.setBackground(new Color(1,1,1));
        NorthJpanel.add(InNorthJpanel);

        NorthJpanel.add(jb);

    }
    public void initUI()
    {
        this.setTitle("Java DrawPad Demo");
        this.setSize(1000,700);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);  //Exit the App
        this.setLocationRelativeTo(null);              //CENTER
        this.setLayout(new BorderLayout());
//        this.add(NorthJpanel);

        this.setVisible(true);
    }


}
