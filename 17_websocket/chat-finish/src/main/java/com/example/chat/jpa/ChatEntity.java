package com.example.chat.jpa;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "chat_log")
public class ChatEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sender;
    private String content;
}
