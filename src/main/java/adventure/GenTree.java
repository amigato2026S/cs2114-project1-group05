package adventure;

/**
 * Tree data structure for the storyline. Chapter 1 is the root; every
 * other chapter is reached by walking down through
 */
public class GenTree {

    private final Chapter root;

    public GenTree(Chapter root) {
        if (root == null) {
            throw new IllegalArgumentException("Root chapter cannot be null.");
        }
        this.root = root;
    }

    public Chapter getRoot() {
        return root;
    }

    /**
     * Creates a child Chapter under parent, tagged with the given
     * variant/branch number.
     *
     * @param parent  a chapter already present in this tree
     * @param child   the new chapter to attach
     * @param variant the branch number the player picks to reach child
     */
    public void addChild(Chapter parent, Chapter child, int variant) {
        if (parent == null || child == null) {
            throw new IllegalArgumentException("Parent and child chapters cannot be null.");
        }
        if (!contains(root, parent)) {
            throw new IllegalArgumentException("Parent chapter is not part of this tree.");
        }
        child.setVariant(variant);
        parent.addChild(child);
    }

    /**
     * Finds and returns the child of parent whose variant number
     * matches the branch number given.
     */
    public Chapter getChild(Chapter parent, int variant) {
        if (parent == null) {
            throw new IllegalArgumentException("Parent chapter cannot be null.");
        }
        for (Chapter child : parent.getChildren()) {
            if (child.getVariant() == variant) {
                return child;
            }
        }
        throw new IllegalArgumentException("No child found for variant " + variant + ".");
    }

    private boolean contains(Chapter node, Chapter target) {
        if (node == target) {
            return true;
        }
        for (Chapter child : node.getChildren()) {
            if (contains(child, target)) {
                return true;
            }
        }
        return false;
    }
}
