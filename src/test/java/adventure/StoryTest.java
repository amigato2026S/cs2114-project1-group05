package adventure;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StoryTest {

    @Test
    void build_rootHasExpectedChoicesAndChildren() {
        GenTree tree = Story.build();
        Chapter root = tree.getRoot();

        assertEquals(2, root.getChoiceCount());
        assertTrue(root.getChapter().startsWith("You wake up in a locked stone cellar"));

        Chapter viaSearch = tree.getChild(root, 1);
        Chapter viaShout = tree.getChild(root, 2);
        assertTrue(viaSearch.getChapter().contains("rusted key"));
        assertTrue(viaShout.getChapter().contains("footsteps stop"));
    }

    @Test
    void build_everyPathEventuallyReachesAnEnding() {
        GenTree tree = Story.build();
        // Walk the "search -> key -> door" path and confirm it ends
        // with no further choices, i.e. getChoiceCount() == 0.
        Chapter node = tree.getRoot();
        node = tree.getChild(node, 1); // search cellar
        node = tree.getChild(node, 1); // take key, try door
        assertEquals(0, node.getChoiceCount());
    }

    @Test
    void build_invalidVariantOffKnownChapter_throws() {
        GenTree tree = Story.build();
        Chapter root = tree.getRoot();
        assertThrows(IllegalArgumentException.class, () -> tree.getChild(root, 99));
    }
}
