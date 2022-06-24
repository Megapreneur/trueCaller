package africa.semicolon.trueCaller.services;

import africa.semicolon.trueCaller.data.models.Contact;

import java.util.List;

public interface ContactService {
    void addContact(String firstName, String lastName, String phoneNumber);


    List<Contact> findName(String name);

    Contact findById(String id);

    Contact findByPhoneNumber(String phoneNumber);

    Contact update(Contact contact);

    void delete(Contact contact);
}
