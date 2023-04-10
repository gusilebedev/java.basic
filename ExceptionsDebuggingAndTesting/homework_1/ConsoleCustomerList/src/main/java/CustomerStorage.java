import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;
import java.util.HashMap;
import java.util.Map;

public class CustomerStorage {
    private final Map<String, Customer> storage;

    private String formatPhone = "[+]{0,1}[7-8][0-9]{3}[0-9]{3}[0-9]{2}[0-9]{2}";
    private String formatEmail = "\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*\\.\\w{2,4}";

    public static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static final Marker HISTORY_QUERIES = MarkerManager.getMarker("HISTORY_QUERIES");
    public static final Marker HISTORY_ERRORS = MarkerManager.getMarker("HISTORY_ERRORS");

    public CustomerStorage() {
        storage = new HashMap<>();
    }

    public void addCustomer(String data) {
        final int INDEX_NAME = 0;
        final int INDEX_SURNAME = 1;
        final int INDEX_EMAIL = 2;
        final int INDEX_PHONE = 3;

        String[] components = data.split("\\s+");
        if (components.length != 4) {
            LOGGER.info(HISTORY_ERRORS, "Wrong format text: " + data);
            throw new IllegalArgumentException("Wrong format text. Correct format:\n" + "add Василий Петров vasily.petrov@gmail.com +79215637722");
        }
        if (components[2].matches(formatEmail) == false) {
            LOGGER.info(HISTORY_ERRORS, "Wrong format email: " + components[2]);
            throw new IllegalArgumentException("Wrong format email. Correct format:\n" + "vasily.petrov@gmail.com");
        }
        if (components[3].matches(formatPhone) == false) {
            LOGGER.info(HISTORY_ERRORS, "Wrong format phone: " + components[3]);
            throw new IllegalArgumentException("Wrong format phone. Correct format:\n" + "+79215637722");
        }
        String name = components[INDEX_NAME] + " " + components[INDEX_SURNAME];
        storage.put(name, new Customer(name, components[INDEX_PHONE], components[INDEX_EMAIL]));
        LOGGER.info(HISTORY_QUERIES, "Contact saved: " + name + " " + components[INDEX_PHONE] + " " + components[INDEX_EMAIL]);
    }

    public void listCustomers() {
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name) {
        storage.remove(name);
    }

    public Customer getCustomer(String name) {
        return storage.get(name);
    }

    public int getCount() {
        return storage.size();
    }
}