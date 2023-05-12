package com.cmpe202.individualproject.creditCard;

public class DiscoverCC extends CreditCardEntry {
    public DiscoverCC(String type, String cardNumber, String expirationDate, String cardHolderName) {
        super(type, cardNumber, expirationDate, cardHolderName);
    }
    public DiscoverCC(String cardNumber, String expirationDate, String cardHolderName) {
        super(cardNumber, expirationDate, cardHolderName);
    }
}