DESIGN PATTERN: FACTORY DESIGN PATTERN and STRATEGY DESIGN PATTERN
A design pattern is a formal way of documenting a solution to a design problem. Design patterns promotes reusability that leads to more robust and highly maintainable code. Java Design Patterns are divided into three categories

Creational
Structural
Behavioral

FACTORY PATTERN is Creational Design pattern.
It is used when we have a parent class with multiple child classes and based on input, we need to return one of the child-class.
This pattern takes out the responsibility of the instantiation of a class from the client program to the factory class.

#Factory Class: Here is the basic implementation of Factory Class.
```
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
        ...
       }
}
```

STRATEGY PATTERN is a behavioral design pattern that turns a set of behaviors into objects and makes them interchangeable inside original context object. The original object, called context, holds a reference to a strategy object. The context delegates executing the behavior to the linked strategy object.
#Strategy Class: Here is the basic implementation of Factory Class.

```
            IReaderStrategy filereader;
            IWriterStrategy filewriter = null;
            if (fileType.equalsIgnoreCase("csv")) {
                filereader = new CSVReader(new File(inputFile));
                filewriter = new CSVWriter();
                creditCardEntries = filereader.readFile(inputFile);
            } else if (fileType.equalsIgnoreCase("json")) {
                filereader = new JSONReader(new File(inputFile));
                filewriter = new JSONWriter();
                creditCardEntries = filereader.readFile(inputFile);
            } else if (fileType.equalsIgnoreCase("xml")) {
                System.out.println(" in xml ");
                filereader = new XMLReader(new File(inputFile));
                filewriter = new XMLWriter();
                creditCardEntries = filereader.readFile(inputFile);
            }

```


