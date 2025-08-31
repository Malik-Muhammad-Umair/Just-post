package com.company.PostAPP.controller;

import com.company.PostAPP.entity.Users;
import com.company.PostAPP.repository.UsersRepository;
import com.company.PostAPP.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class UsersController {



    private final UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @PostMapping("/user")
    public ResponseEntity<Users> postUsers(
            @RequestParam("name") String name,
            @RequestParam("email") String email,
            @RequestParam("post") String post,
            @RequestParam("file") MultipartFile file) {

        try {
            Users saved = usersService.saveUser(name, email, post, file);

            // response me file bytes hide karna ho to null set kar do
            saved.setDisplayPicture(null);

            return ResponseEntity.ok(saved);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("users")
    private List<Users> getAUsers(){
        return usersService.getAllUsers();
    }
    @GetMapping("/user/{id}")
       public ResponseEntity<Users> getUustomerbyid(@PathVariable Long id) {
    Users user= usersService.getUserbyid(id);
    if(user==null){
      return   ResponseEntity.notFound().build();
    }
    else {
        return ResponseEntity.ok(user);
    }
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> deletecustomer(@PathVariable Long id){
Users existinguser=usersService.getUserbyid(id);
if(existinguser==null) {


    return ResponseEntity.notFound().build();
}
else {
     usersService.deleteUser(id);
     return  ResponseEntity.ok().build();
}
    }
    @PutMapping("/user/{id}")
    public ResponseEntity<Users> updatepost(@PathVariable Long id ,@RequestBody Users users){
        Users existinguser=usersService.getUserbyid(id);
        if(existinguser==null) {


            return ResponseEntity.notFound().build();
        }
        else {
            existinguser.setName(users.getName());
            existinguser.setEmail(users.getEmail());
            existinguser.setPost(users.getPost());
           Users updateduser= usersService.UpdatePost(existinguser);
        return ResponseEntity.ok(updateduser);
        }

    }

}
