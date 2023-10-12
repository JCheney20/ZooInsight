package src;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class User_Table {

    private StringProperty firstName;

    public void setFirstName(String value) {
        firstNameProperty().set(value);
    }

    public String getFirstName() {
        return firstNameProperty().get();
    }

    public StringProperty firstNameProperty() {
        if (firstName == null)
            firstName = new SimpleStringProperty(this, "firstName");
        return firstName;
    }

    private StringProperty lastName;

    public void setLastName(String value) {
        lastNameProperty().set(value);
    }

    public String getLastName() {
        return lastNameProperty().get();
    }

    public StringProperty lastNameProperty() {
        if (lastName == null)
            lastName = new SimpleStringProperty(this, "lastName");
        return lastName;
    }

    public static void main(String[] args) {

    }
}
