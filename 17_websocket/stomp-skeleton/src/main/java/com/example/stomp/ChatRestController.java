package com.example.stomp;

import com.example.stomp.dto.ChatRoom;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("chat")
@RequiredArgsConstructor
public class ChatRestController {
    private final ChatService chatService;

    @GetMapping("rooms")
    public ResponseEntity<List<ChatRoom>> getChatRooms(){
        return ResponseEntity.ok(chatService.getChatRooms());
    }

    @PostMapping("rooms")
    public ResponseEntity<ChatRoom> createRoom(@RequestBody ChatRoom chatRoom){
        return ResponseEntity.ok(chatService.createChatRoom(chatRoom));
    }

    @GetMapping("rooms/{id}/name")
    public ResponseEntity<ChatRoom> getRoomName(@PathVariable("id") Long roomId) {
        return ResponseEntity.ok(chatService.findRoomById(roomId));
    }
}
