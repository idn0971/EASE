import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoginTest {

    @Test
    void createAndFindUser() {
        String testUsername = "test";
        String testPassword = "test";
        User testUser = new User();
        Login test = new Login();
        test.createUser(testUsername, testPassword);
        testUser = test.findUser(testUsername, testPassword);
        assertEquals(testUsername, testUser.getUserName());
        assertEquals(testPassword, testUser.getPassword() );
    }

}