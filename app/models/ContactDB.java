package models;

import views.formdata.ContactFormData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A mockup internal in-memory data structure for contacts.
 */
public class ContactDB {
  private static Map<Long, Contact> contacts = new HashMap<>();
  private static long currentId = 1;

  /**
   * Creates a Contact instance from form data and adds it to internal contacts DB.
   * If form ID was zero, create an ID for this new contact before saving. Otherwise update the pre-existing entry.
   * @param formData The form data.
   */
  public static void addContact(ContactFormData formData) {
    long idVal = (formData.id == 0) ? currentId++ : formData.id;
    Contact contact = new Contact(idVal, formData.firstName, formData.lastName, formData.telephone, formData.address);
    contacts.put(idVal, contact);
  }

  /**
   * Deletes the list of contacts.
   * @return nothing.
   * @param formData The form data.
   */
  public static Contact deleteContact(ContactFormData formData) {
    long idVal = (formData.id == 0) ? currentId++ : formData.id;
    Contact contact = new Contact(idVal, null, null, null, null);
    contacts.put(idVal, contact);
    return contact;
  }

  /**
   * Returns the contact associated with id, or throws a RuntimeException if not found.
   * @param id the id.
   * @return the contact.
   */
  public static Contact getContact(long id) {
    Contact contact = contacts.get(id);
    if (contact == null) {
      throw new RuntimeException("Could not find the contact with associated id.");
    }
    return contact;
  }

  /**
   * Returns the list of contacts.
   * @return The contact list
   */
  public static List<Contact> getContacts() {
    return new ArrayList<>(contacts.values());
  }

}
