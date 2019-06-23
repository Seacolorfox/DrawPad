import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuActionListener implements ActionListener
{
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if(command.equals("关于"))
        {
            JDesktopPane aboutPane = new JDesktopPane();

        }
        if(command.equals("关闭"))
        {
            System.exit(0);
        }
    }
}
