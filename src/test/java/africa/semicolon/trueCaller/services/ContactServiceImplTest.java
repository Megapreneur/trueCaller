//package africa.semicolon.trueCaller.services;
//
//import africa.semicolon.trueCaller.data.models.Contact;
//import africa.semicolon.trueCaller.data.repositories.ContactRepository;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import java.util.ArrayList;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class ContactServiceImplTest {
//    private ContactRepository contactRepository;
//    private ContactService contactService;
//    @BeforeEach
//    public void setUp(){
//        contactRepository = new ContactRespositoryImpl();
//        contactService = new ContactServiceImpl();
//    }
//    @Test
//    public void saveContact_findContactReturnsContact(){
//        contactService.addContact("Ademola", "Megbabi", "08137382895");
//        Contact contact =  contactService.findById(1);
//        assertEquals("Ademola", contact.getFirstName());
//        assertEquals(1, contactService.count());
//    }
//    @Test
//    public void testThatMultipleContactsCanBESaved(){
//        contactService.addContact("Ademola", "Megbabi", "08099993333");
//        contactService.addContact("Ade", "Meg", "08122223333");
//        assertEquals(2, contactService.count());
//    }
//    @Test
//    public void saveContact_findContactByNameAndReturnListOfContact(){
//        contactService.addContact("Ademola", "Megbabi", "08099993333");
//        contactService.addContact("Ade", "Meg", "08122223333");
//        contactService.addContact("ola", "babi", "08123423333");
//        ArrayList<Contact> contact = contactService.findByName("Ade");
//        assertEquals(1, contact.size());
//    }
//    @Test
//    public void saveContact_findContactByPhoneNumberAndReturnContactTest(){
//        contactService.addContact("Ademola", "Megbabi", "08099993333");
//        contactService.addContact("Ade", "Meg", "08122223333");
//        contactService.addContact("ola", "babi", "08123423333");
//
//        Contact contact = contactService.findByPhoneNumber("08099993333");
//
//        assertEquals("Ademola", contact.getFirstName());
//    }
//    @Test
//    public void testThatASavedContactCanBeUpdated(){
//        contactService.addContact("Ademola", "Megbabi", "08099993333");
//        contactService.addContact("Ade", "Meg", "08122223333");
//        contactService.addContact("ola", "babi", "08123423333");
//
//        Contact contact = contactService.findById(2);
//        contact.setFirstName("seun");
//        contact.setLastName("leo");
//        Contact newContact = contactService.update(contact);
//
//        assertEquals(2, newContact.getId());
//        assertEquals(3, contactService.count());
//    }
//    @Test
//    public void testThatASavedContactCanBeDeleted(){
//        contactService.addContact("Ademola", "Megbabi", "08099993333");
//        contactService.addContact("Ade", "Meg", "08122223333");
//        contactService.addContact("ola", "babi", "08123423333");
//
//        Contact contact = contactService.findById(3);
//        contactService.delete(contact);
//        assertEquals(2, contactService.count());
//    }
//    @Test
//    public void findMyName(){
//        contactService.addContact("bola", "faith", "1234");
//        contactService.addContact("bae", "bola","4567");
//        contactService.addContact("tola", "peace", "1567");
//
//        Contact contact = contactService.findById(2);
//        assertEquals("bae", contact.getFirstName());
//
//        contactService.delete(contact);
//
//        assertEquals(2, contactService.count());
//        Contact contact1 = contactService.findById(1);
//        assertEquals("bola", contact1.getFirstName());
//
//        contactService.addContact("Segun","seyi", "0999");
//        assertEquals(3, contactService.count());
//        Contact contact2 = contactService.findById(3);
//        assertEquals("tola", contactService.findByName("tola"));
//
//    }
//
//}