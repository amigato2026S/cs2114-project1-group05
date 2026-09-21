public class Roles {

    public enum RoleType {
        WARRIOR,
        THIEF,
        MAGE
    }

    public enum Gender {
        MALE,
        FEMALE,
        NON_BINARY,
        OTHER
    }

    private RoleType type;
    private int hp;
    private int atk;
    private int def;
    private int stealth;
    private int intel;

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
        } else if (type == RoleType.THIEF) {
            this.hp = 70;
            this.atk = 10;
            this.def = 4;
            this.stealth = 15;
            this.intel = 8;
        } else {
            this.hp = 60;
            this.atk = 8;
            this.def = 3;
            this.stealth = 5;
            this.intel = 18;
        }
        validateStats();
    }

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

    public RoleType getType() { 
        return type; 
    }
    
    public int getHP() { 
        return hp; 
    }
    
    public int getDamage() { 
        return atk;
    }
    
    public int getDefense() { 
        return def; 
    }
    
    public int getStealth() { 
        return stealth; 
    }
    
    public int getIntel() { 
        return intel; 
    }
}