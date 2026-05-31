package uebung3;

import java.io.Serializable;

public interface PersonCard extends Serializable {
    String getFirstName();
    String getLastName();

    // Die ID dient als Primaerschluessel zur Unterscheidung aller PersonCard-Objekte.
    // Die ID darf nicht innerhalb der CardBox-Klasse gesetzt werden.
    int getId();
}
