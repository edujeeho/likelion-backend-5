package com.example.stomp;

import com.example.stomp.dto.ChatMessage;
import com.example.stomp.dto.ChatRoom;
import com.example.stomp.jpa.ChatMessageEntity;
import com.example.stomp.jpa.ChatMessageRepository;
import com.example.stomp.jpa.ChatRoomEntity;
import com.example.stomp.jpa.ChatRoomRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ChatService {
    private final ChatRoomRepository chatRoomRepository;
    private final ChatMessageRepository chatMessageRepository;

    public ChatService(
            ChatRoomRepository chatRoomRepository,
            ChatMessageRepository chatMessageRepository
    ) {
        this.chatRoomRepository = chatRoomRepository;
        this.chatMessageRepository = chatMessageRepository;
        ChatRoomEntity room = new ChatRoomEntity();
        room.setRoomName("general");
        this.chatRoomRepository.save(room);
    }

    public List<ChatRoom> getChatRooms() {
        List<ChatRoom> chatRoomList = new ArrayList<>();
        for (ChatRoomEntity chatRoomEntity: chatRoomRepository.findAll())
            chatRoomList.add(ChatRoom.fromEntity(chatRoomEntity));
        return chatRoomList;
    }

    public ChatRoom createChatRoom(ChatRoom chatRoom) {
        ChatRoomEntity chatRoomEntity = new ChatRoomEntity();
        chatRoomEntity.setRoomName(chatRoom.getRoomName());

        return ChatRoom.fromEntity(chatRoomRepository.save(chatRoomEntity));
    }

    public ChatRoom findRoomById(Long id) {
        Optional<ChatRoomEntity> optionalChatRoom
                = chatRoomRepository.findById(id);
        if (optionalChatRoom.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return ChatRoom.fromEntity(optionalChatRoom.get());
    }


    public void saveChatMessage(ChatMessage chatMessage) {
        chatMessageRepository.save(chatMessage.newEntity());
    }

    public List<ChatMessage> getLast5Messages(Long roomId) {
        List<ChatMessage> chatMessages = new ArrayList<>();
        List<ChatMessageEntity> chatMessageEntities = chatMessageRepository.findTop5ByRoomIdOrderByIdDesc(roomId);
        Collections.reverse(chatMessageEntities);
        for (ChatMessageEntity messageEntity: chatMessageEntities) {
            chatMessages.add(ChatMessage.fromEntity(messageEntity));
        }
        return chatMessages;
    }
}
