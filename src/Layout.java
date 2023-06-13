import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import javax.swing.JTextArea;



public class Layout extends JFrame {
    public Layout() {
       // JFrame frame = new JFrame("DNS CHECKER");
        this.setTitle("CAI SOFT");
        this.setSize(600,350);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(new Color(208,208,208));
        this.setLayout(new FlowLayout());



        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(550,250));
        panel.setBackground(Color.gray);
        panel.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 10));



    //    JLabel title = new JLabel("Check you dns records ! ");
    //    panel.add(title);


        JLabel name = new JLabel("Insira o registo de dns  :");
        panel.add(name);

        JTextField fieldname = new JTextField(10);
        panel.add(fieldname);

        JButton b = new JButton("Procurar o registo");
        panel.add(b);

        JTextArea area=new JTextArea(5, 46);
        panel.add(area);
        panel.setSize(300,400);


        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.out.println("Serching for the record ip : " + fieldname.getText());
                try {
                    InetAddress address = InetAddress.getByName(fieldname.getText());
                    System.out.println("This is the record " + address);
                    //JOptionPane.showMessageDialog(null, address);
                    area.setText("host value " + address);


                }
                catch(Exception c) {
                    System.out.println("Can't find the record in :");

                }



            }


        });

        this.setResizable(false);
        this.add(panel);
        this.setVisible(true);



    }
}
