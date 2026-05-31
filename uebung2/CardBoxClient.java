package uebung2;

public class CardBoxClient {

    public static void main(String[] args) {
        CardBox cardBox = CardBox.getInstance();
        PersonCardView view = new PersonCardView();

        try {
            cardBox.addPersonCard(new DeveloperCard(1, "Max", "Mustermann", true));
            cardBox.addPersonCard(new EnduserCard(2, "Erika", "Mustermann", false));
            cardBox.addPersonCard(new DeveloperCard(3, "Tom", "Beispiel", false));

            view.showContent(cardBox.getCurrentList());
        } catch (CardBoxException e) {
            System.out.println(e.getMessage());
        }
    }
}
