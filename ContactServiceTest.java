import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ContactServiceTest {
    private ContactService contactService;

    @Before
    public void setup() {
        contactService = new ContactService();
    }

    @Test
    public void addAndRetrieveContact() {
        contactService.addContact("ID12345", "John", "Doe", "1234567890", "123 Main St");
        Contact retrieved = contactService.getContact("ID12345");
        assertNotNull(retrieved);
        assertEquals("John", retrieved.getFirstName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void addDuplicateContactId() {
        contactService.addContact("ID12345", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact("ID12345", "Jane", "Doe", "9876543210", "456 Elm St");
    }

    @Test
    public void updateExistingContact() {
        contactService.addContact("ID12345", "John", "Doe", "1234567890", "123 Main St");
        contactService.updateContact("ID12345", "Jane", "Smith", "9876543210", "456 Elm St");
        Contact updated = contactService.getContact("ID12345");
        assertEquals("Jane", updated.getFirstName());
        assertEquals("Smith", updated.getLastName());
        assertEquals("
