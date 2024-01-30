// Person class
class Person {
    private String name;
    private String email;
    private String dateOfBirth;

    public Person(String name, String email, String dateOfBirth) {
        this.name = name;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public String getDateOfBirth() {
        return dateOfBirth;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public void displayPersonalData() {
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Date of Birth: " + dateOfBirth);
    }
    @Override
    public String toString() {
        return "Name: " + name +
                "\nEmail: " + email +
                "\nDate of Birth: " + dateOfBirth;
    }
}
