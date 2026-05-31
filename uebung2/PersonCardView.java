package uebung2;

import java.util.List;

public class PersonCardView {

    public void showContent(List<PersonCard> liste) {
        for (PersonCard card : liste) {
            System.out.println(card);
        }
    }
}
