package com.cmpe202.individualproject.reader;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import com.cmpe202.individualproject.creditCard.CreditCardEntry;

import java.util.List;

class XMLReaderTest {
    @Test
    void checkReadXml() {
        XMLReader xmlReaderObj = new XMLReader();
        String filePath = "src/test/java/sampleFiles/input_file.xml";
        List<CreditCardEntry> result = xmlReaderObj.readFile(filePath);
        String name = result.get(0).getCardHolderName();
        String cardNumber = result.get(0).getCardNumber();
        Assert.assertEquals(name, "John DoE");
        Assert.assertTrue(result.size() == 12);
        Assert.assertEquals(cardNumber, "5567894523129089");
    }
}