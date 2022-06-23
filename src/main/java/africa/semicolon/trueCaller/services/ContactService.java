package africa.semicolon.trueCaller.services;

import africa.semicolon.trueCaller.data.models.Contact;

import java.util.ArrayList;

public interface ContactService {
    void addContact(String firstName, String lastName, String phoneNumber);

    Contact findById(int id);

    int count();

    ArrayList<Contact> findByName(String name);

    Contact findByPhoneNumber(String phoneNumber);

    Contact update(Contact contact);

    void delete(Contact contact);
}
