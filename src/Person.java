public class Person extends Client {
    private String firstname;
    private String surname;
    private int idNumber;
    public Person(String firstname, String surname, int idNumber) {
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

    public int getIdNumber() {
        return idNumber;
    }
}
