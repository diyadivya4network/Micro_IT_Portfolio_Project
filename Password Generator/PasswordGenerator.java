import java.util.*;

public class PasswordGenerator {

    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String NUMBERS = "0123456789";
    private static final String SYMBOLS = "!@#$%^&*()_+-=[]{}|;:,.<>?";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Password Generator ===");

        System.out.print("Enter password length: ");
        int length = scanner.nextInt();

        System.out.print("Include uppercase letters? (y/n): ");
        boolean useUpper = scanner.next().equalsIgnoreCase("y");

        System.out.print("Include lowercase letters? (y/n): ");
        boolean useLower = scanner.next().equalsIgnoreCase("y");

        System.out.print("Include numbers? (y/n): ");
        boolean useNumbers = scanner.next().equalsIgnoreCase("y");

        System.out.print("Include symbols? (y/n): ");
        boolean useSymbols = scanner.next().equalsIgnoreCase("y");

        String password = generatePassword(length, useUpper, useLower, useNumbers, useSymbols);
        System.out.println("\nGenerated Password: " + password);
    }

    public static String generatePassword(int length, boolean upper, boolean lower, boolean numbers, boolean symbols) {
        StringBuilder charPool = new StringBuilder();
        Random random = new Random();

        if (upper) charPool.append(UPPERCASE);
        if (lower) charPool.append(LOWERCASE);
        if (numbers) charPool.append(NUMBERS);
        if (symbols) charPool.append(SYMBOLS);

        if (charPool.length() == 0) {
            return "Error: No character types selected!";
        }

        StringBuilder password = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(charPool.length());
            password.append(charPool.charAt(index));
        }

        return password.toString();
    }
}
