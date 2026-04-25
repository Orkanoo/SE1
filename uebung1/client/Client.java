package uebung1.client;

import uebung1.businesslogic.NumberTransformer;
import uebung1.businesslogic.NumberTransformerFactory;

public class Client {

    public void printTransformation(int number) {
        NumberTransformer transformer =
                NumberTransformerFactory.createRomanNumberTransformer();

        String result = transformer.transformNumber(number);

        System.out.println("Die römische Schreibweise der Zahl "
                + number + " ist: " + result);
    }
}
