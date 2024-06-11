/**
 * A class that represents a single student
 *
 * @author Darvensky Daniel
 * @version 1.0 Build 2024.02.25
 */
public class Student {

    /**
     * The student's first name
     */
    private String firstName;

    /**
     * The student's last name
     */
    private String lastName;

    /**
     * The student's address
     */
    private String address;

    /**
     * The student's phone number
     */
    private String phone;

    /**
     * The student's email address
     */
    private String email;

    /**
     * The student's smith union box number
     */
    private int suBox;

    /**
     * Get the student's first name (a getter method)
     * @return The student's first name
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * Get the student's last name (a getter method)
     * @return The student's last name
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * Get the student's address (a getter method)
     * @return The student's address
     */
    public String getAddress() {
        return this.address;
    }

    /**
     * Get the student's phone number (a getter method)
     * @return The student's phone number
     */
    public String getPhone() {
        return this.phone;
    }

    /**
     * Get the student's Smith Union box number (a getter method)
     * @return The student's Smith Union box number
     */
    public int getSuBox() {return this.suBox;}

    /**
     * Construct a new student
     *
     * @param student The student's information as a string
     */
    public Student(String student) {
        //Splits the string by "|" into an array
        String[] info = student.trim().split("\\|");
        //Splits the string by " " into an array
        String[] names = student.split(" ");
        //Save first two elements of the names array into the instance variables
        this.firstName = names[0].trim();
        this.lastName = names[1].trim();
        //Save elements of the info array into the instance variables
        this.address = info[1].trim();
        this.phone = info[2].trim();
        this.email = info[3].trim();
        this.suBox = Integer.parseInt(info[4].trim());
    }

    /**
     * Creates a string representation of the student
     *
     * @return The string representation of the student
     */
    @Override
    public String toString() {
        return firstName + " " + lastName + " | " + address + " | " + phone + " | " + email +
                " | " + suBox;
    }
}
