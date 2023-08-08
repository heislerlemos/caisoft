import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;



public class InventoryView  implements ActionListener {
    public static JPanel panel2;



        @Override
    public void actionPerformed(ActionEvent e){

            JFrame frame2  = new JFrame();
            frame2.setSize(900,500);
            //frame2.getContentPane().setBackground(new Color(255, 192, 203));
            frame2.setLayout(new FlowLayout());
            JPanel newPanel = new JPanel();

            newPanel.setPreferredSize(new Dimension(680,450));
            newPanel.setBackground(Color.green);

            frame2.add(newPanel);
            frame2.setLocationRelativeTo(null);
            frame2.setResizable(false);
            frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            //frame2.add(Layout.menubar);
//Creating a button with a text
                JButton button=new JButton("Fechar Janela");
//Setting the cursor to the hand symbol
                button.setCursor(new Cursor(Cursor.HAND_CURSOR));

                button.addActionListener(event->{
                        frame2.dispose();
                });


                JLabel label = new JLabel("Artigo");
                label.setForeground(Color.WHITE);
            JTextField artigo = new JTextField(20);


            JLabel labeldata = new JLabel("Data");
            labeldata.setForeground(Color.WHITE);
            JTextField artigodata = new JTextField(20);



            newPanel.setBackground(new Color(64,64,64));
            newPanel.add(artigodata);
            newPanel.add(labeldata);
            newPanel.add(label);
            newPanel.add(artigo);
            newPanel.add(button);

            newPanel.setVisible(true);





            frame2.setVisible(true);




    }
}