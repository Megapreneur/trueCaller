package africa.semicolon.trueCaller.data.repositories;

import africa.semicolon.trueCaller.data.models.Contact;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ContactRespositoryImplTest {
    private ContactRepository contactRepository;

    @BeforeEach public  void startWithThis(){
        contactRepository = new ContactRespositoryImpl();
    }
    @Test
    public void saveContactCountIsOneTest(){
        Contact newContact = new Contact();
        newContact.setFirstName("Ade");

        Contact savedContact = contactRepository.save(newContact);
        assertEquals(1, savedContact.getId());
        assertEquals(1, contactRepository.count());
    }
    @Test
    public void saveContactTwice_countIsTwoTest(){
        Contact contact = new Contact();
        contact.setFirstName("Ade");

        Contact contact1 = new Contact();
        contact1.setFirstName("sam");

        Contact savedContact = contactRepository.save(contact);
        assertEquals(1, savedContact.getId());
        Contact savedContact1 = contactRepository.save(contact1);
        assertEquals(2, savedContact1.getId());
        assertEquals(2, contactRepository.count());
    }
    @Test
    public void saveContact_findByIdReturnsContact(){
        Contact contact = new Contact();
        contact.setFirstName("ade");
        Contact contact1 = new Contact();
        contact1.setFirstName("ayo");
        Contact savedContact = contactRepository.save(contact);
        Contact savedContact1 = contactRepository.save(contact1);

        Contact foundContact = contactRepository.findById(1);

        assertEquals(1, foundContact.getId());
        assertEquals("ade", foundContact.getFirstName());
    }
    @Test
    public void saveContact_findByNameReturnsContact(){
        Contact contact = new Contact();
        contact.setFirstName("ade");
        contact.setLastName("ayo");
        Contact contact1 = new Contact();
        contact1.setFirstName("ayo");
        contact1.setLastName("seun");
        Contact contact2 = new Contact();
        contact2.setLastName("ayo");
        contact2.setFirstName("tola");
        Contact savedContact = contactRepository.save(contact);
        Contact savedContact1 = contactRepository.save(contact1);
        Contact savedContact2 = contactRepository.save(contact2);
        assertEquals(3 , contactRepository.count());

        ArrayList<Contact> foundContact = contactRepository.findByName("ayo");
        assertEquals(3, foundContact.size());
        assertEquals("", foundContact.toString());
    }

    @Test
    public void saveContact_findByPhoneNumberReturnsContact(){
        Contact contact = new Contact();
        contact.setLastName("ade");
        contact.setLastName("meg");
        contact.setPhoneNumber("08137382895");

        Contact contact1 = new Contact();
        contact1.setFirstName("seun");
        contact1.setLastName("tola");
        contact1.setPhoneNumber("08137382896");
        Contact savedContact = contactRepository.save(contact);
        Contact savedContact1 = contactRepository.save(contact1);

        assertEquals(2, contactRepository.count());
        Contact searchedName = contactRepository.findByPhoneNumber("08137382896");
        assertEquals("08137382896", searchedName.getPhoneNumber());
    }
    @Test
    public void saveContact_findContactAndDeleteContactReturnContactSize(){
        Contact newContact = new Contact();
        newContact.setFirstName("Nut");
        newContact.setLastName("Meg");
        Contact savedContact = contactRepository.save(newContact);
        assertEquals(1, contactRepository.count());


        Contact newContact1 = new Contact();
        newContact1.setFirstName("Ola");
        newContact1.setLastName("Mee");
        Contact savedContact1 = contactRepository.save(newContact1);
        assertEquals(2, contactRepository.count());


        Contact newContact2 = new Contact();
        newContact2.setFirstName("Niyi");
        newContact2.setLastName("Toye");
      Contact savedContact2 = contactRepository.save(newContact2);
        assertEquals(3, contactRepository.count());

        ArrayList<Contact> searchedName = contactRepository.findByName("Nut");
        contactRepository.delete(savedContact1);
        assertEquals(2, contactRepository.count());
    }
    @Test
    public void saveContact_updateContactAndReturnNewContact(){
        Contact newContact = new Contact();
        newContact.setFirstName("Nut");
        newContact.setLastName("Meg");
        Contact savedContact = contactRepository.save(newContact);
        assertEquals(1, contactRepository.count());

        Contact newContact1 = new Contact();
        newContact1.setFirstName("Ola");
        newContact1.setLastName("Mee");
        Contact savedContact1 = contactRepository.save(newContact1);
        assertEquals(2, contactRepository.count());

        Contact newContact2 = new Contact();
        newContact2.setFirstName("Niyi");
        newContact2.setLastName("Toye");
        Contact savedContact2 = contactRepository.save(newContact2);
        assertEquals(3, contactRepository.count());

    }

}