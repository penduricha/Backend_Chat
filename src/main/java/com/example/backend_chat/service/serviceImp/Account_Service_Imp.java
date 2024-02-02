package com.example.backend_chat.service.serviceImp;

import com.example.backend_chat.entities.Account;
import com.example.backend_chat.respositoryInterface.Account_Respository;
import com.example.backend_chat.service.Account_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
            //System.out.println("Thêm thành công.");
            return true;
        } catch (Exception e) {
            // Xử lý ngoại lệ hoặc ghi log nếu cần thiết
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean deleteAccount(Long id_Account, String password) {
        try {
            Optional<Account> optionalAccount = account_respository.findById(id_Account);

            if (optionalAccount.isPresent()) {
                Account accountToDelete = optionalAccount.get();
                // Check if the provided password matches the account's password
                if (password.equals(accountToDelete.getPassword())) {
                    account_respository.delete(accountToDelete);
                    System.out.println("Xóa tài khoản thành công.");
                    return true;
                } else {
                    System.out.println("Sai mật khẩu. Không thể xóa tài khoản.");
                    return false;
                }
            } else {
                System.out.println("Không tìm thấy tài khoản để xóa.");
                return false;
            }
        } catch (Exception e) {
            // Xử lý ngoại lệ hoặc ghi log nếu cần thiết
            System.out.println("Lỗi khi xóa tài khoản: " + e.getMessage());
            return false;
        }
    }

}
