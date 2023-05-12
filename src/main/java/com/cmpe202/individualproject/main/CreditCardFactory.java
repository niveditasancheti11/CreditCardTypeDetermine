package com.cmpe202.individualproject.main;

import com.cmpe202.individualproject.creditCard.AmExCC;
import com.cmpe202.individualproject.creditCard.DiscoverCC;
import com.cmpe202.individualproject.creditCard.InvalidCC;
import com.cmpe202.individualproject.creditCard.MasterCC;
import com.cmpe202.individualproject.creditCard.VisaCC;
import com.cmpe202.individualproject.creditCard.CreditCardEntry;
public class CreditCardFactory {
    public static CreditCardEntry createCreditCard(CreditCardEntry creditCardRecord) {
        String cardNumber = creditCardRecord.getCardNumber();
        String expirationDate = creditCardRecord.getExpirationDate();
        String cardHolderName = creditCardRecord.getCardHolderName();

        if(isNullOrEmpty(cardNumber))
            return new InvalidCC("Invalid: empty/null card number", cardNumber, expirationDate, cardHolderName);
        else if(exceeds19Digit(cardNumber))
            return new InvalidCC("Invalid: more than 19 digits", cardNumber, expirationDate, cardHolderName);
        else if(hasAplhabets(cardNumber))
            return new InvalidCC("Invalid: non numeric characters", cardNumber, expirationDate, cardHolderName);   
        else if (isVisaCC(cardNumber)) 
            return new VisaCC("Visa", cardNumber, expirationDate, cardHolderName);
        else if (isMasterCC(cardNumber)) 
            return new MasterCC("MasterCard", cardNumber, expirationDate, cardHolderName);
        else if (isAmExCC(cardNumber)) 
            return new AmExCC("AmericanExpress", cardNumber, expirationDate, cardHolderName);
        else if (isDiscoverCC(cardNumber)) 
            return new DiscoverCC("Discover", cardNumber, expirationDate, cardHolderName);
        else 
            return new InvalidCC("Invalid: Not a possible card number", cardNumber, expirationDate, cardHolderName);
        
    }
    
    private static boolean isNullOrEmpty(String cardNumber) {
        return cardNumber == null || cardNumber.trim().equals("") || cardNumber.length() == 0;
    }
    
    private static boolean exceeds19Digit(String cardNumber) {
        return cardNumber.length() > 19;
    }

    private static boolean hasAplhabets(String cardNumber) {
        return !(cardNumber.matches("[0-9]+"));
    }


    private static boolean isVisaCC(String cardNumber) {
        return cardNumber.length() == 13 || cardNumber.length() == 16 && cardNumber.charAt(0) == '4';
    }

    private static boolean isMasterCC(String cardNumber) {
        return cardNumber.length() == 16 && cardNumber.charAt(0) == '5' && cardNumber.charAt(1) >= '1' && cardNumber.charAt(1) <= '5';
    }

    private static boolean isAmExCC(String cardNumber) {
        return cardNumber.length() == 15 && cardNumber.charAt(0) == '3' && (cardNumber.charAt(1) == '4' || cardNumber.charAt(1) == '7');
    }

    private static boolean isDiscoverCC(String cardNumber) {
        return cardNumber.length() == 16 && cardNumber.startsWith("6011");
    }
}

