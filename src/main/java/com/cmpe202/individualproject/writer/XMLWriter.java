
package com.cmpe202.individualproject.writer;

import com.cmpe202.individualproject.main.OutputData;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.List;

public class XMLWriter implements IWriterStrategy {
    File outputFile;

    @Override
    public void writeToFile(List<OutputData> result, String outputFile) {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;

        try {
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();

            Element rootElement = doc.createElementNS("", "CARDS");
            doc.appendChild(rootElement);
            for (OutputData each : result) {
                Element rowElement = doc.createElement("CARD");
                Element nodeCardNumber = doc.createElement("CARD_NUMBER");
                if(each.getCardNumber().length() == 0) {
                    nodeCardNumber.appendChild(doc.createTextNode(""));
                    rowElement.appendChild(nodeCardNumber);
                } else {
                    nodeCardNumber.appendChild(doc.createTextNode(String.valueOf(each.getCardNumber())));
                    rowElement.appendChild(nodeCardNumber);
                }
                

                Element nodeCardType = doc.createElement("CARD_TYPE");
                nodeCardType.appendChild(doc.createTextNode(each.getType()));
                rowElement.appendChild(nodeCardType);
                rootElement.appendChild(rowElement);
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            DOMSource source = new DOMSource(doc);

            StreamResult console = new StreamResult(System.out);
            StreamResult file = new StreamResult(new File(outputFile));

            transformer.transform(source, console);
            transformer.transform(source, file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

