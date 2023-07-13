package com.example.stomp.dto;

import com.example.stomp.jpa.ChatMessageEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChatMessage {
    private Long roomId;
    private String sender;
    private String message;
    private String time;


    public static ChatMessage fromEntity(ChatMessageEntity messageEntity) {
        return new ChatMessage(
                messageEntity.getRoomId(),
                messageEntity.getSender(),
                messageEntity.getMessage(),
                messageEntity.getTime()
        );
    }

    public ChatMessageEntity newEntity() {
        ChatMessageEntity messageEntity = new ChatMessageEntity();
        messageEntity.setRoomId(roomId);
        messageEntity.setSender(sender);
        messageEntity.setMessage(message);
        messageEntity.setTime(time);
        return messageEntity;
    }
}
