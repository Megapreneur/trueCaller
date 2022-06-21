package africa.semicolon.trueCaller.services;

import africa.semicolon.trueCaller.data.models.Contact;
import africa.semicolon.trueCaller.data.repositories.ContactRepository;
import africa.semicolon.trueCaller.data.repositories.ContactRespositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactServiceImplTest {
    private ContactRepository contactRepository;
    private ContactService contactService;
    @BeforeEach
    public void setUp(){
        contactRepository = new ContactRespositoryImpl();
        contactService = new ContactServiceImpl(contactRepository);
    }
    @Test
    public void saveContact_findContactReturnsContact(){
        contactService.addContact("Ademola", "Megbabi", "08137382895");
        Contact contact =  contactService.findById(1);
        assertEquals("Ademola", contact.getFirstName());
        assertEquals(1, contactService.count());
    }
    @Test
    public void testThatMultipleContactsCanBESaved(){
        contactService.addContact("Ademola", "Megbabi", "08099993333");
        contactService.addContact("Ade", "Meg", "08122223333");
        assertEquals(2, contactService.count());
    }
    @Test
    public void saveContact_findContactByFirstNameAndReturnContact(){
        contactService.addContact("Ademola", "Megbabi", "08099993333");
        contactService.addContact("Ade", "Meg", "08122223333");
        contactService.addContact("ola", "babi", "08123423333");
        Contact contact = contactService.findByFirstName("Ade");
        assertEquals("Meg", contact.getLastName());
    }
    @Test
    public void saveContact_findContactByLastNameAndReturnContactTest(){
        contactService.addContact("Ademola", "Megbabi", "08099993333");
        contactService.addContact("Ade", "Meg", "08122223333");
        contactService.addContact("ola", "babi", "08123423333");
        Contact contact = contactService.findByLastName("babi");
        assertEquals(3, contact.getId());
    }
    @Test
    public void saveContact_findContactByPhoneNumberAndReturnContactTest(){
        contactService.addContact("Ademola", "Megbabi", "08099993333");
        contactService.addContact("Ade", "Meg", "08122223333");
        contactService.addContact("ola", "babi", "08123423333");

        Contact contact = contactService.findByPhoneNumber("08099993333");

        assertEquals("Ademola", contact.getFirstName());
    }
    @Test
    public void testThatASavedContactCanBeUpdated(){
        contactService.addContact("Ademola", "Megbabi", "08099993333");
        contactService.addContact("Ade", "Meg", "08122223333");
        contactService.addContact("ola", "babi", "08123423333");

        Contact contact = contactService.findById(2);
        contact.setFirstName("seun");
        contact.setLastName("leo");
        Contact newContact = contactService.update(contact);

        assertEquals(2, newContact.getId());
        assertEquals(3, contactService.count());
    }
    @Test
    public void testThatASavedContactCanBeDeleted(){
        contactService.addContact("Ademola", "Megbabi", "08099993333");
        contactService.addContact("Ade", "Meg", "08122223333");
        contactService.addContact("ola", "babi", "08123423333");

        Contact contact = contactService.findById(3);
        contactService.delete(contact);
        assertEquals(2, contactService.count());
    }

}