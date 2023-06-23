package com.example.jpa.entities;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;

@Data
// 여러 Entity가 공유하는 속성을 모으기 위한
// 상위 Entity임을 나타내는 annotation
@MappedSuperclass
// Entity 의 변화를 지켜볼 클래스 정의
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {
    @CreatedDate
    @Column(updatable = false)
    private Instant createdAt;

    @LastModifiedDate
    @Column(updatable = true)
    private Instant updatedAt;
}
