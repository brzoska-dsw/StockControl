package com.pc.stockcontrol.Mapper;

import com.pc.stockcontrol.DTO.UniteDTO;
import com.pc.stockcontrol.entity.Unite;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UniteMapper {

    UniteMapper INSTANCE = Mappers.getMapper(UniteMapper.class);

    Unite toEntity(UniteDTO uniteDTO);

    UniteDTO toDTO(Unite unite);



}

