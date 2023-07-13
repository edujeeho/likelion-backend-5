package com.example.stomp.jpa;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChatMessageRepository extends JpaRepository<ChatMessageEntity, Long> {

    List<ChatMessageEntity> findTop5ByRoomIdOrderByIdDesc(Long id);
}
