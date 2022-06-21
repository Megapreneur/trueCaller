package africa.semicolon.trueCaller.services;

import africa.semicolon.trueCaller.data.models.Contact;

public interface ContactService {
    void addContact(String firstName, String lastName, String phoneNumber);

    Contact findById(int id);

    int count();

    Contact findByFirstName(String firstName);

    Contact findByLastName(String lastName);

    Contact findByPhoneNumber(String phoneNumber);

    Contact update(Contact contact);

    void delete(Contact contact);
}
