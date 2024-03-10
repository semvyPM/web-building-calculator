package org.example.sbv.service;

import jakarta.servlet.http.HttpServletRequest;
import org.example.sbv.entity.PriceLists;
import org.example.sbv.repository.PriceListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceListsService {

    public final PriceListRepository priceListRepository;
    private final UsersService usersService;

    @Autowired
    public PriceListsService(PriceListRepository priceListRepository, UsersService usersService){
        this.priceListRepository = priceListRepository;
        this.usersService = usersService;
    }

    public List<PriceLists> getAllPriceLists(HttpServletRequest request){
        if (usersService.getUserIdByJWT(request) != null) {
            return priceListRepository.findAll();
        }
        else return null;
    }
    public PriceLists getPriceListsById(HttpServletRequest request, Integer id){
        if (usersService.getUserIdByJWT(request) != null) {
            return priceListRepository.findPriceListsById(id);
        }
        else return null;
    }
}
