import org.xbill.DNS.*;
import java.net.InetAddress;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("DNS CHECKER");
        frame.setSize(100,100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(144, 238, 144));
        frame.setLayout(new FlowLayout());

        JLabel name = new JLabel("Insira o registo txt :");
        frame.add(name);

        JTextField fieldname = new JTextField(30);
        frame.add(fieldname);

        JButton b = new JButton("Procurar o registo");
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.out.println("Serching for the record ip : " + fieldname.getText());
                try {
                    InetAddress address = InetAddress.getByName(fieldname.getText());
                    System.out.println("This is the record " + address);

                }
                catch(Exception c) {
                    System.out.println("Can't find the record in :");

                }



            }
        });
        frame.add(b);

        frame.setVisible(true);



    }
}