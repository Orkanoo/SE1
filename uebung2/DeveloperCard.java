package uebung2;
public class DeveloperCard implements PersonCard {

    private final String firstName;
    private final String lastName;
    private final int id;
    private final boolean hasEnoughCoffee;

    public DeveloperCard(int id, String firstName, String lastName, boolean hasEnoughCoffee) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.hasEnoughCoffee = hasEnoughCoffee;
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

    public boolean hasEnoughCoffee() {
        return hasEnoughCoffee;
    }

    @Override
    public String toString() {
        return "ID = " + id
                + ", Vorname = " + firstName
                + ", Nachname = " + lastName
                + ", hasEnoughCoffee = " + hasEnoughCoffee;
    }
}