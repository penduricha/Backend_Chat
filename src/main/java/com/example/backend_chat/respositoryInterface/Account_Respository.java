package com.example.backend_chat.respositoryInterface;



import com.example.backend_chat.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Account_Respository extends JpaRepository<Account,Long>
{
}
