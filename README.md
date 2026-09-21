# Point & Click Adventure — Chapter / Tree / Choices

This project implements a branching point-and-click adventure using a
general `TreeNode<Chapter>` tree.

## Main classes

- **`Player.java`** — stores the player's name, gender, and selected role.
- **`Roles.java`** — defines Warrior, Thief, and Mage roles and their stats.
- **`Chapter.java`** — stores story text and the choices available at a chapter.
- **`TreeNode.java`** — generic tree node that stores a chapter, its variant
  number, parent, and child nodes.
- **`Story.java`** — constructs the complete sample story tree.
- **`StoryDemo.java`** — walks the tree from the root, validates numeric input,
  and stops when an ending chapter is reached.

## Run the demo

From the project root:

```bash
mvn clean compile
java -cp target/classes adventure.StoryDemo
```

Or build the runnable JAR:

```bash
mvn clean package
java -jar target/adventure.jar
```

## Run the tests

```bash
mvn clean test
```

The test suite covers `Player`, `Roles`, `Chapter`, `TreeNode`, and the
sample story tree.

