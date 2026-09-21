package adventure;

/**
 * Builds the sample branching story using TreeNode<Chapter>.
 */
public final class Story {

    private Story() {
    }

    /**
     * Builds and returns the root of the story tree.
     *
     * @return root TreeNode containing the first chapter
     */
    public static TreeNode<Chapter> build() {
        Chapter ch1 = new Chapter(
                "You wake up in a locked stone cellar. A single torch flickers "
                        + "on the wall, and you hear footsteps pacing above you.",
                new String[] {
                        "Search the cellar for a way out",
                        "Pound on the door and shout for help"
                });

        Chapter ch2a = new Chapter(
                "Behind a loose stone you find a rusted key and a narrow crawlspace "
                        + "leading toward the sound of running water.",
                new String[] {
                        "Take the key and try the door",
                        "Crawl toward the water sound"
                });

        Chapter ch2b = new Chapter(
                "The footsteps stop. A gruff voice on the other side grumbles and "
                        + "the door creaks open a crack.",
                new String[] {
                        "Push past and run",
                        "Talk your way out"
                });

        Chapter ch3a = new Chapter(
                "The key turns with a satisfying click. The door swings open onto "
                        + "a moonlit courtyard - you're free.",
                new String[] {});

        Chapter ch3b = new Chapter(
                "The crawlspace opens into an underground stream. It's cold, dark, "
                        + "and the current is pulling hard.",
                new String[] {
                        "Swim with the current",
                        "Climb back out"
                });

        Chapter ch3c = new Chapter(
                "You shove past the guard and sprint into the night. Free, but shaken.",
                new String[] {});

        Chapter ch3d = new Chapter(
                "Your calm words work - the guard steps aside and lets you go.",
                new String[] {});

        Chapter ch4a = new Chapter(
                "You swim hard and the current spits you out into open air. You made it.",
                new String[] {});

        Chapter ch4b = new Chapter(
                "You climb back out, soaked but safe, and try the door instead.",
                new String[] {});

        TreeNode<Chapter> root = new TreeNode<>(ch1, 0);
        TreeNode<Chapter> ch2aNode = new TreeNode<>(ch2a, 1);
        TreeNode<Chapter> ch2bNode = new TreeNode<>(ch2b, 2);
        TreeNode<Chapter> ch3aNode = new TreeNode<>(ch3a, 1);
        TreeNode<Chapter> ch3bNode = new TreeNode<>(ch3b, 2);
        TreeNode<Chapter> ch3cNode = new TreeNode<>(ch3c, 1);
        TreeNode<Chapter> ch3dNode = new TreeNode<>(ch3d, 2);
        TreeNode<Chapter> ch4aNode = new TreeNode<>(ch4a, 1);
        TreeNode<Chapter> ch4bNode = new TreeNode<>(ch4b, 2);

        root.addChild(ch2aNode);
        root.addChild(ch2bNode);
        ch2aNode.addChild(ch3aNode);
        ch2aNode.addChild(ch3bNode);
        ch2bNode.addChild(ch3cNode);
        ch2bNode.addChild(ch3dNode);
        ch3bNode.addChild(ch4aNode);
        ch3bNode.addChild(ch4bNode);

        return root;
    }
}
