package com.cmpe202.individualproject.creditcard;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import com.cmpe202.individualproject.main.*;
import com.cmpe202.individualproject.creditCard.CreditCardEntry;

class AmexTest {

    @Test
    void checkValidDiscover() {
        String cardNumber = "341000000000000";
        String expDate = "11/28";//LocalDate.of(2030, 6, 20);
        String name = "Richard";
        CreditCardEntry creditCard = CreditCardFactory.createCreditCard(new CreditCardEntry(cardNumber,expDate , name));
        String result = creditCard.getType();
        Assert.assertEquals(result, "AmericanExpress");
    }

}