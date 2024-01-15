package com.example.backend_chat.test;

import com.example.backend_chat.entities.Account;
import com.example.backend_chat.entities.Profile_User;
import com.example.backend_chat.respositoryInterface.Account_Respository;
import com.example.backend_chat.service.serviceImp.Account_Service_Imp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@Component
public class Test_Account implements CommandLineRunner
{

    private final Account_Service_Imp account_service_imp;
    @Autowired
    public Test_Account(Account_Service_Imp account_service_imp) {
        this.account_service_imp=account_service_imp;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(account_service_imp.getString_ListAccount());
        String path="src/main/images/doraemon.png";

        Profile_User profile1 =new Profile_User("0971646631", "Van Hoa", true, "ahnn@gmail.com",java.sql.Date.valueOf("2024-01-09"), convertImageToByteArray(path));
        //
        Account account1=new Account("123","ManMinh");
        account_service_imp.addAccount(account1);
    }
    public byte[] convertImageToByteArray(String imagePath) {
        byte[] imageBytes = null;
        File file = new File(imagePath);
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            imageBytes = new byte[(int) file.length()];
            fileInputStream.read(imageBytes);
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return imageBytes;
    }
}
