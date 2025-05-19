package com.example.Contact_Manager.controller;

import com.example.Contact_Manager.entities.Contact;
import com.example.Contact_Manager.entities.Myuser;
import com.example.Contact_Manager.service.UserServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.util.List;

@Controller
public class PageController {
    @Autowired
    UserServicesImpl userServices;

    @GetMapping("/home")
    public String getHome(Model model) {
        String email = userServices.getCurrentUserEmail();
        Myuser user =userServices.retriveUserByEmail(email);
        if(email != null)
        {
            List<Contact>contacts = user.getContacts();
            System.out.println(contacts);
            model.addAttribute("contacts",contacts);
            return "Contacts";
        }
        return "login";
    }

    @GetMapping("/home/profile")
    public String getProfile(Model model)
    {
        String currentUserEmail=userServices.getCurrentUserEmail();
        Myuser myuser = userServices.retriveUserByEmail(currentUserEmail);
        model.addAttribute("user",myuser);
        return "Profile";
    }


    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }

    @GetMapping ("/register")
    public String RegisterPage() {

        return "register";
    }
    @PostMapping ("/register-handle")
    public  String handleRegister(@ModelAttribute Myuser myuser ,Model model )
    {
        System.out.println(myuser.getPassword() +"  "+myuser.getRepassword());

        if(!(myuser.getPassword().equals(myuser.getRepassword())))
        {
            model.addAttribute("error","password and repeatpassword should be same!");
            return "redirect:/register";
        }
        //email check
        System.out.println(myuser.getEmail());
        Myuser user = userServices.SaveUser(myuser);
        System.out.println(user);
        return "redirect:/login";
    }
    @GetMapping("/users")
    @ResponseBody
    public List<Myuser>getAllUsers()
    {
        return userServices.RetriveAll();
    }

    @PutMapping("/update/{id}")
    @ResponseBody
    public Myuser updateUser(@RequestBody Myuser myuser,@PathVariable("id") int id)
    {
        return userServices.UpdateUser(myuser , id);
    }

    @DeleteMapping("delete/{id}")
    @ResponseBody
    public Myuser deleteUser(@PathVariable("id")int id)
    {
        Myuser user = userServices.FindUser(id);
        userServices.DeleteUser(id);
        return  user;
    }

    @GetMapping("/users/contact/{id}")
    @ResponseBody
    public  List<Contact> getAllUser(@PathVariable("id")int id)
    {
        List<Contact>contactList = userServices.retriveContact((long)id);
        if(contactList != null)
        {
            System.out.println(contactList);
            return  contactList;
        }
        return null;
    }


}