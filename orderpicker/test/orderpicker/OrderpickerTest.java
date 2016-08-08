package orderpicker;

import org.apache.log4j.Logger;

import java.util.Scanner;

/**
 * Michelle Beckers
 * Datum: 8-8-2016
 * Time: 22:42
 */
public class OrderpickerTest {
    private final static Logger logger = Logger.getLogger(OrderpickerTest.class);

    public static void main(String[] args) {
        logger.info("Booting communications");

        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Press any key to exit.");
            scanner.nextLine();
        } catch (Exception e) {
            // do nothing, you just ended the program manually
        }

        logger.info("Shutting down");
    }
}
