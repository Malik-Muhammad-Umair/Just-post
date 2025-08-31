package com.company.PostAPP.service;

import com.company.PostAPP.entity.Register;
import com.company.PostAPP.repository.Registerrepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegisterService {
    private  final Registerrepository registerrepository;

    public RegisterService(Registerrepository registerrepository) {
        this.registerrepository = registerrepository;
    }
public Register postInfo(Register register){
        return registerrepository.save(register);
}
public List<Register> getAllrecords(){
        return  registerrepository.findAll();
}
}
