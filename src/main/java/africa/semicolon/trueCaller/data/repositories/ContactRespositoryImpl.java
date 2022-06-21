package africa.semicolon.trueCaller.data.repositories;

import africa.semicolon.trueCaller.data.models.Contact;

import java.util.ArrayList;
import java.util.List;

public class ContactRespositoryImpl implements ContactRepository{
    List<Contact> contacts = new ArrayList<>();
    @Override
    public Contact save(Contact contact) {
        contact.setId(contacts.size()+ 1);
        contacts.add(contact);
        return contact;
    }

    @Override
    public int count() {
        return contacts.size();
    }

    @Override
    public Contact findByFirstName(String firstName) {
        Contact contact;
        for (int i = 0; i < contacts.size(); i++) {
            contact = contacts.get(i);
            if(firstName.equalsIgnoreCase(contact.getFirstName())){
                return contact;
            }
        }
        throw new NullPointerException("Contact not found");
    }

    @Override
    public Contact findById(int id) {
        return contacts.get(id - 1);
    }

    @Override
    public Contact findByLastName(String lastName) {
        Contact contact;
        for (Contact value : contacts) {
            contact = value;
            if (lastName.equals(contact.getLastName())) {
                return contact;
            }
        }
        throw new NullPointerException("Contact not found");
    }

    @Override
    public void delete(Contact contact) {
        contacts.remove(contact);
    }

    @Override
    public Contact update(Contact contact) {
        contacts.set(contact.getId() - 1,contact);
        return contact;
    }

    @Override
    public Contact findByPhoneNumber(String phoneNumber) {
        Contact contact = new Contact();
        for (Contact number : contacts){
            contact = number;
            if (phoneNumber.equals(contact.getPhoneNumber())){
                return contact;
            }
        }
        throw new NullPointerException("Contact not found");
    }
}
