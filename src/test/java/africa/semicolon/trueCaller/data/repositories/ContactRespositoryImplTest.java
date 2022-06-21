package africa.semicolon.trueCaller.data.repositories;

import africa.semicolon.trueCaller.data.models.Contact;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ContactRespositoryImpliTest {
    private ContactRepository contactRepository;

    @BeforeEach public  void startWithThis(){
        contactRepository = new ContactRespositoryImpl();
    }
    @Test
    public void saveContactCountIsOneTest(){
        Contact contact = new Contact();
        contact.setFirstName("Ade");

        Contact savedContact = contactRepository.save(contact);
        assertEquals(1, savedContact.getId());
        assertEquals(1, contactRepository.count());


    }

}