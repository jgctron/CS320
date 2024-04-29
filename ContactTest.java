import org.junit.Test;
import static org.junit.Assert.*;

public class ContactTest {
    @Test
    public void testContact() {
        Contact contact = new Contact("ID123", "John", "Doe", "1234567890", "123 Main St");
        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Main St", contact.getAddress());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidContactId() {
        new Contact(null, "John", "Doe", "1234567890", "123 Main St");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidFirstName() {
        new Contact("ID123", "", "Doe", "1234567890", "123 Main St");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidLastName() {
        new Contact("ID123", "John", "", "1234567890", "123 Main St");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidPhone() {
        new Contact("ID123", "John", "Doe", "123", "123 Main St");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidAddress() {
        new Contact("ID123", "John", "Doe &#8203;``【oaicite:0】``&#8203;
