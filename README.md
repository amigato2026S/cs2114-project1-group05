# Point & Click Adventure — Chapter / Tree / Choices

This portion of the group's Point & Click Adventure
project covers the chapter classes, correct tree construction, and choice creation


- **`Chapter.java`** — one story node: story text, choice text, its `variant` (branch number), its children, and `getNextChapter(parent, choice)` navigation.
- **`GenTree.java`** — the tree wrapper: holds the root chapter and provides `addChild(parent, child, variant)` / `getChild(parent, variant)`, validating that a parent actually belongs to the tree before attaching to it.
- **`Story.java`** — builds the actual sample story tree: writes each chapter's text and choice options, then wires them together into a `GenTree` with `addChild` calls. This is the "creating the tree correctly" + "creating choices" work.
- **`StoryDemo.java`** — a minimal console walker that proves the tree works: prints each chapter, takes a numbered choice, validates it, and advances until an ending is reached.


### Run the demo

```bash
mvn compile
java -cp target/classes adventure.StoryDemo
```

or build a runnable jar:

```bash
mvn package
java -jar target/adventure.jar
```

### Run the tests

```bash
mvn test
```

`ChapterTest`, `GenTreeTest`, and `StoryTest` cover at least one
normal case and one bad-input case for every key method (constructors,
`addChild`/`getChild`, `getNextChapter`), plus tests that the sample
tree in `Story.build()` is wired correctly and every path reaches an
ending.
