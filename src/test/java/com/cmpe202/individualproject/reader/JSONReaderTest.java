package com.cmpe202.individualproject.reader;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

import com.cmpe202.individualproject.creditCard.*;
class JSONReaderTest {
    @Test
    void checkReadJson() {
        String filePath = "src/test/java/sampleFiles/input_file.json";

        JSONReader jsonReaderObj = new JSONReader(new File(filePath));
        List<CreditCardEntry> result = jsonReaderObj.readFile(filePath);

        String name = result.get(11).getCardHolderName();
        String cardNumber = result.get(11).getCardNumber();
        Assert.assertEquals(name, "John Doe");
        Assert.assertEquals(cardNumber, "");
    }
}