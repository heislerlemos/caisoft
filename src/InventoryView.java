import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;



public class InventoryView  implements ActionListener {
    public static JPanel panel2;



        @Override
    public void actionPerformed(ActionEvent e){

            Layout.panel.setVisible(false);
            JPanel newPanel = new JPanel();
            JLabel label = new JLabel("Enter username:");
            JTextField userName = new JTextField(20);

            newPanel.add(label);
            newPanel.add(userName);


    }
}