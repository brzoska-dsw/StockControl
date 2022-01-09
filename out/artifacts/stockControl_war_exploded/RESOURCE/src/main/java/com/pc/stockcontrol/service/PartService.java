package com.pc.stockcontrol.service;

import com.pc.stockcontrol.DTO.DisplayPartDTO;
import com.pc.stockcontrol.DTO.DisplayUniteDTO;
import com.pc.stockcontrol.entity.Bom;
import com.pc.stockcontrol.entity.Part;
import com.pc.stockcontrol.repository.PartRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PartService {

    private final PartRepo partRepo;

    public PartService(PartRepo partRepo) {
        this.partRepo = partRepo;
    }

    private static Object apply(Bom item) {
        return item;
    }

    public List<Part> findAll() {
        return partRepo.findAll();
    }

    public List<Part> findAllFetchBom() {
        return partRepo.findAllFetchBom();
    }

    public Part save(Part part) {
        return partRepo.save(part);
    }

    public Optional<Part> findById(Long id) {
        return partRepo.findById(id);
    }

    public void deleteById(long id) {
        partRepo.deleteById(id);
    }

    public List<DisplayPartDTO> findAllPartsUnitsData() {

        return partRepo.findAll()
                .stream()
                .map(item -> entityToDto(item))
                .collect(Collectors.toList());
    }

    public DisplayPartDTO entityToDto(Part part) {
        DisplayPartDTO displayPartDTO = new DisplayPartDTO();

        displayPartDTO.setPartNo(part.getPartNo());
        displayPartDTO.setKanban(part.getKanban());

        displayPartDTO.setDisplayUniteDTOS( part.getBom().stream().map(item ->
                        {
                            DisplayUniteDTO displayUniteDTO = new DisplayUniteDTO();
                            displayUniteDTO.setUnitNo(item.getUnite().getUniteNo());
                            displayUniteDTO.setQty(item.getQty());
                            return displayUniteDTO;
                        }
                )
                .collect(Collectors.toList()));

        return displayPartDTO;
    }

}

















