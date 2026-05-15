package uebung2;

public class EnduserCard implements PersonCard {

    private final String firstName;
    private final String lastName;
    private final int id;
    private final boolean isHungry;

    public EnduserCard(int id, String firstName, String lastName, boolean isHungry) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isHungry = isHungry;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public int getId() {
        return id;
    }

    public boolean isHungry() {
        return isHungry;
    }

    @Override
    public String toString() {
        return "ID = " + id
                + ", Vorname = " + firstName
                + ", Nachname = " + lastName
                + ", isHungry = " + isHungry;
    }
}