package com.cmpe202.individualproject.reader;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

import com.cmpe202.individualproject.creditCard.*;

class CSVReaderTest {

    @Test
    void checkReadCsv() {
        String filePath = "src/test/java/sampleFiles/input_file.csv";

        CSVReader csvReaderObj = new CSVReader(new File(filePath));
        List<CreditCardEntry> result = csvReaderObj.readFile(filePath);
        String cardNumber = result.get(0).getCardNumber();
        String name = result.get(0).getCardHolderName();
        Assert.assertEquals(cardNumber, "5567894523129089");
        Assert.assertEquals(name, "John Doe");
        Assert.assertTrue(result.size() == 12);
    }
}