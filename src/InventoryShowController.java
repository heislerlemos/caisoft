import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class InventoryShowController implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {

        DocumentBuilderFactory factory =  DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document document = builder.parse(new File("./inventory.xml"));

            document.getDocumentElement().normalize();

           NodeList userlist =  document.getElementsByTagName("User");



           for(int i = 0; i < userlist.getLength();  i++) {
               Node user = userlist.item(i);

               if (user.getNodeType() == Node.ELEMENT_NODE) {
                   Element userelement  = (Element) user;
                   InventoryView.textArea.setText(userelement.getTagName());

                   NodeList laptopDetails =  userelement.getChildNodes();
                   for(int j = 0; j < laptopDetails.getLength(); j++){
                       Node detail = laptopDetails.item(j);
                       if(detail.getNodeType() == Node.ELEMENT_NODE) {
                           Element detailElement = (Element) detail;
                           System.out.println("     " + detailElement.getTagName() + ": " + detailElement.getAttribute("value"));
                           InventoryView.textArea.append( detailElement.getTagName() + ": " + detailElement.getAttribute("value") + "\n");
                       }

                   }




               }
           }

        } catch (ParserConfigurationException | IOException | SAXException ex) {
            throw new RuntimeException(ex);
        }

    }
}
