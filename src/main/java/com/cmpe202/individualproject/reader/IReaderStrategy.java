package com.cmpe202.individualproject.reader;

import java.util.List;

import com.cmpe202.individualproject.creditCard.CreditCardEntry;

public interface IReaderStrategy {

    List<CreditCardEntry> readFile(String inputFile);
    // TODO Auto-generated method stub

}
