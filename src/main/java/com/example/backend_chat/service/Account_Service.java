package com.example.backend_chat.service;

import com.example.backend_chat.entities.Account;
import java.util.List;
public interface Account_Service {
    public String getString_ListAccount();
    public List<Account> getListAccount();
    public boolean addAccount(Account account);
    public boolean deleteAccount();
}
