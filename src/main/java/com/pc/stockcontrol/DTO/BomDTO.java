package com.pc.stockcontrol.DTO;

import lombok.Data;
import com.pc.stockcontrol.entity.Part;

@Data
public class BomDTO {

    private Long id;
    private Long qty;
    private PartDTO part;

}
