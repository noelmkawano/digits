import models.ContactDB;
import models.DietType;
import models.TelephoneType;
import play.Application;
import play.GlobalSettings;
import views.formdata.ContactFormData;

import java.util.ArrayList;
import java.util.List;

/**
 * Initializes test data for the application.
 */
public class Global extends GlobalSettings {

  @Override
  public void onStart(Application application) {
    super.onStart(application);

    ContactDB.addTelephoneType(new TelephoneType("Mobile"));
    ContactDB.addTelephoneType(new TelephoneType("Home"));
    ContactDB.addTelephoneType(new TelephoneType("Work"));
    ContactDB.addDietType(new DietType("Chicken"));
    ContactDB.addDietType(new DietType("Fish"));
    ContactDB.addDietType(new DietType("Beef"));
    ContactDB.addDietType(new DietType("Dairy"));
    ContactDB.addDietType(new DietType("Gluten"));

    List<String> testDiet = new ArrayList<>();
    testDiet.add(0, "Fish");
    testDiet.add(1, "Chicken");
    testDiet.add(2, "Beef");
    ContactDB.addContacts(new ContactFormData("Noel", "Kawano", "808-123-4567", "Mobile", testDiet));

    List<String> testDiet2 = new ArrayList<>();
    testDiet2.add(0, "Dairy");
    testDiet2.add(1, "Gluten");
    ContactDB.addContacts(new ContactFormData("Katherine", "Kawano", "808-123-4568", "Work", testDiet2));

    List<String> testDiet3 = new ArrayList<>();
    testDiet3.add(0, "Beef");
    ContactDB.addContacts(new ContactFormData("Noah", "Kawano", "808-123-4569", "Home", testDiet3));

    List<String> testDiet4 = new ArrayList<>();
    ContactDB.addContacts(new ContactFormData("Darryl", "Kawano", "808-123-4560", "Work", testDiet4));
  }
}
