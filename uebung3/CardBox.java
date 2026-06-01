package uebung3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class CardBox {

    // CR1: Singleton-Pattern. Es gibt genau eine CardBox-Instanz im Speicher.
    private static CardBox instance;

    private final List<PersonCard> personCards = new ArrayList<>();
    private String storageFileName;

    private CardBox() {
        this("cardbox.dat");
    }

    private CardBox(String storageFileName) {
        this.storageFileName = storageFileName;
    }

    public static CardBox getInstance() {
        if (instance == null) {
            instance = new CardBox();
        }
        return instance;
    }

    public static CardBox getInstance(String storageFileName) {
        if (instance == null) {
            instance = new CardBox(storageFileName);
        } else {
            instance.storageFileName = storageFileName;
        }
        return instance;
    }

    public void addPersonCard(PersonCard personCard) throws CardBoxException {
        for (PersonCard card : personCards) {
            if (card.getId() == personCard.getId()) {
                throw new CardBoxException(personCard.getId());
            }
        }
        personCards.add(personCard);
    }

    public String deletePersonCard(int id) {
        for (PersonCard card : new ArrayList<>(personCards)) {
            if (card.getId() == id) {
                personCards.remove(card);
                return "PersonCard mit ID " + id + " wurde gelöscht";
            }
        }
        return "PersonCard mit ID " + id + " wurde nicht gefunden";
    }

    public int size() {
        return personCards.size();
    }

    public List<PersonCard> getCurrentList() {
        return new ArrayList<>(personCards);
    }

    public void save() throws CardboxStorageException {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(storageFileName))) {
            outputStream.writeObject(personCards);
        } catch (IOException e) {
            throw new CardboxStorageException("Speichern der CardBox in der Datei '" + storageFileName + "' ist fehlgeschlagen.", e);
        }
    }

    @SuppressWarnings("unchecked")
    public void load() throws CardboxStorageException {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(storageFileName))) {
            Object object = inputStream.readObject();

            if (!(object instanceof List<?>)) {
                throw new CardboxStorageException("Die Datei '" + storageFileName + "' enthält keine Liste von PersonCard-Objekten.");
            }

            List<?> loadedObjects = (List<?>) object;
            List<PersonCard> loadedPersonCards = new ArrayList<>();
            for (Object loadedObject : loadedObjects) {
                if (!(loadedObject instanceof PersonCard)) {
                    throw new CardboxStorageException("Die Datei '" + storageFileName + "' enthält mindestens ein Objekt, das keine PersonCard ist.");
                }
                loadedPersonCards.add((PersonCard) loadedObject);
            }

            personCards.clear();
            personCards.addAll(loadedPersonCards);
        } catch (IOException e) {
            throw new CardboxStorageException("Laden der CardBox aus der Datei '" + storageFileName + "' ist fehlgeschlagen.", e);
        } catch (ClassNotFoundException e) {
            throw new CardboxStorageException("Beim Laden wurde eine unbekannte Klasse gefunden.", e);
        }
    }
}
