package adventure;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CharacterTest {

    private Roles warriorRole;
    private Roles mageRole;
    private Character testCharacter;

    @BeforeEach
    public void setUp() {
        warriorRole = new Roles(Roles.RoleType.WARRIOR);
        mageRole = new Roles(Roles.RoleType.MAGE);
        testCharacter = new Character("Archer", Roles.Gender.MALE, warriorRole);
    }

    @Test
    public void testConstructorAndGettersValid() {
        assertEquals("Archer", testCharacter.getName());
        assertEquals("MALE", testCharacter.getGender());
        assertEquals(warriorRole, testCharacter.getRole());
    }

    @Test
    public void testAllGendersInCharacter() {
        Character femaleChar = new Character("Hero", Roles.Gender.FEMALE, warriorRole);
        assertEquals("FEMALE", femaleChar.getGender());

        Character nbChar = new Character("Hero", Roles.Gender.NON_BINARY, warriorRole);
        assertEquals("NON_BINARY", nbChar.getGender());

        Character otherChar = new Character("Hero", Roles.Gender.OTHER, warriorRole);
        assertEquals("OTHER", otherChar.getGender());
    }

    @Test
    public void testSetRoleValid() {
        testCharacter.setRole(mageRole);
        assertEquals(mageRole, testCharacter.getRole());
    }

    @Test
    public void testNullNameThrowsException() {
        try {
            new Character(null, Roles.Gender.FEMALE, warriorRole);
            fail("Expected exception was not thrown.");
        } catch (IllegalArgumentException e) {
            assertNotNull(e.getMessage());
        }
    }

    @Test
    public void testEmptyNameThrowsException() {
        try {
            new Character("", Roles.Gender.FEMALE, warriorRole);
            fail("Expected exception was not thrown.");
        } catch (IllegalArgumentException e) {
            assertNotNull(e.getMessage());
        }
    }

    @Test
    public void testWhitespaceNameThrowsException() {
        try {
            new Character("   ", Roles.Gender.FEMALE, warriorRole);
            fail("Expected exception was not thrown.");
        } catch (IllegalArgumentException e) {
            assertNotNull(e.getMessage());
        }
    }

    @Test
    public void testNullGenderThrowsException() {
        try {
            new Character("Archer", null, warriorRole);
            fail("Expected exception was not thrown.");
        } catch (IllegalArgumentException e) {
            assertNotNull(e.getMessage());
        }
    }

    @Test
    public void testNullRoleThrowsException() {
        try {
            new Character("Archer", Roles.Gender.MALE, null);
            fail("Expected exception was not thrown.");
        } catch (IllegalArgumentException e) {
            assertNotNull(e.getMessage());
        }
    }

    @Test
    public void testSetRoleNullThrowsException() {
        try {
            testCharacter.setRole(null);
            fail("Expected exception was not thrown.");
        } catch (IllegalArgumentException e) {
            assertNotNull(e.getMessage());
        }
    }
}
