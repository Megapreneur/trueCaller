package africa.semicolon.trueCaller.controllers;

import africa.semicolon.trueCaller.services.ContactService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ContactController {

    @Autowired
    private  ContactService contactService;
    @PostMapping("/contact")
    public String addContact(@RequestBody RequestDto requestDto){
        contactService.addContact(requestDto.getFirstName(), requestDto.getLastName(), requestDto.getPhoneNumber());
        return "Added successfully";
    }
    @GetMapping("/contact/{firstName}")
    public String findByFirstName(@PathVariable String firstName){
        return contactService.findName(firstName).toString();
    }
}
@Data
@NoArgsConstructor
@AllArgsConstructor
class RequestDto{
    private String firstName;
    private String lastName;
    private String phoneNumber;
}
