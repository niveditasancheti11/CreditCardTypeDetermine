package com.cmpe202.individualproject.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import com.cmpe202.individualproject.creditCard.*;

public class CSVReader implements IReaderStrategy {

    File file;

    public CSVReader() {
    }

    public CSVReader(File file) {
        this.file = file;
    }

    @Override
    public List<CreditCardEntry> readFile(String inputFile) {

        BufferedReader br;
        List<CreditCardEntry> entries = new ArrayList<>();
        //DateTimeFormatter df = DateTimeFormatter.ofPattern("MM/dd");
        
        //SimpleDateFormat sdf = new SimpleDateFormat("MM/dd");
        try {
            br = new BufferedReader(new FileReader(file));
            String line;
            line = br.readLine();
            if (line == null) throw new IllegalArgumentException("File is empty");
            while ((line = br.readLine()) != null) {
                String[] entry = line.split(",");
                if (entry.length > 4) throw new ArrayIndexOutOfBoundsException();
                //System.out.println((entry[0]));
                
                //Long cardNumber = Long.parseLong(entries[0]);
                String cardNumber = entry[0];

                String dateEntry = entry[1];
                String nameOfCardHolder = entry[2];

                CreditCardEntry ccEntry = new CreditCardEntry(cardNumber, dateEntry, nameOfCardHolder);
                entries.add(ccEntry);
            }
            br.close();
            return entries;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return entries;
    }
}

