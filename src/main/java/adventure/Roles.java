package adventure;

/**
 * Represents a character role in the adventure game, defining base attributes 
 * such as health, attack power, defense, stealth, and intelligence.
 */
public class Roles {

    /**
     * Defines the available character role types.
     */
    public enum RoleType {
        WARRIOR,
        THIEF,
        MAGE
    }

    /**
     * Defines character gender options.
     */
    public enum Gender {
        MALE,
        FEMALE,
        NON_BINARY,
        OTHER
    }

    /** The type of role assigned to this character class. */
    private RoleType type;

    /** Current or base health points. */
    private int hp;

    /** Base attack power. */
    private int atk;

    /** Base defense capability. */
    private int def;

    /** Base stealth attribute. */
    private int stealth;

    /** Base intelligence attribute. */
    private int intel;

    /**
     * Constructs a {@code Roles} instance with default stats based on the specified {@link RoleType}.
     *
     * @param type the character role type (e.g., WARRIOR, THIEF, MAGE)
     * @throws IllegalArgumentException if {@code type} is {@code null}
     */
    public Roles(RoleType type) {
        if (type == null) {
            throw new IllegalArgumentException("Role type cannot be null.");
        }

        this.type = type;
        
        if (type == RoleType.WARRIOR) {
            this.hp = 100;
            this.atk = 15;
            this.def = 10;
            this.stealth = 3;
            this.intel = 5;
        } 
        else if (type == RoleType.THIEF) {
            this.hp = 70;
            this.atk = 10;
            this.def = 4;
            this.stealth = 15;
            this.intel = 8;
        }
        else {
            this.hp = 60;
            this.atk = 8;
            this.def = 3;
            this.stealth = 5;
            this.intel = 18;
        }
        validateStats();
    }

    /**
     * Constructs a {@code Roles} instance with custom attribute values.
     *
     * @param type    the character role type
     * @param hp      the health points
     * @param atk     the attack value
     * @param def     the defense value
     * @param stealth the stealth value
     * @param intel   the intelligence value
     * @throws IllegalArgumentException if {@code type} is {@code null} or if any stat is negative
     */
    public Roles(RoleType type, int hp, int atk, int def, int stealth, int intel) {
        if (type == null) {
            throw new IllegalArgumentException("Role type cannot be null.");
        }

        this.type = type;
        this.hp = hp;
        this.atk = atk;
        this.def = def;
        this.stealth = stealth;
        this.intel = intel;
        validateStats();
    }
    
    /**
     * Validates that all attribute values are non-negative.
     *
     * @throws IllegalArgumentException if any attribute value is less than 0
     */
    private void validateStats() {
        if (hp < 0) {
            throw new IllegalArgumentException("HP cannot be negative.");
        }
        if (atk < 0) {
            throw new IllegalArgumentException("Attack cannot be negative.");
        }
        if (def < 0) {
            throw new IllegalArgumentException("Defense cannot be negative.");
        }
        if (stealth < 0) {
            throw new IllegalArgumentException("Stealth cannot be negative.");
        }
        if (intel < 0) {
            throw new IllegalArgumentException("Intelligence cannot be negative.");
        }
    }

    /**
     * Gets the role type.
     *
     * @return the {@link RoleType} of this character role
     */
    public RoleType getType() { 
        return type; 
    }
    
    /**
     * Gets the health points.
     *
     * @return the HP stat
     */
    public int getHP() { 
        return hp; 
    }
    
    /**
     * Gets the attack damage power.
     *
     * @return the attack stat
     */
    public int getDamage() { 
        return atk;
    }
    
    /**
     * Gets the defense value.
     *
     * @return the defense stat
     */
    public int getDefense() { 
        return def; 
    }
    
    /**
     * Gets the stealth value.
     *
     * @return the stealth stat
     */
    public int getStealth() { 
        return stealth; 
    }
    
    /**
     * Gets the intelligence value.
     *
     * @return the intelligence stat
     */
    public int getIntel() { 
        return intel; 
    }
}
