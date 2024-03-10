package org.example.sbv.controller;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.servlet.http.HttpServletRequest;
import org.example.sbv.entity.Materials;
import org.example.sbv.service.MaterialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.example.sbv.request.MaterialsRequest;

import java.util.List;

@RestController
@RequestMapping("/api/materials")
public class MaterialsController {
    private final MaterialsService materialsService;

    @Autowired
    public MaterialsController(MaterialsService materialsService){
        this.materialsService = materialsService;
    }

    @GetMapping("/all")
    @ResponseBody
    public List<Materials> getAllMaterials(HttpServletRequest request){

        return materialsService.getAllMaterials(request);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Materials getMaterialsById(HttpServletRequest request, @PathVariable Integer id){
        return materialsService.getMaterialsById(request, id);
    }
}

