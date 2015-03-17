package models;

/**
 * Mockup model for the backend database.
 */
public class Contact {
  private String firstName;
  private String lastName;
  private String telephone;

  /**
   * Creates a contact instance.
   * @param telephone The first name.
   * @param firstName The last name.
   * @param lastName The telephone.
   */
  public Contact(String telephone, String firstName, String lastName) {
    this.telephone = telephone;
    this.firstName = firstName;
    this.lastName = lastName;
  }

  /**
   * Returns first name.
   * @return the first name.
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * Returns the last name.
   * @return the last name.
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * Returns the telephone number.
   * @return the telephone number.
   */
  public String getTelephone() {
    return telephone;
  }
}
