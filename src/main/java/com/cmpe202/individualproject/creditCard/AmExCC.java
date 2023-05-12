package com.cmpe202.individualproject.creditCard;

public class AmExCC extends CreditCardEntry {
    public AmExCC(String type, String cardNumber, String expirationDate, String cardHolderName) {
        super(type, cardNumber, expirationDate, cardHolderName);
    }
    public AmExCC(String cardNumber, String expirationDate, String cardHolderName) {
        super(cardNumber, expirationDate, cardHolderName);
    }

}
