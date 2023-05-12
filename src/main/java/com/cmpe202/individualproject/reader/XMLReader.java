package com.cmpe202.individualproject.reader;

import com.cmpe202.individualproject.creditCard.CreditCardEntry;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class XMLReader implements IReaderStrategy {
    File file;

    public XMLReader(File file) {
        this.file = file;
    }

    public XMLReader() {
    }

    @Override
    public List<CreditCardEntry> readFile(String inputFile) {
        List<CreditCardEntry> result = new ArrayList<>();
        File fileReader;
       
          DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
         try {
            dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
            DocumentBuilder db = dbf.newDocumentBuilder();
            fileReader = new File(inputFile);
            Document doc = db.parse(fileReader);
            NodeList list = doc.getElementsByTagName("CARD");

            for (int temp = 0; temp < list.getLength(); temp++) {
                Node node = list.item(temp);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;

                    // Long cardNumber = Long.parseLong(element.getElementsByTagName("CARD_NUMBER").item(0).getTextContent());
                    String cardNumber = element.getElementsByTagName("CARD_NUMBER").item(0).getTextContent();
                    String exp = element.getElementsByTagName("EXPIRATION_DATE").item(0).getTextContent();
                    //System.out.print(exp + " ------------------------------ getting date ");
                    // System.out.println(LocalDate.parse(a, dtf));
                //    Date eDate = sdf.parse(String.valueOf(a));
                 //   System.out.print(eDate + " ------------------------------ NNNNNNN date ");


                    // LocalDate eDate = LocalDate.parse(a, dtf);

                    String nameCardHolder = element.getElementsByTagName("CARD_HOLDER_NAME").item(0).getTextContent();

                    CreditCardEntry ccEntry = new CreditCardEntry(cardNumber, exp, nameCardHolder);
                    result.add(ccEntry);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
