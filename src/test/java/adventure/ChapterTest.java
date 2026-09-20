package adventure;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChapterTest {

    @Test
    void constructor_validStoryAndChoices_storesThem() {
        Chapter ch = new Chapter("You enter a dark room.", new String[]{"Light a torch", "Feel along the wall"});
        assertEquals("You enter a dark room.", ch.getChapter());
        assertTrue(ch.getChoices().contains("Light a torch"));
        assertEquals(2, ch.getChoiceCount());
    }

    @Test
    void constructor_emptyStory_throws() {
        assertThrows(IllegalArgumentException.class, () -> new Chapter("", new String[]{"Go"}));
    }

    @Test
    void constructor_nullChoices_throws() {
        assertThrows(IllegalArgumentException.class, () -> new Chapter("A room.", null));
    }

    @Test
    void constructor_emptyChoicesArray_isValidEnding() {
        Chapter ending = new Chapter("You escape into the night.", new String[]{});
        assertEquals(0, ending.getChoiceCount());
        assertTrue(ending.getChoices().toLowerCase().contains("ending"));
    }

    @Test
    void toString_includesStoryAndChoices() {
        Chapter ch = new Chapter("A fork in the road.", new String[]{"Left", "Right"});
        String text = ch.toString();
        assertTrue(text.contains("A fork in the road."));
        assertTrue(text.contains("Left"));
    }

    @Test
    void getNextChapter_validChoice_returnsMatchingChild() {
        GenTree tree = new GenTree(new Chapter("Start.", new String[]{"North", "South"}));
        Chapter north = new Chapter("You went north.", new String[]{});
        Chapter south = new Chapter("You went south.", new String[]{});
        tree.addChild(tree.getRoot(), north, 1);
        tree.addChild(tree.getRoot(), south, 2);

        Chapter next = tree.getRoot().getNextChapter(tree.getRoot(), 1);
        assertEquals("You went north.", next.getChapter());
    }

    @Test
    void getNextChapter_invalidChoice_throws() {
        GenTree tree = new GenTree(new Chapter("Start.", new String[]{"North"}));
        Chapter north = new Chapter("You went north.", new String[]{});
        tree.addChild(tree.getRoot(), north, 1);

        assertThrows(IllegalArgumentException.class,
                () -> tree.getRoot().getNextChapter(tree.getRoot(), 99));
    }

    @Test
    void getNextChapter_nullParent_throws() {
        Chapter ch = new Chapter("Start.", new String[]{"Go"});
        assertThrows(IllegalArgumentException.class, () -> ch.getNextChapter(null, 1));
    }
}
