package africa.semicolon.trueCaller.services;

import africa.semicolon.trueCaller.data.models.Contact;
import africa.semicolon.trueCaller.data.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ContactServiceImpl implements ContactService{
    @Autowired
    private ContactRepository contactRepository;

    @Override
    public void addContact(String firstName, String lastName, String phoneNumber) {
        Contact contact = new Contact(firstName, lastName, phoneNumber);
        contactRepository.save(contact);
    }
    @Override
    public Contact findById(String id) {
        Optional<Contact> found = contactRepository.findById(id);
        if(found.isEmpty()) throw new NoContactException("Contact not found");
        return found.get();
    }
    public List<Contact> findName(String name) {
            List<Contact> result = new ArrayList<>();
            result.addAll(contactRepository.findContactByFirstName(name));
            result.addAll(contactRepository.findContactByLastName(name));
            return result;
    }
    @Override
    public Contact findByPhoneNumber(String phoneNumber) {
        return contactRepository.findByPhoneNumber(phoneNumber);
    }

    @Override
    public Contact update(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public void delete(Contact contact) {
        contactRepository.delete(contact);
    }
}
