package org.example.sbv.service;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.servlet.http.HttpServletRequest;
import org.example.sbv.entity.Materials;
import org.example.sbv.entity.Users;
import org.example.sbv.repository.MaterialsRepository;
import org.example.sbv.security.domain.model.User;
import org.example.sbv.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.example.sbv.request.MaterialsRequest;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class MaterialsService {
    public final MaterialsRepository materialsRepository;
    private final UsersService usersService;

    @Autowired
    public MaterialsService(MaterialsRepository materialsRepository, UsersService usersService) {
        this.usersService = usersService;
        this.materialsRepository = materialsRepository;
    }
    public List<Materials> getAllMaterials(HttpServletRequest request){
        if (usersService.getUserIdByJWT(request) != null) {
            return materialsRepository.findAll();
        }
        else return null;
    }


    public Materials getMaterialsById(HttpServletRequest request, Integer id){
        if (usersService.getUserIdByJWT(request) != null){
            return materialsRepository.findMaterialsById(id);
        }
        else return null;
    }

}
