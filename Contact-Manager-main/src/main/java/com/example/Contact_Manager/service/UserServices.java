package com.example.Contact_Manager.service;

import com.example.Contact_Manager.entities.Contact;
import com.example.Contact_Manager.entities.Myuser;

import java.util.List;

public interface UserServices {
    Myuser SaveUser(Myuser myuser);
    Myuser UpdateUser(Myuser myuser,int user_id);
    List<Myuser> RetriveAll();
    void DeleteUser(int user_Id);
    List<Contact>retriveContact(Long UserId);
    String getCurrentUserEmail();
    Myuser retriveUserByEmail(String email);

   
}
