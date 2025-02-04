package com.example.mapper;

import org.modelmapper.ModelMapper;
import com.example.dto.UserDTO;
import com.example.entity.User;

public class UserMapper {
    private static final ModelMapper modelMapper = new ModelMapper();

    public static UserDTO convertToDTO(User user) {
        return modelMapper.map(user, UserDTO.class);
    }

    public static User convertToEntity(UserDTO userDTO) {
        return modelMapper.map(userDTO, User.class);
    }
}
