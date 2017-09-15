package com.lhamacorp.cashtrackerstocks.entity.user;

import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    public User convert(UserDTO dto) {
        if (dto == null) return null;
        User bo = new User();

        bo.setId(dto.getId());
        bo.setEmail(dto.getEmail());
        bo.setUsername(dto.getUsername());

        return bo;
    }

    public UserDTO convert(User bo) {
        if (bo == null) return null;

        UserDTO dto = new UserDTO();

        dto.setId(bo.getId());
        dto.setEmail(bo.getEmail());
        dto.setUsername(bo.getUsername());

        return dto;
    }

}
