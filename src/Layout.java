import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import javax.swing.JTextArea;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import org.xbill.DNS.lookup.LookupSession;
import org.xbill.DNS.Record;
import org.xbill.DNS.Name;
import org.xbill.DNS.MXRecord;
import javax.swing.Box;

public class Layout extends JFrame {
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



    //    JLabel title = new JLabel("Check you dns records ! ");
    //    panel.add(title);


        JLabel name = new JLabel("Insira o registo de dns  :");
        name.setForeground(Color.WHITE);
        panel.add(name);

        JTextField fieldname = new JTextField(15);
        panel.add(fieldname);

        JButton b = new JButton("Procurar o registo");
        panel.add(b);

        JTextArea area=new JTextArea(5, 46);
        panel.add(area);
        panel.setSize(300,400);


        // Build a port tester with telnet
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.out.println("Serching for the record ip : " + fieldname.getText());


                try {
                    InetAddress address = InetAddress.getByName(fieldname.getText());
                    System.out.println("This is the record " + address);
                    //JOptionPane.showMessageDialog(null, address);





                    LookupSession s = LookupSession.defaultBuilder().build();
                    Name mxLookup = Name.fromString(fieldname.getText());
                    s.lookupAsync(mxLookup, org.xbill.DNS.Type.MX)
                            .whenComplete(
                                    (answers, ex) -> {
                                        if (ex == null) {
                                            if (answers.getRecords().isEmpty()) {
                                                System.out.println(mxLookup + " has no MX");
                                                area.setText(mxLookup + " has no MX" );

                                            } else {
                                                for (Record rec : answers.getRecords()) {
                                                    MXRecord mx = ((MXRecord) rec);
                                                    System.out.println(
                                                            "Host " + mx.getTarget() + " has preference " + mx.getPriority());
                                                    area.setText("IP do Host : " + address +  "\n"  + "Email do Host : " + mx.getTarget()  );
                                                }
                                            }
                                        } else {
                                            ex.printStackTrace();
                                        }
                                    })
                            .toCompletableFuture()
                            .get();



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
