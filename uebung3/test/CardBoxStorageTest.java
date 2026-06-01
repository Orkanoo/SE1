package uebung3.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import uebung3.*;

import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CardBoxStorageTest {

    @TempDir
    Path tempDir;

    @Test
    public void saveUndLoadSpeichertUndLaedtPersonCards() throws Exception {
        Path storageFile = tempDir.resolve("cardbox-test.dat");
        CardBox cardBox = CardBox.getInstance(storageFile.toString());

        cardBox.addPersonCard(new DeveloperCard(1, "Max", "Mustermann", true));
        cardBox.addPersonCard(new EnduserCard(2, "Erika", "Mustermann", false));
        cardBox.save();

        cardBox.deletePersonCard(1);
        cardBox.deletePersonCard(2);
        assertEquals(0, cardBox.size());

        cardBox.addPersonCard(new DeveloperCard(99, "Wird", "Geloescht", false));
        cardBox.load();

        List<PersonCard> loadedCards = cardBox.getCurrentList();
        assertEquals(2, loadedCards.size());
        assertEquals(1, loadedCards.get(0).getId());
        assertEquals("Max", loadedCards.get(0).getFirstName());
        assertEquals(2, loadedCards.get(1).getId());
        assertEquals("Erika", loadedCards.get(1).getFirstName());
    }

    @Test
    public void loadWirftCardboxStorageExceptionWennDateiFehlt() {
        CardBox cardBox = CardBox.getInstance(tempDir.resolve("nicht-vorhanden.dat").toString());

        assertThrows(CardboxStorageException.class, cardBox::load);
    }
}
