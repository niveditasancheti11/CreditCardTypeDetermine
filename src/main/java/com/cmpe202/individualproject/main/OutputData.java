package com.cmpe202.individualproject.main;

public class OutputData {
    String cardNumber;
    String type;

    public OutputData() {
    }

    public OutputData(String cardNumber, String type) {
        this.cardNumber = cardNumber;
        this.type = type;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
