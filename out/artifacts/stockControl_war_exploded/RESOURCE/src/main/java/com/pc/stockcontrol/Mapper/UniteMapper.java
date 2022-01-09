package com.pc.stockcontrol.Mapper;

import com.pc.stockcontrol.DTO.UnitDTO;
import com.pc.stockcontrol.entity.Unite;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UniteMapper {

    UniteMapper INSTANCE = Mappers.getMapper(UniteMapper.class);

    Unite toEntity(UnitDTO unitDTO);
    UnitDTO toDTO(Unite unite);

}

