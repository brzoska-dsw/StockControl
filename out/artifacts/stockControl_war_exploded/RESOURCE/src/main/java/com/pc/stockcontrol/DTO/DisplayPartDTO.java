package com.pc.stockcontrol.DTO;

import lombok.Data;
import java.util.List;

@Data
public class DisplayPartDTO {

    private String partNo;
    private String kanban;
    private List<DisplayUniteDTO> displayUniteDTOS;

}
