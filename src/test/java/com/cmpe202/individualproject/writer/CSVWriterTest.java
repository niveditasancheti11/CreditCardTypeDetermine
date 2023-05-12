package com.cmpe202.individualproject.writer;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import com.cmpe202.individualproject.main.OutputData;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

class CSVWriterTest {

    @Test
    void checkCSVWrite() {
        String cardNumber = "5410000000000000";
        String cardType = "MasterCard";
        CSVWriter csvWriterObj = new CSVWriter();
        List<OutputData> result = new ArrayList<>();
        result.add(new OutputData(cardNumber, cardType));
        String path = "src/test/java/sampleFiles/json_output_test.json";
        csvWriterObj.writeToFile(result, path);
        File file = new File(path);

        Assert.assertEquals(file.exists(), true);
        Assert.assertEquals(cardNumber, "5410000000000000");
        Assert.assertEquals(cardType, "MasterCard");

    }
}