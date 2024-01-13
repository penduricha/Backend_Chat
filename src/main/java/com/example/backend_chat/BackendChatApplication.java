package com.example.backend_chat;


import com.example.backend_chat.createInteface.Account_Create;
import com.example.backend_chat.createInteface.Profile_Create;
import com.example.backend_chat.entities.Account;
import com.example.backend_chat.entities.Profile_User;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;


@SpringBootApplication
public class BackendChatApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendChatApplication.class, args);
    }
    @Transactional
    @Bean
    public CommandLineRunner run(Account_Create account_create, Profile_Create profile_create) throws Exception{
        return (args -> {
            //Tạo đường dẫn hình ảnh
            String path="src/main/images/doraemon.png";

            Profile_User profile1 =new Profile_User("0971646635", "Van An Minh", true, "an@gmail.com",java.sql.Date.valueOf("2024-01-09"), convertImageToByteArray(path));
            //
            Account account1=new Account("123","Man");
            //set quan hệ
            profile1.setAccount(account1);
            account1.setProfile(profile1);

            profile_create.save(profile1);
        });
    }
    public static byte[] convertImageToByteArray(String imagePath) {
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
