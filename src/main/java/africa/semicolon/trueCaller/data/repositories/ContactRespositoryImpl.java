package africa.semicolon.trueCaller.data.repositories;

import africa.semicolon.trueCaller.data.models.Contact;

import java.util.ArrayList;
import java.util.List;

public class ContactRespositoryImpl implements ContactRepository{
    List<Contact> contacts = new ArrayList<>();
    @Override
    public Contact save(Contact contact) {
        if (contact.getId() != 0){
            update(contact);
        }else {
            contact.setId(contacts.size()+ 1);
            contacts.add(contact);
            return contact;
        }
        return contact;

    }

    @Override
    public int count() {
        return contacts.size();
    }



    @Override
    public Contact findById(int id) {
        return contacts.get(id - 1);
    }

    @Override
    public ArrayList<Contact> findByName(String name) {
        ArrayList<Contact> duplicatedNames = new ArrayList<>();
        for (Contact contact : contacts) {
            if (name.equalsIgnoreCase(contact.getFirstName()) || name.equalsIgnoreCase(contact.getLastName())) {
                duplicatedNames.add(contact);
            }
        }
        return duplicatedNames;
    }

    @Override
    public void delete(Contact contact) {
        contacts.remove(contact);
    }

    private Contact update(Contact contact) {
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
