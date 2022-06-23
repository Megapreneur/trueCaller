package africa.semicolon.trueCaller.controllers;

import africa.semicolon.trueCaller.services.ContactService;
import africa.semicolon.trueCaller.services.ContactServiceImpl;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
public class ContactController {

    private ContactService contactService = new ContactServiceImpl();


    @PostMapping("/contact")
    public String addContact(@RequestBody RequestDto requestDto){
        contactService.addContact(requestDto.getFirstName(), requestDto.getLastName(), requestDto.getPhoneNumber());
        return "Added successfully";
    }
    @GetMapping("/contact/{firstName}")
    public String findByName(@PathVariable String name){
        return contactService.findByName(name).toString();
    }

}

@Data
@NoArgsConstructor
class RequestDto{
    private String firstName;
    private String lastName;
    private String phoneNumber;
}
