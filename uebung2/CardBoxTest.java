package uebung2;

public class CardBoxTest {

    public static void main(String[] args) {
        CardBox cardBox = new CardBox();

        PersonCard developer = new DeveloperCard(1, "Max", "Mustermann", true);
        PersonCard enduser = new EnduserCard(2, "Erika", "Mustermann", false);
        PersonCard duplicateDeveloper = new DeveloperCard(1, "Tom", "Mustermann", false);

        try {
            cardBox.addPersonCard(developer);
            cardBox.addPersonCard(enduser);

            System.out.println("Anzahl nach dem Hinzufügen: " + cardBox.size());
            cardBox.showContent();

            cardBox.addPersonCard(duplicateDeveloper);
        } catch (CardBoxException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(cardBox.deletePersonCard(2));
        System.out.println("Anzahl nach dem Löschen: " + cardBox.size());

        System.out.println(cardBox.deletePersonCard(99));

        cardBox.showContent();
    }
}
