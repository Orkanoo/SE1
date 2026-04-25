package uebung1.businesslogic;

public class NumberTransformerFactory {

    public static NumberTransformer createRomanNumberTransformer() {
        return new RomanNumberTransformer();
    }
}
