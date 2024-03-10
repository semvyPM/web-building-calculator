package org.example.sbv.service;

import jakarta.servlet.http.HttpServletRequest;
import org.example.sbv.entity.MaterialCharacteristics;
import org.example.sbv.entity.Materials;
import org.example.sbv.repository.MaterialCharacteristicsRepository;
import org.example.sbv.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialCharacteristicsService {
    public final MaterialCharacteristicsRepository materialCharacteristicsRepository;
    private final UsersService usersService;

    @Autowired
    public MaterialCharacteristicsService(MaterialCharacteristicsRepository materialCharacteristicsRepository, UsersService usersService){
        this.materialCharacteristicsRepository = materialCharacteristicsRepository;
        this.usersService = usersService;
    }
    public List<MaterialCharacteristics> getAllMaterialCharacteristics(HttpServletRequest request){
        if (usersService.getUserIdByJWT(request) != null){
            return materialCharacteristicsRepository.findAll();
        }
        else return null;
    }

    public MaterialCharacteristics getMaterialCharacteristicsById(HttpServletRequest request, Integer id){
        if (usersService.getUserIdByJWT(request) != null){
            return materialCharacteristicsRepository.findMaterialCharacteristicsById(id);
        }
        else return null;
    }
}
