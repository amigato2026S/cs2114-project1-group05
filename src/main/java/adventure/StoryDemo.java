package adventure;

import java.util.Scanner;

/**
 * Minimal console demo that walks the story tree built in Story.java.
 * No character creation here on purpose - this demo is scoped to
 * proving the tree/choice logic works, independent of the
 * Character/Roles classes owned by the rest of the group.
 */
public class StoryDemo {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        GenTree tree = Story.build();
        Chapter current = tree.getRoot();

        System.out.println("=== STORY TREE DEMO ===");

        while (true) {
            System.out.println("\n---------------------------------");
            System.out.println(current);

            int max = current.getChoiceCount();
            if (max == 0) {
                System.out.println("\nTHE END.");
                break;
            }

            int pick = promptChoice(in, max);
            current = current.getNextChapter(current, pick);
        }

        in.close();
    }

    private static int promptChoice(Scanner in, int max) {
        while (true) {
            System.out.print("Choose an option (1-" + max + "): ");
            String line = in.nextLine().trim();
            try {
                int choice = Integer.parseInt(line);
                if (choice < 1 || choice > max) {
                    throw new NumberFormatException();
                }
                return choice;
            } catch (NumberFormatException e) {
                System.out.println("Enter a number between 1 and " + max + ".");
            }
        }
    }
}
