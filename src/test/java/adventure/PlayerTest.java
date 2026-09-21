package adventure;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {

    private Roles warriorRole;
    private Roles mageRole;
    private Character testCharacter;

    @BeforeEach
    public void setUp() {
        warriorRole = new Roles(Roles.RoleType.WARRIOR);
        mageRole = new Roles(Roles.RoleType.MAGE);
        testCharacter = new Player("Archer", Roles.Gender.MALE, warriorRole);
    }

    @Test
    public void testConstructorAndGettersValid() {
        assertEquals("Archer", testCharacter.getName());
        assertEquals("MALE", testCharacter.getGender());
        assertEquals(warriorRole, testCharacter.getRole());
    }

    @Test
    public void testAllGendersInCharacter() {
        Player femaleChar = new Player("Hero", Roles.Gender.FEMALE, warriorRole);
        assertEquals("FEMALE", femaleChar.getGender());

        Player nbChar = new Player("Hero", Roles.Gender.NON_BINARY, warriorRole);
        assertEquals("NON_BINARY", nbChar.getGender());

        Player otherChar = new Player("Hero", Roles.Gender.OTHER, warriorRole);
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
            new Player(null, Roles.Gender.FEMALE, warriorRole);
            fail("Expected exception was not thrown.");
        } catch (IllegalArgumentException e) {
            assertNotNull(e.getMessage());
        }
    }

    @Test
    public void testEmptyNameThrowsException() {
        try {
            new Player("", Roles.Gender.FEMALE, warriorRole);
            fail("Expected exception was not thrown.");
        } catch (IllegalArgumentException e) {
            assertNotNull(e.getMessage());
        }
    }

    @Test
    public void testWhitespaceNameThrowsException() {
        try {
            new Player("   ", Roles.Gender.FEMALE, warriorRole);
            fail("Expected exception was not thrown.");
        } catch (IllegalArgumentException e) {
            assertNotNull(e.getMessage());
        }
    }

    @Test
    public void testNullGenderThrowsException() {
        try {
            new Player("Archer", null, warriorRole);
            fail("Expected exception was not thrown.");
        } catch (IllegalArgumentException e) {
            assertNotNull(e.getMessage());
        }
    }

    @Test
    public void testNullRoleThrowsException() {
        try {
            new Player("Archer", Roles.Gender.MALE, null);
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
