package com.example.contents.dto;

import com.example.contents.entity.UserEntity;
import lombok.Data;

@Data
public class UserDto {
    private Long id;
    private String username;
    private String email;
    private String phone;
    private String bio;
    private String avatar;

    public static UserDto fromEntity(UserEntity entity) {
        UserDto dto = new UserDto();
        dto.setId(entity.getId());
        dto.setUsername(entity.getUsername());
        dto.setEmail(entity.getEmail());
        dto.setPhone(entity.getPhone());
        dto.setBio(entity.getBio());
        dto.setAvatar(entity.getAvatar());
        return dto;
    }
}
