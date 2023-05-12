package com.cmpe202.individualproject.writer;

import com.cmpe202.individualproject.main.OutputData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CSVWriter implements IWriterStrategy {

    File outputFile;

    public CSVWriter() {
    }

    @Override
    public void writeToFile(List<OutputData> result, String outputFile) {
        FileWriter fileWriter = null;
        String File_header = "CardNumber,CardType";
        try {
            fileWriter = new FileWriter(outputFile);
            fileWriter.append(File_header.toString());
            fileWriter.append('\n');
            for (OutputData each : result) {

                System.out.println("CSV:  " + each.getCardNumber() + " " + each.getType() );
                
                fileWriter.append(each.getCardNumber().toString());
                fileWriter.append(',');
                fileWriter.append(each.getType());
                fileWriter.append('\n');
                fileWriter.flush();

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
