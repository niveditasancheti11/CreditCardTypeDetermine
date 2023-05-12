package com.cmpe202.individualproject.creditCard;
public interface ICreditCardEntry {
    String cardNumber = "";
    String expirationDate = "";
    String cardHolderName = "";
    String type = "";

    //public ICreditCardEntry(String type, String cardNumber, String expirationDate, String cardHolderName);
        
    public String getType();

    public String getCardNumber();

    public String getExpirationDate();

    public String getCardHolderName();

    public String toString();
}