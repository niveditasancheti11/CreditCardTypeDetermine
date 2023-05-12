package com.cmpe202.individualproject.creditcard;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import com.cmpe202.individualproject.main.*;
import com.cmpe202.individualproject.creditCard.CreditCardEntry;

class InvalidCCTest {

    @Test
    void checkInValidCardWithNull() {
        String cardNumber = "";
        String expDate = "11/28";//LocalDate.of(2030, 6, 20);
        String name = "Richard";
        CreditCardEntry creditCard = CreditCardFactory.createCreditCard(new CreditCardEntry(cardNumber,expDate , name));
        String result = creditCard.getType();
        Assert.assertEquals(result, "Invalid: empty/null card number");
    }

    @Test
    void checkInValidCardWithExceedingDigits() {
        String cardNumber = "1234567890123456789012";
        String expDate = "11/28";//LocalDate.of(2030, 6, 20);
        String name = "Richard";
        CreditCardEntry creditCard = CreditCardFactory.createCreditCard(new CreditCardEntry(cardNumber,expDate , name));
        String result = creditCard.getType();
        Assert.assertEquals(result, "Invalid: more than 19 digits");
    }

    @Test
    void checkInValidCardWithNotPossibleCard() {
        String cardNumber = "3601112345678789";
        String expDate = "11/28";//LocalDate.of(2030, 6, 20);
        String name = "Richard";
        CreditCardEntry creditCard = CreditCardFactory.createCreditCard(new CreditCardEntry(cardNumber,expDate , name));
        String result = creditCard.getType();
        Assert.assertEquals(result, "Invalid: Not a possible card number");
    }

    @Test
    void checkInValidCardWithNonNumbers() {
        String cardNumber = "6011*890HJrt6789";
        String expDate = "11/28";//LocalDate.of(2030, 6, 20);
        String name = "Richard";
        CreditCardEntry creditCard = CreditCardFactory.createCreditCard(new CreditCardEntry(cardNumber,expDate , name));
        String result = creditCard.getType();
        Assert.assertEquals(result, "Invalid: non numeric characters");
    }

}