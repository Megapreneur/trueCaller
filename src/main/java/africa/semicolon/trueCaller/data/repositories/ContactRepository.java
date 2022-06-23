package africa.semicolon.trueCaller.data.repositories;

import africa.semicolon.trueCaller.data.models.Contact;

import java.util.ArrayList;

public interface ContactRepository {
    Contact save(Contact contact);
    int count();

    Contact findById(int id);

    ArrayList<Contact> findByName(String name);

    void delete(Contact contact);

    Contact findByPhoneNumber(String phoneNumber);

}
