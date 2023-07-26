import org.xbill.DNS.MXRecord;
import org.xbill.DNS.Name;
import org.xbill.DNS.Record;
import org.xbill.DNS.lookup.LookupSession;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;



public class Dns extends Layout implements  ActionListener {
    private JButton b ;
    private JPanel panel;
    private JTextField fieldname;
    private JTextArea area;

    public void init() {
        b.addActionListener(this);
    }

      //  @Override
        public void actionPerformed(ActionEvent e) {

            System.out.println("Serching for the record ip : " + fieldname.getText());

            try {
                InetAddress address = InetAddress.getByName(fieldname.getText());
                System.out.println("This is the record " + address);
                //JOptionPane.showMessageDialog(null, address)
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






}