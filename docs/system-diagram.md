# System Diagram — Point & Click Adventure

```mermaid
classDiagram
    class Player {
        -String name
        -Gender gender
        -Roles role
        +Player(name, gender, role)
        +getName() String
        +getGender() Gender
        +getRole() Roles
        +setRole(role) void
    }

    class Roles {
        -RoleType type
        -int hp
        -int atk
        -int def
        -int stealth
        -int intel
        +Roles(type)
        +Roles(type, hp, atk, def, stealth, intel)
        +getType() RoleType
        +getHp() int
        +getAtk() int
        +getDef() int
        +getStealth() int
        +getIntel() int
    }

    class Chapter {
        -String story
        -String[] choices
        -int variant
        -List~Chapter~ children
        +Chapter(story, choices, variant)
        +getChoices() String[]
        +getChoiceCount() int
        +getNextChapter(parent, choice) Chapter
        +toString() String
    }

    class TreeNode~T~ {
        -T data
        -List~TreeNode~T~~ children
        -TreeNode~T~ parent
        -int variant
        +TreeNode(input, variant)
        +getData() T
        +setData(input) void
        +getChildren() List~TreeNode~T~~
        +addChild(child) void
        +getParent() TreeNode~T~
        +getVariant() int
        +isRoot() boolean
        +isLeaf() boolean
    }

    class Story {
        +build() TreeNode~Chapter~
    }

    class StoryDemo {
        +main(args) void
    }

    Player --> Roles : has a
    TreeNode~Chapter~ --> Chapter : stores
    TreeNode~Chapter~ --> TreeNode~Chapter~ : has children
    Story ..> Chapter : creates
    Story ..> TreeNode~Chapter~ : builds
    StoryDemo ..> Story : calls build()
    StoryDemo ..> TreeNode~Chapter~ : traverses
    StoryDemo ..> Chapter : displays choices
