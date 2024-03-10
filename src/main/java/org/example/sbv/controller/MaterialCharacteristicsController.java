package org.example.sbv.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.example.sbv.entity.MaterialCharacteristics;
import org.example.sbv.entity.Materials;
import org.example.sbv.service.MaterialCharacteristicsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/materialsCharacteristics")
public class MaterialCharacteristicsController {
    private final MaterialCharacteristicsService materialCharacteristicsService;

    @Autowired
    public MaterialCharacteristicsController(MaterialCharacteristicsService materialCharacteristicsService){
        this.materialCharacteristicsService = materialCharacteristicsService;
    }

    @GetMapping("/all")
    @ResponseBody
    public List<MaterialCharacteristics> getAllMaterialCharacteristics(HttpServletRequest request){
        return materialCharacteristicsService.getAllMaterialCharacteristics(request);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public MaterialCharacteristics getMaterialCharacteristicsById(HttpServletRequest request, @PathVariable Integer id){
        return materialCharacteristicsService.getMaterialCharacteristicsById(request, id);
    }
}
