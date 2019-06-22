import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * Draw类，用于界面的初始化
 *
 * @author CBS
 *
 */
public class Draw {

    public static void main(String[] args) {
        Draw t = new Draw();
        t.showUI();

    }

    // 界面初始化方法
    public void showUI() {
        JFrame jf = new JFrame();
        jf.setTitle("画图");
        jf.setSize(700, 700);
        jf.setDefaultCloseOperation(3);
        jf.setLocationRelativeTo(null);
        FlowLayout layout = new FlowLayout(FlowLayout.LEFT);
        jf.setLayout(layout);
        JButton drawLine = new JButton("画直线");
        jf.add(drawLine);
        JButton drawOval = new JButton("画椭圆");
        jf.add(drawOval);
        JButton drawArc = new JButton("画曲线");
        jf.add(drawArc);
        JButton drawPolygon = new JButton("三角形");
        jf.add(drawPolygon);
        JButton jb1 = new JButton();
        jb1.setBackground(Color.RED);
        jf.add(jb1);
        jb1.setPreferredSize(new Dimension(30, 30));
        JButton jb2 = new JButton();
        jb2.setBackground(Color.GREEN);
        jf.add(jb2);
        jb2.setPreferredSize(new Dimension(30, 30));

        jf.setVisible(true);

        Graphics g = jf.getGraphics();// 获取当前的画笔
        DrawListener dl = new DrawListener(g);// 实例化DrawListener类的对象
        jf.addMouseListener(dl);// 为窗体添加鼠标事件监听方法
        jf.addMouseMotionListener(dl);// 为窗体添加鼠标移动事件监听方法

        // 为按钮添加动作监听
        drawLine.addActionListener(dl);
        drawOval.addActionListener(dl);
        jb1.addActionListener(dl);
        jb2.addActionListener(dl);
        drawArc.addActionListener(dl);
        drawPolygon.addActionListener(dl);

    }

}