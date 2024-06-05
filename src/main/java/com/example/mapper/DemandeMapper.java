package com.example.mapper;

import org.modelmapper.ModelMapper;
import com.example.dto.DemandeDTO;
import com.example.entity.Demande;

public class DemandeMapper {
    private static final ModelMapper modelMapper = new ModelMapper();

    public static DemandeDTO convertToDTO(Demande demande) {
        return modelMapper.map(demande, DemandeDTO.class);
    }

    public static Demande convertToEntity(DemandeDTO demandeDTO) {
        return modelMapper.map(demandeDTO, Demande.class);
    }
}
