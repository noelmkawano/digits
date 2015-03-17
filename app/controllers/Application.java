package controllers;

import models.ContactDB;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.formdata.ContactFormData;
import views.html.Index;
import views.html.newContact;

/**
 * Provides controllers for this application.
 */
public class Application extends Controller {

  /**
   * Returns the home page.
   *
   * @return The resulting home page.
   */
  public static Result index() {
    return ok(Index.render(ContactDB.getContacts()));
  }

  /**
   * Returns newContact, a simple example of a second page to illustrate navigation.
   *
   * @return The newContact.
   */
  public static Result newContact() {
    Form<ContactFormData> formData = Form.form(ContactFormData.class);
    return ok(newContact.render(formData));

  }

  /**
   * Returns a postContact.
   * @return the postContact.
   */
  public static Result postContact() {
    Form<ContactFormData> formData = Form.form(ContactFormData.class).bindFromRequest();
    if (formData.hasErrors()) {
      System.out.println("Found errors");
      return badRequest(newContact.render(formData));
    }
    else {
      ContactFormData data = formData.get();
      ContactDB.addContact(data);
      System.out.printf("Got data: %s %s %s %n", data.firstName, data.lastName, data.telephone);
      return ok(newContact.render(formData));
    }
  }
}