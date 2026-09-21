package adventure;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StoryTest {

    @Test
    void build_rootHasExpectedChoicesAndChildren() {
        TreeNode<Chapter> root = Story.build();
        Chapter rootChapter = root.getData();

        assertEquals(2, rootChapter.getChoiceCount());
        assertTrue(rootChapter.getChapter()
                .startsWith("You wake up in a locked stone cellar"));

        TreeNode<Chapter> viaSearch = getChildForChoice(root, 1);
        TreeNode<Chapter> viaShout = getChildForChoice(root, 2);

        assertTrue(viaSearch.getData().getChapter().contains("rusted key"));
        assertTrue(viaShout.getData().getChapter().contains("footsteps stop"));
    }

    @Test
    void build_everyPathEventuallyReachesAnEnding() {
        TreeNode<Chapter> root = Story.build();

        TreeNode<Chapter> node = getChildForChoice(root, 1);
        node = getChildForChoice(node, 1);

        assertTrue(node.isLeaf());
        assertEquals(0, node.getData().getChoiceCount());
    }

    @Test
    void build_invalidVariantOffKnownChapter_throws() {
        TreeNode<Chapter> root = Story.build();

        assertThrows(IllegalArgumentException.class,
                () -> getChildForChoice(root, 99));
    }

    @Test
    void build_allStoryBranchesReachAnEnding() {
        assertAll(
                () -> assertEnding(Story.build(), 1, 1),
                () -> assertEnding(Story.build(), 1, 2, 1),
                () -> assertEnding(Story.build(), 1, 2, 2),
                () -> assertEnding(Story.build(), 2, 1),
                () -> assertEnding(Story.build(), 2, 2)
        );
    }

    private static void assertEnding(
            TreeNode<Chapter> root, int... choices) {

        TreeNode<Chapter> node = root;

        for (int choice : choices) {
            node = getChildForChoice(node, choice);
        }

        assertTrue(node.isLeaf());
        assertEquals(0, node.getData().getChoiceCount());
    }

    private static TreeNode<Chapter> getChildForChoice(
            TreeNode<Chapter> parent, int choice) {

        for (TreeNode<Chapter> child : parent.getChildren()) {
            if (child.getVariant() == choice) {
                return child;
            }
        }

        throw new IllegalArgumentException(
                "No child found for choice " + choice);
    }
}
