package com.company.PostAPP.controller;

import com.company.PostAPP.entity.Register;
import com.company.PostAPP.service.RegisterService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/login")
@CrossOrigin("*")
public class RegisterController {
    private final RegisterService registerService;

    public RegisterController(RegisterService registerService) {
        this.registerService = registerService;
    }
    @PostMapping("/info")
    public Register PostInfo(@RequestBody Register register){
        return registerService.postInfo(register);
    }
    @GetMapping("/infos")
    public List<Register> getallrecords(){
        return registerService.getAllrecords();
    }
}

