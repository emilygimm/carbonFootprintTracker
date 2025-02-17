

/**
 * A class that represents a user.
 *
 * @author egimm
 */
public class User {
    private String firstName;
    private String lastName;
    private String userName;



    /**
     * Instantiates a new user.
     *
     * @param firstName users first name
     * @param lastName  users last name
     * @param userName  users username
     */
    public User(String firstName, String lastName, String userName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;

    }


    /**
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }


    /**
     * Sets first name.
     *
     * @param firstName the first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    /**
     * Sets last name.
     *
     * @param lastName the last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    /**
     * Gets username.
     *
     * @return the username
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets username.
     *
     * @param userName the username
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }
}
