package org.example.sbv.service;

import jakarta.servlet.http.HttpServletRequest;
import org.example.sbv.entity.MaterialCharacteristics;
import org.example.sbv.entity.PriceLists;
import org.example.sbv.repository.MaterialCharacteristicsRepository;
import org.example.sbv.repository.PriceListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PriceListsService {

    public final PriceListRepository priceListRepository;
    public final MaterialCharacteristicsService mService;
    private final UsersService usersService;

    @Autowired
    public PriceListsService(PriceListRepository priceListRepository, MaterialCharacteristicsRepository mRepository, MaterialCharacteristicsService mService, UsersService usersService){
        this.priceListRepository = priceListRepository;
        this.mService = mService;
        this.usersService = usersService;
    }

    public List<PriceLists> getAllPriceLists(HttpServletRequest request){
        if (usersService.getUserIdByJWT(request) != null) {
            List<PriceLists> priceLists = new ArrayList<>();
            for (MaterialCharacteristics materialCharacteristics: mService.getAllMaterialCharacteristics(request)) {
                priceLists.add(getPriceListsByMaterialId(request, materialCharacteristics.getId()));
            }
            return priceLists;
        }
        else return null;
    }
    public PriceLists getPriceListsByMaterialId(HttpServletRequest request, Integer id){
        if (usersService.getUserIdByJWT(request) != null) {
            System.out.println("price by material");
            List<PriceLists> prList = priceListRepository.findPriceListsByMaterialCharacteristicsId_IdOrderByDateDesc(id);
            if (!prList.isEmpty()) {
                return (prList.get(0));
            }
            return null;
        }
        else return null;
    }
}
