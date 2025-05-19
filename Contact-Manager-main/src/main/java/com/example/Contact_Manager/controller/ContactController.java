package com.example.Contact_Manager.controller;

import com.example.Contact_Manager.entities.Contact;
import com.example.Contact_Manager.entities.Myuser;
import com.example.Contact_Manager.repositories.ContactRepositories;
import com.example.Contact_Manager.service.UserServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class ContactController {
    @Autowired
    ContactRepositories contactRepositories;

    @Autowired
    UserServicesImpl userServices;

    @GetMapping("/home/addcontact")
    String addContact(Model model)
    {
        model.addAttribute("contact",new Contact());
        return "AddContact";
    }

    @PostMapping("/home/user/contact-handler")
    String handleContact(@ModelAttribute Contact contact) {
        String currentUserEmail = userServices.getCurrentUserEmail();
        Myuser myuser = userServices.retriveUserByEmail(currentUserEmail);

        if (contact.getC_id() != 0) {
            Optional<Contact> existingContact = contactRepositories.findById(contact.getC_id());
            if (existingContact.isPresent()) {
                Contact c = existingContact.get();
                c.setDob(contact.getDob());
                c.setFirstName(contact.getFirstName());
                c.setLastName(contact.getLastName());
                c.setRelation(contact.getRelation());
                c.setAddress(contact.getAddress());
                c.setDescription(contact.getDescription());
                c.setMb_no(contact.getMb_no());
                contactRepositories.save(c);
                return "redirect:/home";
            }
        }

        contact.setUser(myuser);
        contactRepositories.save(contact);

        if (myuser.getContacts() == null) {
            myuser.setContacts(new ArrayList<>());
        }
        myuser.getContacts().add(contact);

        userServices.updateUserContacts(myuser.getId(), myuser.getContacts());
        return "redirect:/home";
    }


    @GetMapping("/home/contact/delete/{id}")
    public String deleteContact(@PathVariable("id") int c_id)
    {
        Optional <Contact>opt_contact = contactRepositories.findById(c_id);
        Contact contact = opt_contact.get();

        Myuser myuser = contact.getUser();

        List<Contact>list = myuser.getContacts();
        list.remove(contact);
        myuser.setContacts(list);
        userServices.updateUserContacts(myuser.getId(),list);
        System.out.println(list);
        return "redirect:/home";
    }

    @GetMapping("/home/contact/update/{id}")
    public  String updateContact(@PathVariable("id") int id , Model model)
    {
        Optional<Contact>optionalContact = contactRepositories.findById(id);
        Contact contact = optionalContact.get();
        model.addAttribute("contact",contact);
        return "AddContact";
    }

}
