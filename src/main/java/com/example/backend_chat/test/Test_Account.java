package com.example.backend_chat.test;

import com.example.backend_chat.respositoryInterface.Account_Respository;
import com.example.backend_chat.service.serviceImp.Account_Service_Imp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

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
    }
}
