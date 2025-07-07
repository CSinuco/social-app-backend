package com.social.social_backend.service;

import com.social.social_backend.model.ChatListResponse;
import com.social.social_backend.model.FriendChat;
import com.social.social_backend.model.GroupChat;
import com.social.social_backend.model.SocialUser;
import com.social.social_backend.repository.SocialUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SocialUserService {

    private final SocialUserRepository repository;

    public SocialUserService(SocialUserRepository repository) {
        this.repository = repository;
    }
    public SocialUser getUserById(String id) {
        return repository.findById(id);
    }
    public List<SocialUser> getAllUsers() {
        return repository.findAll();
    }
    public boolean registerUser(SocialUser user) {
        return repository.register(user) > 0;
    }
    public ChatListResponse getUserChats(String userId) {
        List<FriendChat> friends = repository.findFriends(userId);
        List<GroupChat> groups = repository.findGroups(userId);
        ChatListResponse response = new ChatListResponse();
        response.setFriends(friends);
        response.setGroups(groups);
        return response;
    }
}
