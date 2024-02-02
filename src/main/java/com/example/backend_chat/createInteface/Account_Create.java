package com.example.backend_chat.createInteface;

import com.example.backend_chat.entities.Account;


import org.springframework.data.repository.CrudRepository;

public interface Account_Create extends CrudRepository<Account,Long>
{

}
