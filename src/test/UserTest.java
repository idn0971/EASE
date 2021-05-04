import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void setAndGetFirstName() {
        User usr = new User();
        usr.setFirstName("test");
        assertEquals("test", usr.getFirstName());
    }

    @Test
    void setAndGetLastName() {
        User usr = new User();
        usr.setLastName("test");
        assertEquals("test", usr.getLastName());
    }

    @Test
    void setAndGetUserName() {
        User usr = new User();
        usr.setUserName("test");
        assertEquals("test", usr.getUserName());
    }

    @Test
    void setAndGetPassword() {
        User usr = new User();
        usr.setPassword("test");
        assertEquals("test", usr.getPassword());
    }

    @Test
    void setAndGetAdmin() {
        User usr = new User();
        usr.setAdmin(true);
        assertEquals(true, usr.getIsAdmin());
    }

    @Test
    void setAndGetAccess() {
        User usr = new User();
        usr.setAccess(true);
        assertEquals(true, usr.getAccess());
    }

    @Test
    void setAndGetVerify() {
        User usr = new User();
        usr.setAccess(true);
        assertEquals(true, usr.getAccess());
    }
}