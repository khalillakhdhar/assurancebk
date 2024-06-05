package com.example.mapper;

import org.modelmapper.ModelMapper;
import com.example.dto.ConventionDTO;
import com.example.entity.Convention;

public class ConventionMapper {
    private static final ModelMapper modelMapper = new ModelMapper();

    public static ConventionDTO convertToDTO(Convention convention) {
        return modelMapper.map(convention, ConventionDTO.class);
    }

    public static Convention convertToEntity(ConventionDTO conventionDTO) {
        return modelMapper.map(conventionDTO, Convention.class);
    }
}
