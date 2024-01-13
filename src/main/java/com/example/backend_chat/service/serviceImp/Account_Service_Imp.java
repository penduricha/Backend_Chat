package com.example.backend_chat.service.serviceImp;

import com.example.backend_chat.entities.Account;
import com.example.backend_chat.respositoryInterface.Account_Respository;
import com.example.backend_chat.service.Account_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Account_Service_Imp implements Account_Service
{
    private final Account_Respository account_respository;
    @Autowired
    public Account_Service_Imp(Account_Respository account_respository) {
        this.account_respository = account_respository;
    }

    @Override
    public String getString_ListAccount() {
        String s="";
        List<Account> listAccount=getListAccount();
        for(Account a: listAccount)
            s+=a.toString();
        return s;
    }

    @Override
    public List<Account> getListAccount() {
        return account_respository.findAll();
    }

    @Override
    public boolean addAccount(Account account) {
        try {
            account_respository.save(account);
            System.out.println("Thêm thành công.");
            return true;
        } catch (Exception e) {
            // Xử lý ngoại lệ hoặc ghi log nếu cần thiết
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean deleteAccount() {
        return false;
    }
}
