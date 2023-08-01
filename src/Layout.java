import java.awt.*;
import javax.swing.*;


public class Layout extends JFrame {
        public static JTextField filenames;
        public static JTextArea area;
        public static JTextField filenamesbinary;
        public static JTextArea areabinary;

        public static JPanel panel;




        public Layout() {

            this.setTitle("COMUNIDADE ANGOLANA DE INFORMATICA SOFTWARE \uD83D\uDCDF ");
            this.setSize(600,400);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.getContentPane().setBackground(new Color(105,105,105));
            this.setLayout(new FlowLayout());
            this.setLocationRelativeTo(null);

     JMenuBar menubar = new JMenuBar();
            this.setJMenuBar(menubar);


           JMenu menu = new JMenu("Menu");
            menubar.add(menu);
            JMenuItem menuItem = new JMenuItem("Network");
            //menuItem.addActionListener(new InventoryView());
            menuItem.addActionListener(new NetworkView());
            menu.add(menuItem);
            JMenuItem menuInventory = new JMenuItem("Inventory");
            menuInventory.addActionListener(new InventoryView());
            menu.add(menuInventory);



         panel = new JPanel();
        panel.setPreferredSize(new Dimension(580,370));
        panel.add(Box.createVerticalStrut(50));
        panel.setBackground(new Color(64,64,64));
        panel.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 10));


//      Dns check window
        JLabel name = new JLabel("Insira o registo de dns  :");
        name.setForeground(Color.WHITE);
        panel.add(name);

        filenames = new JTextField(15);
        filenames.setBounds(0,0,20, 20);
        filenames.setOpaque(true);
        panel.add(filenames);

        JButton b = new JButton("Procurar o registo");
        b.addActionListener(new DnsController());
        panel.add(b);

        area = new JTextArea(5, 46);
        panel.setSize(300,400);
        panel.add(area);


            //      End of dns check window


            //      Dns check window
            JLabel namebinary = new JLabel("Insira o ip para conversão  :");
            namebinary.setForeground(Color.WHITE);
            panel.add(namebinary);

            filenamesbinary = new JTextField(15);
            filenamesbinary.setBounds(0,0,20, 20);
            filenamesbinary.setOpaque(true);
            panel.add(filenamesbinary);

            JButton bbinary = new JButton("Procurar o registo");
            bbinary.addActionListener(new BinaryController());
            panel.add(bbinary);


            JButton cbinary = new JButton("Apagar registo");
            cbinary.addActionListener(new BinaryClearController());
            panel.add(cbinary);


            areabinary = new JTextArea(5, 46);
            panel.setSize(300,400);
            panel.add(areabinary);

//      End of dns check window

            this.setResizable(false);
            this.add(panel);
            this.setVisible(true);



    }

}
