import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;


public class InventoryController implements ActionListener {
    public void actionPerformed(ActionEvent e) {


        //Path fileName = Paths.get("./inventorydb.xml");

        File fout = new File("./inventorydb.xml");

        try (FileOutputStream fos = new FileOutputStream(fout); BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));) {

            int count = 0;

            String[] numberOfProperty = new String[4];
            numberOfProperty[0] = InventoryView.nomeartigosfield.getText();
            numberOfProperty[1] = InventoryView.nomedatafied.getText();
            numberOfProperty[2] = InventoryView.nomefucntfield.getText();
            numberOfProperty[3] = InventoryView.numerofunctfield.getText();

            for (String s : numberOfProperty) {
                Integer id = count += 1;
                bw.write( s +  " , " );


            }
        } catch (IOException ignored) {

        }


        /***

         try {

         Files.writeString(fileName,InventoryView.nomefucntfield.getText());
         Files.writeString(fileName,InventoryView.nomeartigosfield.getText());
         Files.writeString(fileName, InventoryView.numerofunctfield.getText());
         Files.writeString(fileName,InventoryView.nomedatafied.getText());




         } catch (IOException ex) {
         throw new RuntimeException(ex);
         }

         String file_content = null;

         try {
         file_content = Files.readString(fileName);
         } catch (IOException ex) {
         throw new RuntimeException(ex);
         }

         System.out.println("Informação adicionada  : "  + file_content);
         ***/
    }
}
