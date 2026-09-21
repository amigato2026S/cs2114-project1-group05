package adventure;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ChapterTest {

    @Test
    void constructor_validStoryAndChoices_storesThem() {
        Chapter ch = new Chapter(
                "You enter a dark room.",
                new String[] {"Light a torch", "Feel along the wall"});

        assertEquals("You enter a dark room.", ch.getChapter());
        assertTrue(ch.getChoices().contains("Light a torch"));
        assertEquals(2, ch.getChoiceCount());
    }

    @Test
    void constructor_emptyStory_throws() {
        assertThrows(IllegalArgumentException.class,
                () -> new Chapter("", new String[] {"Go"}));
    }

    @Test
    void constructor_nullChoices_throws() {
        assertThrows(IllegalArgumentException.class,
                () -> new Chapter("A room.", null));
    }

    @Test
    void constructor_emptyChoicesArray_isValidEnding() {
        Chapter ending = new Chapter(
                "You escape into the night.", new String[] {});

        assertEquals(0, ending.getChoiceCount());
        assertTrue(ending.getChoices().toLowerCase().contains("ending"));
    }

    @Test
    void toString_includesStoryAndChoices() {
        Chapter ch = new Chapter(
                "A fork in the road.", new String[] {"Left", "Right"});

        String text = ch.toString();

        assertTrue(text.contains("A fork in the road."));
        assertTrue(text.contains("Left"));
    }

    @Test
    void getNextChapter_validChoice_returnsMatchingChild() {
        Chapter root = new Chapter(
                "Start.", new String[] {"North", "South"});
        Chapter north = new Chapter(
                "You went north.", new String[] {});
        Chapter south = new Chapter(
                "You went south.", new String[] {});

        TreeNode<Chapter> rootNode = new TreeNode<>(root, 0);
        TreeNode<Chapter> northNode = new TreeNode<>(north, 1);
        TreeNode<Chapter> southNode = new TreeNode<>(south, 2);

        rootNode.addChild(northNode);
        rootNode.addChild(southNode);

        // Chapter's own child API is independent from TreeNode, so attach
        // the same chapters here to test getNextChapter directly.
        root.addChild(north);
        root.addChild(south);
        north.setVariant(1);
        south.setVariant(2);

        Chapter next = root.getNextChapter(root, 1);

        assertEquals("You went north.", next.getChapter());
    }

    @Test
    void getNextChapter_invalidChoice_throws() {
        Chapter root = new Chapter(
                "Start.", new String[] {"North"});
        Chapter north = new Chapter(
                "You went north.", new String[] {});

        root.addChild(north);
        north.setVariant(1);

        assertThrows(IllegalArgumentException.class,
                () -> root.getNextChapter(root, 99));
    }

    @Test
    void getNextChapter_nullParent_throws() {
        Chapter ch = new Chapter(
                "Start.", new String[] {"Go"});

        assertThrows(IllegalArgumentException.class,
                () -> ch.getNextChapter(null, 1));
    }
}
