package com.cmpe202.individualproject.creditCard;

public class VisaCC extends CreditCardEntry {
    public VisaCC(String type, String cardNumber, String expirationDate, String cardHolderName) {
        super(type, cardNumber, expirationDate, cardHolderName);
    }
    public VisaCC(String cardNumber, String expirationDate, String cardHolderName) {
        super(cardNumber, expirationDate, cardHolderName);
    }
}
