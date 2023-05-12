package com.cmpe202.individualproject.creditCard;

public class MasterCC extends CreditCardEntry {
    public MasterCC(String type, String cardNumber, String expirationDate, String cardHolderName) {
        super(type, cardNumber, expirationDate, cardHolderName);
    }
    public MasterCC(String cardNumber, String expirationDate, String cardHolderName) {
        super(cardNumber, expirationDate, cardHolderName);
    }
}
