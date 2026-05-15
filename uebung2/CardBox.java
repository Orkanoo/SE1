package uebung2;
import java.util.ArrayList;
import java.util.List;

public class CardBox {

    private final List<PersonCard> personCards = new ArrayList<>();

    public void addPersonCard(PersonCard personCard) throws CardBoxException {
        for (PersonCard card : personCards) {
            if (card.getId() == personCard.getId()) {
                throw new CardBoxException(personCard.getId());
            }
        }

        personCards.add(personCard);
    }

    public String deletePersonCard(int id) {
        for (PersonCard card : personCards) {
            if (card.getId() == id) {
                personCards.remove(card);
                return "PersonCard mit ID " + id + " wurde gelöscht";
            }
        }

        return "PersonCard mit ID " + id + " wurde nicht gefunden";
    }

    public void showContent() {
        for (PersonCard card : personCards) {
            System.out.println(card);
        }
    }

    public int size() {
        return personCards.size();
    }
}