package com.example.backend_chat.createInteface;




import com.example.backend_chat.entities.Profile_User;
import org.springframework.data.repository.CrudRepository;

public interface Profile_Create extends CrudRepository<Profile_User,Long>
{
}
