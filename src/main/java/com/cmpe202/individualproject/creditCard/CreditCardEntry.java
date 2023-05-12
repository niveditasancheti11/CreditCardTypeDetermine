package com.cmpe202.individualproject.creditCard;
public class  CreditCardEntry implements ICreditCardEntry {
    private String cardNumber;
    private String expirationDate;
    private String cardHolderName;
    private String type = "";

    public CreditCardEntry(String type, String cardNumber, String expirationDate, String cardHolderName) {
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
        this.cardHolderName = cardHolderName;
        this.type = type;
    }

    public CreditCardEntry(String cardNumber, String expirationDate, String cardHolderName) {
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
        this.cardHolderName = cardHolderName;
    }

    public String getType() {
        return type;
    }


    public String getCardNumber() {
        return cardNumber;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                
                "cardNumber='" + cardNumber + '\'' +
                ", type='" + type + '\'' +
                ", expirationDate='" + expirationDate + '\'' +
                ", cardHolderName='" + cardHolderName + '\'' +
                '}';
    }
}