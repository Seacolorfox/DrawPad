import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PadFrame extends JFrame
{
    private JMenu menuFile = new JMenu("文件");
    private JMenuBar menuBar = new JMenuBar();
    private JMenuItem newItem = new JMenuItem("新建");
    private JMenuItem openItem = new JMenuItem("打开");
    private JMenuItem saveItem = new JMenuItem("保存");
    private JMenuItem about = new JMenuItem("关于");
    private JMenuItem closeItem = new JMenuItem("关闭");

    private JButton lineButton = new JButton("Line");
    private JButton ovalButton = new JButton("Oval");
    private JButton rectButton = new JButton("Rect");
    private JButton CurveButton = new JButton("Curve");
    private JButton curveBugButton = new JButton("CurveBug");
    PadFrame()
    {
        initUI();

        Graphics g = this.getGraphics();

        MenuActionListener menuActionListener = new MenuActionListener();
        closeItem.addActionListener(menuActionListener);
        PadActionListener padActionListener = new PadActionListener(g);     //Add Action Listener

        this.addMouseListener(padActionListener);                           //Mouse Action Listener
        this.addMouseMotionListener(padActionListener);

        lineButton.addActionListener(padActionListener);
        ovalButton.addActionListener(padActionListener);
        rectButton.addActionListener(padActionListener);
        CurveButton.addActionListener(padActionListener);
        curveBugButton.addActionListener(padActionListener);

    }
    public void initUI()
    {
        this.setTitle("Java DrawPad Version1.0");
        this.setSize(1000,700);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);  //Exit the App
        this.setLocationRelativeTo(null);              //CENTER

        FlowLayout flowLayout = new FlowLayout(FlowLayout.LEFT);
        this.setLayout(flowLayout);
        //Add Menu
        menuBar.add(menuFile);
        menuFile.add(newItem);
        menuFile.add(openItem);
        menuFile.add(saveItem);
        menuFile.add(about);
        menuFile.addSeparator();
        menuFile.add(closeItem);
        this.add(menuBar);
        //Add Button
        this.add(lineButton);
        this.add(ovalButton);
        this.add(rectButton);
        this.add(CurveButton);
        this.add(curveBugButton);

        this.setVisible(true);
    }


}
