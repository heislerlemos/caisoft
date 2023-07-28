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

        this.setTitle("COMUNIDADE DE INFORMATICA DE ANGOLA SOFTWARE");
        this.setSize(600,350);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(new Color(208,208,208));
        this.setLayout(new FlowLayout());
        this.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(550,250));
        panel.add(Box.createVerticalStrut(50));
        panel.setBackground(new Color(1, 50, 32));
        panel.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 10));

//      Dns check window
        JLabel name = new JLabel("Insira o registo de dns  :");
        name.setForeground(Color.WHITE);
        panel.add(name);

        filenames = new JTextField(15);
        panel.add(filenames);

        JButton b = new JButton("Procurar o registo");
        b.addActionListener(new DnsController());
        panel.add(b);

        area = new JTextArea(5, 46);
        panel.setSize(300,400);
        panel.add(area);

//      End of dns check window

        this.setResizable(false);
        this.add(panel);
        this.setVisible(true);

    }

}
