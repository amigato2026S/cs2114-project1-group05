# Point & Click Adventure — Chapter / Tree / Choices

This is Sophia's portion of the group's Point & Click Adventure
project: the **Chapter classes, correct tree construction, and
choice creation**. It's a self-contained piece — it doesn't depend
on the Character/Roles classes the rest of the group owns — so it
can be built, tested, and demoed on its own.

## What's here

- **`Chapter.java`** — one story node: story text, choice text, its `variant` (branch number), its children, and `getNextChapter(parent, choice)` navigation.
- **`GenTree.java`** — the tree wrapper: holds the root chapter and provides `addChild(parent, child, variant)` / `getChild(parent, variant)`, validating that a parent actually belongs to the tree before attaching to it.
- **`Story.java`** — builds the actual sample story tree: writes each chapter's text and choice options, then wires them together into a `GenTree` with `addChild` calls. This is the "creating the tree correctly" + "creating choices" work.
- **`StoryDemo.java`** — a minimal console walker that proves the tree works: prints each chapter, takes a numbered choice, validates it, and advances until an ending is reached.

## Design note

The design doc listed `Chapter.choices` as `int[]`. Here it's
`String[]` — the actual option text shown to the player (e.g.
`"Search the cellar for a way out"`) — since the branch number is
already tracked separately as each child's `variant`. This is what
lets `Chapter.toString()` print real choice text instead of raw
numbers.

## How to compile and run

Requires **JDK 17+** and **Maven**.

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
