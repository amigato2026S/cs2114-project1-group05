package adventure;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GenTreeTest {

    @Test
    void constructor_validRoot_setsRoot() {
        Chapter root = new Chapter("Chapter 1.", new String[]{"Go on"});
        GenTree tree = new GenTree(root);
        assertSame(root, tree.getRoot());
    }

    @Test
    void constructor_nullRoot_throws() {
        assertThrows(IllegalArgumentException.class, () -> new GenTree(null));
    }

    @Test
    void addChildAndGetChild_validParent_returnsCorrectChild() {
        Chapter root = new Chapter("Chapter 1.", new String[]{"Left", "Right"});
        GenTree tree = new GenTree(root);
        Chapter left = new Chapter("You went left.", new String[]{});
        Chapter right = new Chapter("You went right.", new String[]{});

        tree.addChild(root, left, 1);
        tree.addChild(root, right, 2);

        assertEquals("You went left.", tree.getChild(root, 1).getChapter());
        assertEquals("You went right.", tree.getChild(root, 2).getChapter());
        assertEquals(1, left.getVariant());
    }

    @Test
    void addChild_parentNotInTree_throws() {
        GenTree tree = new GenTree(new Chapter("Chapter 1.", new String[]{"Go"}));
        Chapter orphanParent = new Chapter("Not in the tree.", new String[]{"Go"});
        Chapter child = new Chapter("A child.", new String[]{});

        assertThrows(IllegalArgumentException.class, () -> tree.addChild(orphanParent, child, 1));
    }

    @Test
    void getChild_invalidVariant_throws() {
        Chapter root = new Chapter("Chapter 1.", new String[]{"Only option"});
        GenTree tree = new GenTree(root);
        tree.addChild(root, new Chapter("Only path.", new String[]{}), 1);

        assertThrows(IllegalArgumentException.class, () -> tree.getChild(root, 5));
    }
}
