package adventure;

import java.util.ArrayList;
import java.util.List;

/**
 * One node of the story tree.
 */
public class Chapter {

    private final String story;
    private final String[] choices;
    private int variant;
    private final List<Chapter> children = new ArrayList<>();

    /**
     * @param story   the paragraph of story text for this chapter
     * @param choices the option text the player can pick from; use an
     *                empty array for an ending chapter with no choices
     */
    public Chapter(String story, String[] choices) {
        if (story == null || story.trim().isEmpty()) {
            throw new IllegalArgumentException("Story text cannot be empty.");
        }
        if (choices == null) {
            throw new IllegalArgumentException("Choices array cannot be null (use an empty array for an ending).");
        }
        this.story = story;
        this.choices = choices;
        this.variant = 0;
    }

    public int getVariant() {
        return variant;
    }

    void setVariant(int variant) {
        this.variant = variant;
    }

    public String getChapter() {
        return story;
    }

    public String getChoices() {
        if (choices.length == 0) {
            return "(no further choices - this is an ending)";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < choices.length; i++) {
            sb.append(i + 1).append(". ").append(choices[i]);
            if (i < choices.length - 1) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    public int getChoiceCount() {
        return choices.length;
    }

    /** Package-private: only GenTree should attach children. */
    void addChild(Chapter child) {
        children.add(child);
    }

    List<Chapter> getChildren() {
        return children;
    }

    /**
     * Goes to the next chapter based on the choice the player made.
     *
     * @param parent the chapter the player is currently on
     * @param choice the branch/variant number the player picked
     * @return the matching child chapter
     * @throws IllegalArgumentException if parent is null or no child
     *                                   matches that variant
     */
    public Chapter getNextChapter(Chapter parent, int choice) {
        if (parent == null) {
            throw new IllegalArgumentException("Parent chapter cannot be null.");
        }
        for (Chapter child : parent.children) {
            if (child.getVariant() == choice) {
                return child;
            }
        }
        throw new IllegalArgumentException("No chapter found for choice " + choice + ".");
    }

    @Override
    public String toString() {
        return story + "\n\n" + getChoices();
    }
}
