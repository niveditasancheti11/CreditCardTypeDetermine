package com.cmpe202.individualproject.writer;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import com.cmpe202.individualproject.main.OutputData;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

class XMLWriterTest {

    @Test
    void checkXMLWrite() {
        String cardNumber = "5410000000000000";
        String cardType = "MasterCard";
        XMLWriter xmlWriterObj = new XMLWriter();
        List<OutputData> result = new ArrayList<>();
        result.add(new OutputData(cardNumber, cardType));
        String path = "src/test/java/sampleFiles/json_output_test.json";
        xmlWriterObj.writeToFile(result, path);

        File file = new File(path);

        Assert.assertEquals(file.exists(), true);

        Assert.assertEquals(cardNumber, "5410000000000000");
        Assert.assertEquals(cardType, "MasterCard");

    }

}