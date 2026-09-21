package adventure;

/**
 * Represents a player character in the adventure game, holding their basic identity 
 * such as name, gender, and assigned class role.
 */
public class Player {

    /** The name of the player character. */
    private String name;

    /** The gender of the player character. */
    private Roles.Gender gender;

    /** The role and stat attributes assigned to the player character. */
    private Roles role;

    /**
     * Constructs a new {@code Player} instance with a validated name, gender, and role.
     *
     * @param name   the name of the character (cannot be null or blank)
     * @param gender the gender option selected from {@link Roles.Gender}
     * @param role   the character role containing stats and attributes
     * @throws IllegalArgumentException if {@code name} is null/empty, or if {@code gender} or {@code role} is null
     */
    public Player(String name, Roles.Gender gender, Roles role) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Character name cannot be empty.");
        }
        if (gender == null) {
            throw new IllegalArgumentException("Gender selection is invalid.");
        }
        if (role == null) {
            throw new IllegalArgumentException("Role selection is invalid.");
        }

        this.name = name.trim();
        this.gender = gender;
        this.role = role;
    }

    /**
     * Gets the player's character name.
     *
     * @return the trimmed character name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the string representation of the player's gender.
     *
     * @return the name of the {@link Roles.Gender} enum constant
     */
    public String getGender() {
        return gender.name();
    }

    /**
     * Gets the player's current role and stats.
     *
     * @return the assigned {@link Roles} object
     */
    public Roles getRole() {
        return role;
    }

    /**
     * Updates or reassigns the player's role.
     *
     * @param role the new {@link Roles} instance to assign
     * @throws IllegalArgumentException if {@code role} is null
     */
    public void setRole(Roles role) {
        if (role == null) {
            throw new IllegalArgumentException("Invalid role provided.");
        }
        this.role = role;
    }
}
