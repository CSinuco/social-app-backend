// MessageService.java
package com.social.social_backend.service;

import com.social.social_backend.model.Message;
import com.social.social_backend.model.MessageRequest;
import com.social.social_backend.model.MessageResponse;
import com.social.social_backend.repository.MessageRepository;
import com.social.social_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private UserRepository userRepository;

    public MessageResponse sendMessage(MessageRequest request) {
        // Validar usuarios
        if (!userRepository.userExists(request.getSenderUserId())) {
            return new MessageResponse(false, "El remitente no existe", null, null);
        }

        if (request.getReceiverUserId() != null &&
                !userRepository.userExists(request.getReceiverUserId())) {
            return new MessageResponse(false, "El receptor no existe", null, null);
        }

        // Enviar mensaje
        Integer messageId = messageRepository.sendMessageWithContent(request);

        if (messageId != null && messageId > 0) {
            return new MessageResponse(true, "Mensaje enviado", messageId, LocalDateTime.now());
        }
        return new MessageResponse(false, "Error al enviar mensaje", null, null);
    }

    public List<Message> getPrivateMessages(String userId1, String userId2) {
        // Validar usuarios
        if (!userRepository.userExists(userId1) || !userRepository.userExists(userId2)) {
            throw new IllegalArgumentException("Uno o ambos usuarios no existen");
        }
        return messageRepository.getMessages(userId1, userId2);
    }

    public List<Message> getGroupMessages(Integer groupId) {
        // Aquí deberías validar si el grupo existe
        return messageRepository.getGroupMessages(groupId);
    }
}