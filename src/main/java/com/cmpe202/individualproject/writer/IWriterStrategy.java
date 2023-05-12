
package com.cmpe202.individualproject.writer;

import com.cmpe202.individualproject.main.OutputData;

import java.util.List;

public interface IWriterStrategy {

    public void writeToFile(List<OutputData> result, String outputFile);
}

