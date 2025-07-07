// MessageController.java
package com.social.social_backend.controller;

import com.social.social_backend.model.Message;
import com.social.social_backend.model.MessageRequest;
import com.social.social_backend.model.MessageResponse;
import com.social.social_backend.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @PostMapping("")
    public ResponseEntity<MessageResponse> sendMessage(@RequestBody MessageRequest request) {
        // Validación básica
        if (request.getSenderUserId() == null || request.getSenderUserId().isEmpty()) {
            return ResponseEntity.badRequest().body(
                    new MessageResponse(false, "El remitente es requerido", null, null));
        }

        MessageResponse response = messageService.sendMessage(request);

        return response.isSuccess() ?
                ResponseEntity.status(HttpStatus.CREATED).body(response) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @GetMapping("/private")
    public ResponseEntity<List<Message>> getPrivateMessages(
            @RequestParam String userId1,
            @RequestParam String userId2) {

        try {
            List<Message> messages = messageService.getPrivateMessages(userId1, userId2);
            return ResponseEntity.ok(messages);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @GetMapping("/group/{groupId}") //http://localhost:9091/api/messages/private?userId1=00001&userId2=00002
    public ResponseEntity<List<Message>> getGroupMessages(@PathVariable Integer groupId) {
        List<Message> messages = messageService.getGroupMessages(groupId);
        return ResponseEntity.ok(messages);
    }
}