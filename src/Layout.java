import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JTextArea;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.Box;



public class Layout extends JFrame {

    public static JTextField filenames;
    public static JTextArea area;
    public Layout() {




        // JFrame frame = new JFrame("DNS CHECKER");
        this.setTitle("CAI SOFT");
        this.setSize(600,350);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(new Color(208,208,208));
        this.setLayout(new FlowLayout());
        this.setLocationRelativeTo(null);

        String heisler = "heisler";

        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(550,250));
        panel.add(Box.createVerticalStrut(50));
        panel.setBackground(new Color(1, 50, 32));
        panel.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 10));


        JLabel name = new JLabel("Insira o registo de dns  :");
        name.setForeground(Color.WHITE);
        panel.add(name);


        filenames = new JTextField(15);
        panel.add(filenames);



        JButton b = new JButton("Procurar o registo");
        b.addActionListener(new Dns());
        panel.add(b);




        JTextArea area =new JTextArea(5, 46);
        panel.add(area);
        panel.setSize(300,400);



        // Build a port tester with telnet

        this.setResizable(false);
        this.add(panel);
        this.setVisible(true);



    }



}
