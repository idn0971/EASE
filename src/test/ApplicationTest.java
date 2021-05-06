import org.junit.jupiter.api.Test;

import java.util.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ApplicationTest {

    @Test
    void getAndSetName() {
        Application app = new Application();
        app.setName("test");
        assertEquals("test",app.getName() );
    }

    @Test
    void getAndSetUserAdded() {
        Application app = new Application();
        app.setUserAdded("test");
        assertEquals("test",app.getUserAdded() );
    }



    @Test
    void getAndSetDateAdded() {
        Application app = new Application();
        app.setDateAdded("test");
        assertEquals("test",app.getDateAdded() );
    }

    @Test
    void getAndSetDescription() {
        Application app = new Application();
        app.setDescription("test");
        assertEquals("test",app.getDescription() );
    }


    @Test
    void getAndSetOrganization() {
        Application app = new Application();
        app.setOrganization("test");
        assertEquals("test",app.getOrganization() );
    }

    @Test
    void getAndSetLink() {
        Application app = new Application();
        app.setLink("test");
        assertEquals("test",app.getLink() );
    }


    @Test
    void getAndSetPrice() {
        Application app = new Application();
        app.setPrice(1.11);
        assertEquals(1.11, app.getPrice() );
    }



    @Test
    void isAndSetVerified() {
        Application app = new Application();
        app.setVerified(true);
        assertEquals(true,app.isVerified() );
    }

    @Test
    void getAndSetPlatformNversion() {
        Application app = new Application();
        Map<String, List<String>> test = new HashMap<String, List<String>>();
        List<String> testList = new ArrayList<String>();
        testList.add("test");
        test.put("test", testList);
        app.setPlatformNversion(test);
        assertEquals(test,app.getPlatformNversion() );
        }

        }