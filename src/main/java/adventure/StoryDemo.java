package adventure;

import java.util.Scanner;

public class StoryDemo {

    public static void main(String[] args) {

        TreeNode<Chapter> current = Story.build();

        Scanner scanner = new Scanner(System.in);

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
}
