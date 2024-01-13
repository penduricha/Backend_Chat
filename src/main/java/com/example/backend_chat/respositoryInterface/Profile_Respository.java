package com.example.backend_chat.respositoryInterface;





import com.example.backend_chat.entities.Profile_User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Profile_Respository extends JpaRepository<Profile_User,Long>
{
}
