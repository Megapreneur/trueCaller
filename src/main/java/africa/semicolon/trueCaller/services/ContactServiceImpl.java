package africa.semicolon.trueCaller.services;

import africa.semicolon.trueCaller.data.models.Contact;
import africa.semicolon.trueCaller.data.repositories.ContactRepository;
import africa.semicolon.trueCaller.data.repositories.ContactRespositoryImpl;

import java.util.ArrayList;

public class ContactServiceImpl implements ContactService{
    private final ContactRepository contactRepository = new ContactRespositoryImpl();

    @Override
    public void addContact(String firstName, String lastName, String phoneNumber) {
        Contact contact = new Contact(firstName, lastName, phoneNumber);
        contactRepository.save(contact);
    }
    @Override
    public Contact findById(int id) {
        return contactRepository.findById(id);
    }

    @Override
    public int count() {
        return contactRepository.count();
    }

    public ArrayList<Contact> findByName(String name) {
        return contactRepository.findByName(name);
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
