import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RolesTest {

    private Roles warriorRole;
    private Roles thiefRole;
    private Roles mageRole;

    @BeforeEach
    public void setUp() {
        warriorRole = new Roles(Roles.RoleType.WARRIOR);
        thiefRole = new Roles(Roles.RoleType.THIEF);
        mageRole = new Roles(Roles.RoleType.MAGE);
    }

    @Test
    public void testPresetConstructorAndGetters() {
        assertEquals(Roles.RoleType.WARRIOR, warriorRole.getType());
        assertEquals(100, warriorRole.getHP());
        assertEquals(15, warriorRole.getDamage());
        assertEquals(10, warriorRole.getDefense());
        assertEquals(3, warriorRole.getStealth());
        assertEquals(5, warriorRole.getIntel());

        assertEquals(Roles.RoleType.THIEF, thiefRole.getType());
        assertEquals(70, thiefRole.getHP());
        assertEquals(10, thiefRole.getDamage());
        assertEquals(4, thiefRole.getDefense());
        assertEquals(15, thiefRole.getStealth());
        assertEquals(8, thiefRole.getIntel());

        assertEquals(Roles.RoleType.MAGE, mageRole.getType());
        assertEquals(60, mageRole.getHP());
        assertEquals(8, mageRole.getDamage());
        assertEquals(3, mageRole.getDefense());
        assertEquals(5, mageRole.getStealth());
        assertEquals(18, mageRole.getIntel());
    }

    @Test
    public void testExplicitConstructorValid() {
        Roles customRole = new Roles(Roles.RoleType.WARRIOR, 50, 10, 5, 2, 4);
        assertEquals(50, customRole.getHP());
        assertEquals(10, customRole.getDamage());
        assertEquals(5, customRole.getDefense());
        assertEquals(2, customRole.getStealth());
        assertEquals(4, customRole.getIntel());
    }

    @Test
    public void testNullTypePresetConstructorThrowsException() {
        try {
            new Roles(null);
            fail("Expected exception was not thrown.");
        } catch (IllegalArgumentException e) {
            assertNotNull(e.getMessage());
        }
    }

    @Test
    public void testNullTypeExplicitConstructorThrowsException() {
        try {
            new Roles(null, 50, 10, 5, 2, 4);
            fail("Expected exception was not thrown.");
        } catch (IllegalArgumentException e) {
            assertNotNull(e.getMessage());
        }
    }

    @Test
    public void testNegativeHPThrowsException() {
        try {
            new Roles(Roles.RoleType.WARRIOR, -1, 10, 10, 5, 5);
            fail("Expected exception was not thrown.");
        } catch (IllegalArgumentException e) {
            assertNotNull(e.getMessage());
        }
    }

    @Test
    public void testNegativeAtkThrowsException() {
        try {
            new Roles(Roles.RoleType.WARRIOR, 100, -1, 10, 5, 5);
            fail("Expected exception was not thrown.");
        } catch (IllegalArgumentException e) {
            assertNotNull(e.getMessage());
        }
    }

    @Test
    public void testNegativeDefThrowsException() {
        try {
            new Roles(Roles.RoleType.WARRIOR, 100, 10, -1, 5, 5);
            fail("Expected exception was not thrown.");
        } catch (IllegalArgumentException e) {
            assertNotNull(e.getMessage());
        }
    }

    @Test
    public void testNegativeStealthThrowsException() {
        try {
            new Roles(Roles.RoleType.WARRIOR, 100, 10, 10, -1, 5);
            fail("Expected exception was not thrown.");
        } catch (IllegalArgumentException e) {
            assertNotNull(e.getMessage());
        }
    }

    @Test
    public void testNegativeIntelThrowsException() {
        try {
            new Roles(Roles.RoleType.WARRIOR, 100, 10, 10, 5, -1);
            fail("Expected exception was not thrown.");
        } catch (IllegalArgumentException e) {
            assertNotNull(e.getMessage());
        }
    }

    @Test
    public void testEnumCoverage() {
        for (Roles.RoleType type : Roles.RoleType.values()) {
            assertNotNull(Roles.RoleType.valueOf(type.name()));
        }
        for (Roles.Gender gender : Roles.Gender.values()) {
            assertNotNull(Roles.Gender.valueOf(gender.name()));
        }
    }
}