package models;

/**
 * Mockup model for the backend database.
 */
public class Contact {
  private String firstName;
  private String lastName;
  private String telephone;
  private long id;

  /**
   * Creates a contact instance.
   * @param id the id.
   * @param telephone The first name.
   * @param firstName The last name.
   * @param lastName The telephone.
   */
  public Contact(long id, String telephone, String firstName, String lastName) {
    this.id = id;
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

  /**
   * Returns the Id.
   * @return the Id.
   */
  public long getId() {
    return id;
  }
}
