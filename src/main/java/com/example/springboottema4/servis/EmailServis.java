package com.example.springboottema4.servis;

import java.io.File;

public interface EmailServis {
    void sendEmail(String toUser,String subject, String message);


    void sendEmailWihtFile(String toUser, String subject, String message, File file);
}
