package adventure;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class StoryDemo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Player player = null;
        
        System.out.println("=== CHARACTER CREATION ===");
 
        // Keep asking until the constructors accept the input
        while (player == null) {
            try {
                System.out.print("Enter character name: ");
                String name = scanner.nextLine();
 
                System.out.println("Genders: " + Arrays.toString(Roles.Gender.values()));
                System.out.print("Choose gender: ");
                Roles.Gender gender = parse(Roles.Gender.class, scanner.nextLine());
 
                System.out.println("Roles: " + Arrays.toString(Roles.RoleType.values()));
                System.out.print("Choose role: ");
                Roles.RoleType roleType = parse(Roles.RoleType.class, scanner.nextLine());
 
                // Roles throws if roleType is null; Player throws if the
                // name is blank or the gender is null.
                Roles role = new Roles(roleType);
                player = new Player(name, gender, role);
 
            } catch (IllegalArgumentException e) {
                System.out.println("Could not create character: " + e.getMessage());
                System.out.println("Please try again.\n");
            }
        }
        TreeNode<Chapter> current = Story.build(player);
        while (true) {

            Chapter chapter = current.getData();

            System.out.println();
            System.out.println(chapter);

            // No children means this is an ending
            if (current.isLeaf()) {
                System.out.println("\nTHE END.");
                break;
            }

            int choice = -1;

            while (choice < 1 || choice > chapter.getChoiceCount()) {

                System.out.print("\nChoose an option (1-"
                        + chapter.getChoiceCount() + "): ");

                String input = scanner.nextLine();

                try {
                    choice = Integer.parseInt(input);

                    if (choice < 1 || choice > chapter.getChoiceCount()) {
                        System.out.println(
                                "Enter a number between 1 and "
                                        + chapter.getChoiceCount() + ".");
                    }

                } catch (NumberFormatException e) {
                    System.out.println(
                            "Enter a number between 1 and "
                                    + chapter.getChoiceCount() + ".");
                }
            }

            TreeNode<Chapter> next = null;

            for (TreeNode<Chapter> child : current.getChildren()) {
                if (child.getVariant() == choice) {
                    next = child;
                    break;
                }
            }

            if (next == null) {
                System.out.println("No chapter found for that choice.");
                break;
            }

            current = next;
        }

        scanner.close();
    }
    
    // Converts typed text to an enum constant (case-insensitive).
    // Returns null when there's no match, so the constructors' own
    // validation produces the error message.
    private static <T extends Enum<T>> T parse(Class<T> type, String input) {
        String trimmed = input.trim();
        for (T constant : type.getEnumConstants()) {
            if (constant.name().equalsIgnoreCase(trimmed)) {
                return constant;
            }
        }
        return null;
    }
}
