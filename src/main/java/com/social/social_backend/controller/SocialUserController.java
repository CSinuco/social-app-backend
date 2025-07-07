package com.social.social_backend.controller;

import com.social.social_backend.model.ChatListResponse;
import com.social.social_backend.model.SocialUser;
import com.social.social_backend.service.SocialUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class SocialUserController {

    private final SocialUserService service;

    public SocialUserController(SocialUserService service) {
        this.service = service;
    }

    @GetMapping
    public List<SocialUser> getAllUsers() {
        return service.getAllUsers();
    }
    @GetMapping("/login/{iduser}")//http://localhost:9091/api/users/login/00001

    public ResponseEntity<?> loginUser(@PathVariable("iduser") String id) {
        SocialUser user = service.getUserById(id);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado");
        }
    }
    @PostMapping("/register")//http://localhost:9091/api/users/register
    public ResponseEntity<?> registerUser(@RequestBody SocialUser user) {
        boolean created = service.registerUser(user);
        if (created) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Usuario registrado exitosamente");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se pudo registrar el usuario");
        }
    }
    @GetMapping("/user/{id}/chats") //http://localhost:9091/api/users/user/00001/chats
    public ResponseEntity<?> getUserChats(@PathVariable("id") String userId) {
        ChatListResponse chats = service.getUserChats(userId);
        return ResponseEntity.ok(chats);
    }
}
