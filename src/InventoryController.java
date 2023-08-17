
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.StandardOpenOption;


public class InventoryController implements ActionListener {

    public void actionPerformed(ActionEvent e) {

        File fout = new File("./inventorydb.xml");

        try (FileOutputStream fos = new FileOutputStream(fout);
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos))) {

            int count = 0;

            String[] numberOfProperty = new String[4];
            numberOfProperty[0] = InventoryView.nomeartigosfield.getText();
            numberOfProperty[1] = InventoryView.numerofunctfield.getText();
            numberOfProperty[2] = InventoryView.nomefucntfield.getText();
            numberOfProperty[3] = InventoryView.nomedatafied.getText();


            for (String s : numberOfProperty) {
                Integer id = count += 1;


                String filePath = "./inventorydb.xml";

                try(FileWriter fw = new FileWriter(filePath, true);
                    BufferedWriter writer = new BufferedWriter(fw);) {

                    writer.write(s);
                }

            }

        } catch (IOException ignored) {

        }

        System.out.println("Dados inseridos");






    }

}
