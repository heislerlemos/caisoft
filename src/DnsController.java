import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;

import org.xbill.DNS.lookup.LookupSession;
import org.xbill.DNS.Record;
import org.xbill.DNS.Name;
import org.xbill.DNS.MXRecord;


public class DnsController implements ActionListener {




// Dns checking function

    @Override
    public void actionPerformed(ActionEvent e)
    {

                System.out.println("Searching for the record ip : " + Layout.filenames.getText());

                try {
                    InetAddress address = InetAddress.getByName(Layout.filenames.getText());
                    System.out.println("This is the record " + address);
                    //JOptionPane.showMessageDialog(null, address);
                    LookupSession s = LookupSession.defaultBuilder().build();
                    Name mxLookup = Name.fromString(Layout.filenames.getText());
                    s.lookupAsync(mxLookup, org.xbill.DNS.Type.MX)
                            .whenComplete(
                                    (answers, ex) -> {
                                        if (ex == null) {
                                            if (answers.getRecords().isEmpty()) {
                                                System.out.println(mxLookup + " has no MX");
                                                Layout.area.setText(mxLookup + " has no MX" );


                                            } else {
                                                for (Record rec : answers.getRecords()) {
                                                    MXRecord mx = ((MXRecord) rec);
                                                    System.out.println("Host " + mx.getTarget() + " has preference " + mx.getPriority());
                                                    Layout.area.setText("IP do Host : " + address +  "\n"  + "Email do Host : " + mx.getTarget()  );

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
//      End of dns checking function


}