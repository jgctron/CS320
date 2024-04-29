public class ContactService {
    private HashMap<String, Contact> contacts;

    public ContactService() {
        contacts = new HashMap<>();
    }

    public void addContact(String contactId, String firstName, String lastName, String phone, String address) {
        Contact contact = new Contact(contactId, firstName, lastName, phone, address);
        if (contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact ID already exists.");
        }
        contacts.put(contactId, contact);
    }

    public Contact getContact(String contactId) {
        return contacts.get(contactId);
    }

    public void updateContact(String contactId, String firstName, String lastName, String phone, String address) {
        Contact contact = contacts.get(contactId);
        if (contact == null) {
            throw new IllegalArgumentException("Contact does not exist.");
        }
        contact.setFirstName(firstName);
        contact.setLastName(lastName);
        contact.setPhone(phone);
        contact.setAddress(address);
    }

    public void deleteContact(String contactId) {
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact does not exist.");
        }
        contacts.remove(contactId);
    }
}
