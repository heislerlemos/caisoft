import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.concurrent.atomic.AtomicInteger;


public class InventoryController implements ActionListener {

    public void actionPerformed(ActionEvent e) {

        String filePath = "./inventory.xml";
        File xmlFile = new File(filePath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        try {
            dBuilder = dbFactory.newDocumentBuilder();

            // parse xml file and load into document
            Document doc = dBuilder.parse(xmlFile);

            doc.getDocumentElement().normalize();

      
            // add new element
            addElement(doc);

            // write the updated document to file or console
            writeXMLFile(doc);

        } catch (ParserConfigurationException | IOException | TransformerException | SAXException e1) {
            e1.printStackTrace();
        }
    }

    private void addElement(Document doc) {

        NodeList users = doc.getElementsByTagName("User");
        Element root;
        AtomicInteger id= new AtomicInteger(0);


        // loop for each user
        for (int i = 0; i < users.getLength(); i++) {
            root = (Element) users.item(i);

            Element Id = doc.createElement("Id");
            Id.appendChild(doc.createTextNode("id" + id.incrementAndGet()));
            root.appendChild(Id);


            Element Data = doc.createElement("Data");
            Data.appendChild(doc.createTextNode(InventoryView.nomedatafied.getText()));
            root.appendChild(Data);

            Element Funcionario = doc.createElement("Funcionario");
            Funcionario.appendChild(doc.createTextNode(InventoryView.nomefucntfield.getText()));
            root.appendChild(Funcionario);

            Element Artigo = doc.createElement("Artigo");
            Artigo.appendChild(doc.createTextNode(InventoryView.nomeartigosfield.getText()));
            root.appendChild(Artigo);


            Element Numero = doc.createElement("Numero");
            Numero.appendChild(doc.createTextNode(InventoryView.numerofunctfield.getText()));
            root.appendChild(Numero);
        }
    }


    private void writeXMLFile(Document doc)
            throws TransformerFactoryConfigurationError, TransformerException {
            doc.getDocumentElement().normalize();

            TransformerFactory transformerFactory = TransformerFactory.newInstance();

            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);

            StreamResult result = new StreamResult(new File("./inventory.xml"));
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(source, result);
            System.out.println("XML file updated successfully");
            InventoryView.textArea.setText("Dados foram guardados");

    }

}
