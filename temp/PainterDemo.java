/*
 *只画直线，矩形，椭圆，只能向右下角画
 *
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
class PainterPanel extends JPanel implements MouseListener{
    int shape=-1; //图案类型
    Point[] point=new Point[2]; //记录鼠标拖动的起始点和终点

    public PainterPanel(){
        super(); //调用父类构造函数
        this.setBackground(Color.white); //设置背景颜色
        point[0]=new Point(-1,-1); //初始化变量
        point[1]=new Point(-1,-1);
        addMouseListener(this); //增加鼠标事件
    }

    public void mouseReleased(MouseEvent e){ //鼠标释放事件
        point[1]=new Point(e.getX(),e.getY()); //设置终点位置
        repaint(); //重绘屏幕
    }

    public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e){}
    public void mouseClicked(MouseEvent e){}

    public void mousePressed(MouseEvent e){ //鼠标按下时事件
        point[0]=new Point(e.getX(),e.getY()); //设置起始点位置
    }

    public void paint(Graphics g){
        super.paint(g);
        switch (shape){ //根据shape值绘制图形
            case 0:
                g.drawLine(point[0].x,point[0].y,point[1].x,point[1].y); //绘线
                break;

            case 1:
                int width=point[1].x-point[0].x;
                int height=point[1].y-point[0].y;
                g.drawOval(point[0].x,point[0].y,width,height); //绘椭圆
                break;

            case 2:
                width=point[1].x-point[0].x;
                height=point[1].y-point[0].y;
                g.drawRect(point[0].x,point[0].y,width,height); //绘矩形
                break;
        }
    }
    public void drawShape(int shape){
        this.shape=shape;
    }
}

public class PainterDemo extends JFrame{
    JToggleButton[] button=new JToggleButton[3]; //按钮组
    PainterPanel painter=new PainterPanel(); //绘图面板
    public PainterDemo(){
        super("Java画图程序"); //调用父类构造函数
        String[] buttonName={"直线","椭圆","矩形"}; //按钮文字
        DrawShapeListener buttonListener=new DrawShapeListener(); //按钮事件
        JToolBar toolBar=new JToolBar(); //实例化工具栏
        ButtonGroup buttonGroup=new ButtonGroup(); //实例化按钮组

        for (int i=0;i<button.length;i++){
            button[i]=new JToggleButton(buttonName[i]); //实例化按钮
            button[i].addActionListener(buttonListener); //增加按钮事件处理
            buttonGroup.add(button[i]); //增加按钮到按钮组
            toolBar.add(button[i]); //增加按钮到工具栏
        }

        Container container=getContentPane(); //得到窗口容器
        container.add(toolBar,BorderLayout.NORTH); //增加组件到容器上
        container.add(painter,BorderLayout.CENTER);
        setSize(300,200); //设置窗口尺寸
        setVisible(true); //设置窗口为可视
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //关闭窗口时退出程序
    }
    //内部类
    class DrawShapeListener implements ActionListener{ //按钮事件处理
        public void actionPerformed(ActionEvent e){
            for (int i=0;i<button.length;i++){
                if (e.getSource()==button[i]){ //判断来自于哪个按钮
                    painter.drawShape(i); //绘制图形
                }
            }
        }
    }

    public static void main(String[] args){
        new PainterDemo();
    }
}
