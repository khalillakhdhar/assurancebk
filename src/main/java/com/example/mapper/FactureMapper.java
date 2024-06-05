package com.example.mapper;

import org.modelmapper.ModelMapper;
import com.example.dto.FactureDTO;
import com.example.entity.Facture;

public class FactureMapper {
    private static final ModelMapper modelMapper = new ModelMapper();

    public static FactureDTO convertToDTO(Facture facture) {
        return modelMapper.map(facture, FactureDTO.class);
    }

    public static Facture convertToEntity(FactureDTO factureDTO) {
        return modelMapper.map(factureDTO, Facture.class);
    }
}
