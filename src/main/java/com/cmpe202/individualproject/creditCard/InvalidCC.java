package com.cmpe202.individualproject.creditCard;

public class InvalidCC extends CreditCardEntry {
    public InvalidCC(String type, String cardNumber, String expirationDate, String cardHolderName) {
        super(type, cardNumber, expirationDate, cardHolderName);
    }
    public InvalidCC(String cardNumber, String expirationDate, String cardHolderName) {
        super(cardNumber, expirationDate, cardHolderName);
    }
}
