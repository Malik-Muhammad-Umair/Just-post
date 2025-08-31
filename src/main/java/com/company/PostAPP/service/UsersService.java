package com.company.PostAPP.service;

import com.company.PostAPP.entity.Users;
import com.company.PostAPP.repository.UsersRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class UsersService {

    private final UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }
    public Users saveUser(String name, String email, String post, MultipartFile file) {
        try {
            Users user = new Users();
            user.setName(name);
            user.setEmail(email);
            user.setPost(post);
            user.setDisplayPicture(file.getBytes()); // DB me file as BLOB

            return usersRepository.save(user);
        } catch (Exception e) {
            throw new RuntimeException("File saving failed: " + e.getMessage());
        }
    }


    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }
    public void deleteUser(Long id){
        usersRepository.deleteById(id);
    }
    public Users getUserbyid(Long id) {
        return usersRepository.findById(id).orElse(null);
    }
    public Users UpdatePost(Users users){
    return usersRepository.save(users);
    }
}
