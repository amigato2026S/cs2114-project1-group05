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

### 1. Import the project from GitHub

1. Open **Eclipse**.

2. Select **File → Import**.

3. Expand **Git**.

4. Select **Projects from Git** and click **Next**.

5. Select **Clone URI** and click **Next**.

6. Enter the repository URL:

   `https://github.com/amigato2026S/cs2114-project1-group05.git`

7. Click **Next** and select the `main` branch.

8. Choose a local directory where you want to store the project.

9. Click **Finish** to clone the repository.

10. If Eclipse asks how to import the project, import it as an existing Maven project/project.

### 2. Run the program

1. In the **Package Explorer**, expand:
   `src/main/java → adventure`
2. Find **`StoryDemo.java`**.
3. Right-click **`StoryDemo.java`**.
4. Select **Run As → Java Application**.
5. Follow the prompts in the Eclipse Console to play through the branching story.

## Run the tests in Eclipse

1. In the **Package Explorer**, expand:
   `src/test/java → adventure`
2. Right-click the **`adventure`** test package.
3. Select **Run As → JUnit Test**.
4. Eclipse will open the **JUnit** window and display the test results.

The test suite covers `Player`, `Roles`, `Chapter`, `TreeNode`, and the sample story tree.
