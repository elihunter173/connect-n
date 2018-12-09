import java.util.Scanner;
import java.util.InputMismatchException;
import java.io.PrintStream;

/**
 * This class contains various utility functions that are used
 * throughout the Connect-N game but aren't related to specific classes.
 * @author Eli W. Hunter
 */
public class Utils {

    /**
     * Determines if a string is a parsable int.
     * @param str The string to be checked.
     * @return True if the string (str) does contain a parsable int.
     */
    public static boolean isInt(String str) {
        try {
            Integer.parseInt(str);
            return true;

        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * The default error message to be displayed if the user doesn't input
     * an integer.
     */
    public static String INT_ERROR_MESSAGE = "That is not an integer.";

    /**
     * Requests a int from the given input by printing the given output.
     * If the input is not a String, it displays an error message and recurses.
     * @param prompt The String to be displayed.
     * @param input The Scanner object from which input will be taken.
     * @param output The PrintSream object where all the messages and
     *     error messages will be displayed.
     * @return The integer that was successfuly received.
     */
    public static int getIntReprompting(String prompt, Scanner input, PrintStream output) {
        int answer;
        try {
            output.print(prompt);
            answer = input.nextInt();
        } catch (InputMismatchException e) {
            input.next(); // discard the failed input
            output.println(INT_ERROR_MESSAGE);
            return getIntReprompting(prompt, input, output); // try again
        }
        return answer;
    }

    /**
     * Requests a int from the given input by printing the given output.
     * If the input is not a String, it prints the given error message and
     * recurses.
     * @param prompt The String to be displayed as a prompt.
     * @param error The String to be displayed as an error message.
     * @param input The Scanner object from which input will be taken.
     * @param output The PrintSream object where all the messages and
     *     error messages will be displayed.
     * @return The integer that was successfuly received.
     */
    public static int getIntReprompting(String prompt, String error, Scanner input, PrintStream output) {
        int answer;
        try {
            output.print(prompt);
            answer = input.nextInt();
        } catch (InputMismatchException e) {
            input.next(); // discard the failed input
            output.println(error);
            return getIntReprompting(prompt, error, input, output); // try again
        }
        return answer;
    }

    /**
     * Repeats the given String a given number of times (count). This is done
     * because not all Java versions support stringObject.repeat(count).
     * @param str The String to be repeated.
     * @param count The number of times for the string (str) to be repeated.
     * @return The inputted string repeated count number of times.
     */
    public static String repeatString(String str, int count) {
        String repeatedString = "";
        for (int i = 0; i < count; i++) {
            repeatedString += str;
        }
        return repeatedString;
    }

    /**
     * Determines whether a String Array contains the given String.
     * @param array The String Array to be checked for the given String.
     * @param compareString The string to be searched for.
     * @return True if the String Array contains the given compare string.
     */
    public static boolean containsString(String[] array, String compareString) {
        for (String string : array) {
            if (string.equals(compareString))
                return true;
        }
        return false;
    }

    /**
     * The default radix used by getNumberOfDigits when no radix
     * is provided.
     */
    public static final int DEFAULT_RADIX = 10;

    /**
     * Determines the number of digits an integer has using the default radix
     * ({@value #DEFAULT_RADIX}).
     * @return The number of digits the given number has with the default
     *     radix.
     */
    public static int numberOfDigits(int number) {
        int radix = DEFAULT_RADIX;
        int numberOfDigits = 1;
        int maxNumberAtCurrentDigits = radix;
        while (maxNumberAtCurrentDigits < number) {
            numberOfDigits++;
            maxNumberAtCurrentDigits *= radix;
        }
        return numberOfDigits;
    }

    /**
     * Determines the number of digits an integer has given a specific radix.
     * @param radix The radix used to calculate the number of digits the
     *     integer would have
     * @return The number of digits the given number has with the given
     *     radix.
     */
    public static int numberOfDigits(int number, int radix) {
        int numberOfDigits = 1;
        int maxNumberAtCurrentDigits = radix;
        while (maxNumberAtCurrentDigits < number) {
            numberOfDigits++;
            maxNumberAtCurrentDigits *= radix;
        }
        return numberOfDigits;
    }

}
