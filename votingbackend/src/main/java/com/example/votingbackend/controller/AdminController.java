package com.example.votingbackend.controller;

import com.example.votingbackend.model.Admin;
import com.example.votingbackend.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/login")
    public ResponseEntity<?> loginAdmin(@RequestBody Admin loginRequest) {
        Admin admin = adminService.loginAdmin(loginRequest.getEmail(), loginRequest.getPassword());

        if (admin == null) {
            return ResponseEntity.badRequest().body("Invalid email or password");
        }

        return ResponseEntity.ok(admin);
    }
}
