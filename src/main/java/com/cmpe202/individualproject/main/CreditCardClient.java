package com.cmpe202.individualproject.main;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import com.cmpe202.individualproject.creditCard.CreditCardEntry;
import com.cmpe202.individualproject.reader.*;
import com.cmpe202.individualproject.writer.*;

public class CreditCardClient {

    public static String getFileType(String inputFile) {
        String extension = "";
        int i = inputFile.lastIndexOf('.');
        if (i > 0) {
            extension = inputFile.substring(i + 1);
        }
        return extension;
    }

    public static void main(String[] args) {
        try {
            String outputFile, inputFile;
            String inputFileType = "";
            String outputFileType = "";
            IReaderStrategy filereader;
            IWriterStrategy filewriter = null;
            List<OutputData> finalEntries = new ArrayList<>();

            if (args.length < 2) {
                throw new IllegalArgumentException("Please enter correct arguments");
            }
            inputFile = args[0];
            outputFile = args[1];

            inputFileType = inputFile.substring(inputFile.indexOf("."));
            outputFileType = outputFile.substring(outputFile.indexOf("."));

            if (!inputFileType.equals(outputFileType)) {
                System.out.println("Input and Output extensions are not same");
                System.exit(0);
            } else {
                System.out.println(
                        "Input and output extensions " + inputFileType + " and " + outputFileType + " are same");
            }

            String fileType = getFileType(inputFile);
            System.out.println(fileType);

            ;
            List<CreditCardEntry> creditCardEntries = new ArrayList<CreditCardEntry>();
            if (fileType.equalsIgnoreCase("csv")) {
                filereader = new CSVReader(new File(inputFile));
                filewriter = new CSVWriter();
                creditCardEntries = filereader.readFile(inputFile);
            } else if (fileType.equalsIgnoreCase("json")) {
                filereader = new JSONReader(new File(inputFile));
                filewriter = new JSONWriter();
                creditCardEntries = filereader.readFile(inputFile);
            } else if (fileType.equalsIgnoreCase("xml")) {
                System.out.println(" in xml ");
                filereader = new XMLReader(new File(inputFile));
                filewriter = new XMLWriter();
                creditCardEntries = filereader.readFile(inputFile);
            }


                List<CreditCardEntry> creditCards = new ArrayList<>();
                for (CreditCardEntry entry : creditCardEntries) {
                    //String[] creditCardRecord = line.split(cvsSplitBy);
                    CreditCardEntry creditCard = CreditCardFactory.createCreditCard(entry);
                    creditCards.add(creditCard);
                }
                
                for (CreditCardEntry creditCard : creditCards) {
                    System.out.println(creditCard.toString());

                    finalEntries.add(new OutputData(creditCard.getCardNumber(), creditCard.getType()));
                    filewriter.writeToFile(finalEntries, outputFile);
                }
            
        }
    
        catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
}
