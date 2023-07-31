import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BinaryController implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        System.out.println("Please enter an IP Address.");
        String ip = Layout.filenamesbinary.getText();
        String[] octetArray = ip.split("\\.");
        for (String string : octetArray) {

            int octet = Integer.parseInt(string);
            String binaryOctet = Integer.toBinaryString(octet);
            System.out.println(binaryOctet);
            Layout.areabinary.append(octet + " : " + binaryOctet + "\n");

        }
    }


}