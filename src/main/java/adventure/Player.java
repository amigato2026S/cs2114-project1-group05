package adventure;

public class Player {
    private String name;
    private Roles.Gender gender;
    private Roles role;

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

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender.name();
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        if (role == null) {
            throw new IllegalArgumentException("Invalid role provided.");
        }
        this.role = role;
    }
}
