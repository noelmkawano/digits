package controllers;

import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.formdata.ContactFormData;
import views.html.Index;
import views.html.newContact;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Provides controllers for this application.
 */
public class Application extends Controller {


  private static void writeToFile(String textToWrite) {
    final String outputPath = "C:\\Users\\NOEL\\Desktop\\Data.txt";

    try {
      FileWriter fileWriter = new FileWriter(outputPath);
      fileWriter.write(textToWrite);
      fileWriter.close();
      System.out.println("Success!");
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
  }

  /**
   * Returns the home page.
   *
   * @return The resulting home page.
   */
  public static Result index() {
    return ok(Index.render("Welcome to the home page."));
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
    ContactFormData data = formData.get();
    System.out.printf("Got data: %s %s %s %s %n", data.eq, data.wave, data.sen, data.trail);
    writeToFile(data.eq + "\n" + data.wave + "\n" + data.sen + "\n" + data.trail);
    return ok(newContact.render(formData));
  }


}