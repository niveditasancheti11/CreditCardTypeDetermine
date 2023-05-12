package com.cmpe202.individualproject.reader;

import com.cmpe202.individualproject.creditCard.CreditCardEntry;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class JSONReader implements IReaderStrategy {
    File file;

    public JSONReader() {
    }

    public JSONReader(File file) {
        this.file = file;
    }

    @Override
    public List<CreditCardEntry> readFile(String filePath) {
        System.out.println("Reading JSON file: " + filePath);

        List<CreditCardEntry> creditCards = new ArrayList<>();

        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader(filePath));
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray cardsArray = (JSONArray) jsonObject.get("cards");

            for (Object cardObj : cardsArray) {
                JSONObject cardJson = (JSONObject) cardObj;
                String cardNumber = (String) cardJson.get("cardNumber");
                if (cardNumber == null || cardNumber.isEmpty()) {
                    cardNumber = "";
                }
                String cardHolderName = (String) cardJson.get("cardHolderName");
                String expiryDate = (String) cardJson.get("expirationDate");

                CreditCardEntry creditCard = new CreditCardEntry(cardNumber, expiryDate, cardHolderName);
                creditCards.add(creditCard);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return creditCards;
    }

    public List<CreditCardEntry> readFile1(String inputFile) {
        FileReader fr;
        List<CreditCardEntry> result = new ArrayList<>();
        // String jsonFile = file.getAbsolutePath();
        List<String> cardDetails;
        // SimpleDateFormat sdf = new SimpleDateFormat("MM/dd");

        // Date expDate = new Date();
        try {
            fr = new FileReader(file);
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(fr);
            // Object obj = parser.parse(fr);
            System.out.println(jsonObject.get("cards"));

            // JSONObject jsonObject = (JSONObject) obj;
            JSONArray cards = (JSONArray) jsonObject.get("cards");

            for (int i = 0; i < cards.size(); i++) {
                // System.out.println(cards.get(i));
                cardDetails = new ArrayList<>();
                String entries = cards.get(i).toString();
                String[] eachCardEntry = entries.split(",");
                for (String each : eachCardEntry) {
                    String[] split1 = each.split(":");
                    String replace1 = split1[1].replaceAll("}", "");
                    String replace2 = replace1.replaceAll("\\\\", "");
                    cardDetails.add(replace2);
                }

                for (String string : cardDetails) {
                    System.out.println(string);
                }
                String a = "";
                if (cardDetails.size() < 3) {
                    a = "";
                    String name = cardDetails.get(0).replaceAll("\"", "");
                    String b = cardDetails.get(1).replaceAll("\"", "");
                    // Date eDate = sdf.parse(String.valueOf(b));
                    result.add(new CreditCardEntry(a, b, name));
                } else {
                    a = cardDetails.get(1).replaceAll("\"", "");

                    // System.out.println(a + "
                    // ===================================================== ");
                    String b = cardDetails.get(2).replaceAll("\"", "");
                    // Date eDate = sdf.parse(String.valueOf(b));
                    // System.out.println(b + "
                    // ===================================================== ");

                    String name = cardDetails.get(0).replaceAll("\"", "");
                    // System.out.println(name + " " + a.length() + " ------- " + a + " " + b);

                    // Long cNumber = Long.parseLong(a);
                    String cNumber = a;

                    result.add(new CreditCardEntry(cNumber, b, name));
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
