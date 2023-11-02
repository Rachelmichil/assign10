import java.util.Scanner;

public class SimplePasswordValidator {

    public static boolean isValidPassword(String password) {
        // Check the length requirement
        if (password.length() < 8 || password.length() > 16) {
            return false;
        }

        // Check the combination of categories
        int categoryCount = 0;
        if (containsCharacterCategory(password, "a-z")) {
            categoryCount++;
        }
        if (containsCharacterCategory(password, "A-Z")) {
            categoryCount++;
        }
        if (containsCharacterCategory(password, "0-9")) {
            categoryCount++;
        }
        if (containsCharacterCategory(password, "~!@#$%^&*()-=+_")) {
            categoryCount++;
        }

        return categoryCount >= 3;
    }

    private static boolean containsCharacterCategory(String password, String category) {
        return password.matches(".*[" + category + "].*");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a password: ");
        String password = scanner.nextLine();

        if (isValidPassword(password)) {
            System.out.println("Password is valid.");
        } else {
            System.out.println("Password is invalid. Please ensure it meets the specified requirements.");
        }

        scanner.close();
    }
}
