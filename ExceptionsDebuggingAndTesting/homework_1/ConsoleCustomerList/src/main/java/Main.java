import java.security.CodeSigner;
import java.util.Scanner;

public class Main {
    private static final String ADD_COMMAND = "add Василий Петров " +
            "vasily.petrov@gmail.com +79215637722";
    private static final String COMMAND_EXAMPLES = "\t" + ADD_COMMAND + "\n" +
            "\tlist\n\tcount\n\tremove Василий Петров";
    private static final String COMMAND_ERROR = "Wrong command! Available command examples: \n" +
            COMMAND_EXAMPLES;
    private static final String helpText = "Command examples:\n" + COMMAND_EXAMPLES;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CustomerStorage executor = new CustomerStorage();

        while (true) {
            try {
                String command = scanner.nextLine();
                String[] tokens = command.split("\\s+", 2);

                if (tokens[0].equals("add")) {
                    executor.addCustomer(tokens[1]);
                } else if (tokens[0].equals("list")) {
                    executor.listCustomers();
                    CustomerStorage.LOGGER.info(CustomerStorage.HISTORY_QUERIES, "Command: " + tokens[0]);
                } else if (tokens[0].equals("remove")) {
                    executor.removeCustomer(tokens[1]);
                    CustomerStorage.LOGGER.info(CustomerStorage.HISTORY_QUERIES, "Command: " + tokens[0] + " " + tokens[1]);
                } else if (tokens[0].equals("count")) {
                    System.out.println("There are " + executor.getCount() + " customers");
                    CustomerStorage.LOGGER.info(CustomerStorage.HISTORY_QUERIES, "Command: " + tokens[0]);
                } else if (tokens[0].equals("help")) {
                    System.out.println(helpText);
                    CustomerStorage.LOGGER.info(CustomerStorage.HISTORY_QUERIES, "Command: " + tokens[0]);
                } else {
                    System.out.println(COMMAND_ERROR);
                    CustomerStorage.LOGGER.info(CustomerStorage.HISTORY_ERRORS, "Wrong format text: " + tokens[0]);
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
