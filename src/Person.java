/**
 * @author Andrzej Zamora
 */
public class Person extends Client {
    private String firstname;
    private String surname;
    private long idNumber;
    public Person(String firstname, String surname, long idNumber) {
        this.firstname = firstname;
        this.surname = surname;
        this.idNumber = idNumber;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getSurname() {
        return surname;
    }

    public long getIdNumber() {
        return idNumber;
    }
}
