package com.cmpe202.individualproject.writer;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import com.cmpe202.individualproject.main.OutputData;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

class JSONWriterTest {

    @Test
    void checkJSONWrite() {
        String cardNumber = "5410000000000000";
        String cardType = "MasterCard";
        JSONWriter jsonWriterObj = new JSONWriter();
        List<OutputData> result = new ArrayList<>();
        result.add(new OutputData(cardNumber, cardType));
        // OutputEntry result = new OutputEntry(cardNumber,cardType);
        String path = "src/test/java/sampleFiles/json_output_test.json";
        jsonWriterObj.writeToFile(result, path);
        File file = new File(path);

        Assert.assertEquals(file.exists(), true);
        Assert.assertEquals(cardNumber, "5410000000000000");
        Assert.assertEquals(cardType, "MasterCard");

    }
}