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
        this.setSize(100,100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(new Color(208,208,208));
        this.setLayout(new FlowLayout());

        JLabel name = new JLabel("Insira o registo txt :");
        this.add(name);

        JTextField fieldname = new JTextField(30);
        this.add(fieldname);

        JButton b = new JButton("Procurar o registo");

        JTextArea area=new JTextArea("output of the record");
        area.setBounds(10,30, 200,200);
        this.add(area);
        this.setSize(300,400);

        this.setVisible(true);

        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.out.println("Serching for the record ip : " + fieldname.getText());
                try {
                    InetAddress address = InetAddress.getByName(fieldname.getText());
                    System.out.println("This is the record " + address);
                    JOptionPane.showMessageDialog(null, address);
                    area.setText("host value " + address);


                }
                catch(Exception c) {
                    System.out.println("Can't find the record in :");

                }



            }


        });
        this.add(b);

        this.setVisible(true);



    }
}
