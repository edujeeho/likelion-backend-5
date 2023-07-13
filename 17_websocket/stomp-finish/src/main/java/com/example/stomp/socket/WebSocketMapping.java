package com.example.stomp.socket;

import com.example.stomp.ChatService;
import com.example.stomp.dto.ChatMessage;
import com.example.stomp.dto.ChatRoom;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.*;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;


@Slf4j
@Controller
@RequiredArgsConstructor
public class WebSocketMapping {
    // STOMP over WebSocket
    private final SimpMessagingTemplate simpMessagingTemplate;
    private final ChatService chatService;

    @MessageMapping("/chat")
    public void sendChat(
            @Payload ChatMessage chatMessage,
            // STOMP over WebSocket은 Header를 포함할 수 있다
            @Headers Map<String, Object> headers,
            @Header("nativeHeaders") Map<String, String> nativeHeaders
    ){
        log.info(chatMessage.toString());
        log.info(headers.toString());
        log.info(nativeHeaders.toString());
        String time = new SimpleDateFormat("HH:mm").format(new Date());
        chatMessage.setTime(time);
        chatService.saveChatMessage(chatMessage);
        simpMessagingTemplate.convertAndSend(
                String.format("/topic/%s", chatMessage.getRoomId()),
                chatMessage
        );
    }

    // 누군가가 구독할때 실행하는 메소드
    @SubscribeMapping("/{roomId}")
    public List<ChatMessage> sendGreet(
            @DestinationVariable("roomId") Long roomId
    ) {
        log.info("new subscription to {}", roomId);
        ChatRoom chatRoom = chatService.findRoomById(roomId);
        List<ChatMessage> last5Messages
                = chatService.getLast5Messages(roomId);
        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setRoomId(roomId);
        chatMessage.setSender("admin");
        if (last5Messages.size() > 0) {
            int count = Math.min(last5Messages.size(), 5);
            chatMessage.setMessage(String.format("hello! these are the last %d messages", count));
            chatMessage.setTime(last5Messages.get(0).getTime());
        } else {
            chatMessage.setMessage("hello! there aren't any messages here");
            chatMessage.setTime(new SimpleDateFormat("HH:mm").format(new Date()));
        }
        last5Messages.add(0, chatMessage);
        return last5Messages;
    }
}
