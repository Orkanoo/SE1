package uebung1.businesslogic;

public abstract class AbstractNumberTransformer implements NumberTransformer {

    protected static final String error = "Fehler: Es sind nur Zahlen zwischen 1 und 3000 erlaubt.";
    @Override

    public String transformNumber(int number) {

        if (number < 1 || number > 3000) {

            return error;

        }
        return doTransform(number);
    }

    protected abstract String doTransform(int number);

}
