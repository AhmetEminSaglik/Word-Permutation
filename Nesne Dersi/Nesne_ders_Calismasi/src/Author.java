
public class Author {

    private String name;
    private String email;
    private char gender;

    public Author(String name, String email, char gender) {
        this.name = name;
        this.email = email;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        if (gender == 'm') {
            System.out.println("Gender is : Male");
        } else if (gender == 'f') {
            System.out.println("Gender is : Female");

        } else {
            System.out.println("!!! Unvalid gender ");
        }
        this.gender = gender;
    }

    @Override
    public String toString() {
        String gender = "";
        if (this.gender == 'm') {
            gender = "Male";
        } else {
            gender = "Female";
        }
        String bilgiler = "Author Name : " + getName()
                + "\nAuthor Email  : " + getEmail()
                + "\nAuthor Gender : " + gender;//return "Author{" + "name=" + name + ", email=" + email + ", gender=" + gender + '}';
        //System.out.println(String.format("Adi {0}, E-mail {1}, Gender {2}", name, email, gender));
        return bilgiler;
    }

}
