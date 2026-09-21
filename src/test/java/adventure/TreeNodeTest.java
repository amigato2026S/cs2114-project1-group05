package adventure;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TreeNodeTest {

    @Test
    void constructor_storesDataAndVariant() {
        TreeNode<String> node = new TreeNode<>("Start", 1);

        assertEquals("Start", node.getData());
        assertEquals(1, node.getVariant());
    }

    @Test
    void constructor_nodeStartsAsRootAndLeaf() {
        TreeNode<String> node = new TreeNode<>("Start", 1);

        assertTrue(node.isRoot());
        assertTrue(node.isLeaf());
    }

    @Test
    void setData_changesData() {
        TreeNode<String> node = new TreeNode<>("Start", 1);

        node.setData("Updated");

        assertEquals("Updated", node.getData());
    }

    @Test
    void addChild_addsChildToChildrenList() {
        TreeNode<String> parent = new TreeNode<>("Parent", 0);
        TreeNode<String> child = new TreeNode<>("Child", 1);

        parent.addChild(child);

        assertEquals(1, parent.getChildren().size());
        assertSame(child, parent.getChildren().get(0));
    }

    @Test
    void addChild_setsParentCorrectly() {
        TreeNode<String> parent = new TreeNode<>("Parent", 0);
        TreeNode<String> child = new TreeNode<>("Child", 1);

        parent.addChild(child);

        assertSame(parent, child.getParent());
    }

    @Test
    void getParent_returnsNullForRoot() {
        TreeNode<String> root = new TreeNode<>("Root", 0);

        assertNull(root.getParent());
    }

    @Test
    void getVariant_returnsCorrectVariant() {
        TreeNode<String> node = new TreeNode<>("Chapter", 2);

        assertEquals(2, node.getVariant());
    }

    @Test
    void isRoot_returnsFalseForChild() {
        TreeNode<String> root = new TreeNode<>("Root", 0);
        TreeNode<String> child = new TreeNode<>("Child", 1);

        root.addChild(child);

        assertTrue(root.isRoot());
        assertFalse(child.isRoot());
    }

    @Test
    void isLeaf_returnsTrueWhenNodeHasNoChildren() {
        TreeNode<String> node = new TreeNode<>("Chapter", 1);

        assertTrue(node.isLeaf());
    }

    @Test
    void isLeaf_returnsFalseWhenNodeHasChildren() {
        TreeNode<String> parent = new TreeNode<>("Parent", 0);
        TreeNode<String> child = new TreeNode<>("Child", 1);

        parent.addChild(child);

        assertFalse(parent.isLeaf());
        assertTrue(child.isLeaf());
    }

    @Test
    void addMultipleChildren_storesAllChildren() {
        TreeNode<String> parent = new TreeNode<>("Parent", 0);
        TreeNode<String> child1 = new TreeNode<>("Child 1", 1);
        TreeNode<String> child2 = new TreeNode<>("Child 2", 2);

        parent.addChild(child1);
        parent.addChild(child2);

        assertEquals(2, parent.getChildren().size());
        assertSame(child1, parent.getChildren().get(0));
        assertSame(child2, parent.getChildren().get(1));
    }

    @Test
    void treeStructure_tracksParentsAndChildren() {
        TreeNode<String> root = new TreeNode<>("Root", 0);
        TreeNode<String> child = new TreeNode<>("Child", 1);
        TreeNode<String> grandchild = new TreeNode<>("Grandchild", 1);

        root.addChild(child);
        child.addChild(grandchild);

        assertTrue(root.isRoot());
        assertFalse(root.isLeaf());

        assertSame(root, child.getParent());
        assertFalse(child.isRoot());
        assertFalse(child.isLeaf());

        assertSame(child, grandchild.getParent());
        assertFalse(grandchild.isRoot());
        assertTrue(grandchild.isLeaf());
    }
}
