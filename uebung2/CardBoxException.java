package uebung2;
public class CardBoxException extends Exception {

    public CardBoxException(int id) {
        super("Das CardBox-Objekt mit der ID " + id + " ist bereits vorhanden");
    }
}