package com.pc.stockcontrol.Mapper;

import com.pc.stockcontrol.DTO.BomDTO;
import com.pc.stockcontrol.entity.Bom;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BomMapper {

    BomMapper INSTANCE = Mappers.getMapper(BomMapper.class);

    Bom toEntity(BomDTO bomDTO);
    BomDTO toDto(Bom bom);

}
