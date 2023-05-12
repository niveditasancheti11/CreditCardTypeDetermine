package com.cmpe202.individualproject.main;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class AppTest {
    @Test
    void checkValidXMLFileType() {
        String inputFile = "src/test/java/sampleFiles/input_file.xml";
//      CreditCardClient appObj = new CreditCardClient();
        String result = CreditCardClient.getFileType(inputFile);
        Assert.assertEquals(result, "xml");
    }

    @Test
    void checkValidJSONFileType() {
        String inputFile = "src/test/java/sampleFiles/input_file.json";
//        CreditCardClient appObj = new CreditCardClient();
        String result = CreditCardClient.getFileType(inputFile);
        Assert.assertEquals(result, "json");
    }

    @Test
    void checkValidCSVFileType() {
        String inputFile = "src/test/java/sampleFiles/input_file.csv";
        //CreditCardClient appObj = new CreditCardClient();
        String result = CreditCardClient.getFileType(inputFile);
        Assert.assertEquals(result, "csv");
    }

    @Test
    void checkInvalidFileType() {
        String inputFile = "src/test/java/sampleFiles/inputxmlcopy.ssd";
        //CreditCardClient appObj = new CreditCardClient();
        String result = CreditCardClient.getFileType(inputFile);
        Assert.assertNotEquals(result, "json");
    }

}