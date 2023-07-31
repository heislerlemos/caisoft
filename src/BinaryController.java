import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class BinaryController implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter an IP Address.");
        String ip = Layout.filenamesbinary.getText();
        String[] octetArray = ip.split("\\.");
        for (String string : octetArray)
        {
            int octet = Integer.parseInt(string);
            String binaryOctet = Integer.toBinaryString(octet);
            System.out.println(binaryOctet);
            Layout.areabinary.append(binaryOctet  + "\n" );
        }
    }

}
