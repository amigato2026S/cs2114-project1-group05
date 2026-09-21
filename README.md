# Point & Click Adventure — Chapter / Tree / Choices

This project implements a branching point-and-click adventure using a general `TreeNode<Chapter>` tree.

## Main classes

* **`Player.java`** — stores the player's name, gender, and selected role.
* **`Roles.java`** — defines Warrior, Thief, and Mage roles and their stats.
* **`Chapter.java`** — stores story text and the choices available at a chapter.
* **`TreeNode.java`** — generic tree node that stores a chapter, its variant number, parent, and child nodes.
* **`Story.java`** — constructs the complete sample story tree.
* **`StoryDemo.java`** — walks the tree from the root, validates numeric input, and stops when an ending chapter is reached.

## Run the demo in Eclipse

1. Open **Eclipse**.
2. Select **File → Import**.
3. Choose **Maven → Existing Maven Projects**.
4. Select the project folder and click **Finish**.
5. In the **Package Explorer**, expand:
   `src/main/java → adventure`
6. Right-click **`StoryDemo.java`**.
7. Select **Run As → Java Application**.
8. Follow the prompts in the Eclipse Console to make choices and play through the story.

## Run the tests in Eclipse

1. In the **Package Explorer**, expand:
   `src/test/java → adventure`
2. Right-click the **`adventure`** test package.
3. Select **Run As → JUnit Test**.
4. Eclipse will run the test suite and display the results in the **JUnit** window.

The test suite covers `Player`, `Roles`, `Chapter`, `TreeNode`, and the sample story tree.


