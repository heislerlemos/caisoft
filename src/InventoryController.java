import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;  // Import the IOException class to handle errors


public class InventoryController implements ActionListener {
    public void actionPerformed(ActionEvent e) {

      String name =  InventoryView.nomeartigosfield.getText();
       System.out.println(InventoryView.numerofunctfield.getText());
       System.out.println(InventoryView.nomeartigosfield.getText());
        System.out.println(InventoryView.nomedatafied.getText());


        try {
            File myObj = new File("outputinventory.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException d) {
            System.out.println("An error occurred.");
            d.printStackTrace();
        }


    }
}
