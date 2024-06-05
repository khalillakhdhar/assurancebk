package com.example.mapper;

import org.modelmapper.ModelMapper;
import com.example.dto.AdresseDTO;
import com.example.entity.Adresse;

public class AdresseMapper {
    private static final ModelMapper modelMapper = new ModelMapper();

    public static AdresseDTO convertToDTO(Adresse adresse) {
        return modelMapper.map(adresse, AdresseDTO.class);
    }

    public static Adresse convertToEntity(AdresseDTO adresseDTO) {
        return modelMapper.map(adresseDTO, Adresse.class);
    }
}
