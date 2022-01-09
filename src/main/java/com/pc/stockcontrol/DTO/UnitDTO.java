package com.pc.stockcontrol.DTO;

import lombok.Data;
import java.util.List;

@Data
public class UnitDTO {

    private String uniteNo;
    private String shortNo;
    private List<BomDTO> bomList;

}
