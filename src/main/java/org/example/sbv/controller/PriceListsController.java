package org.example.sbv.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.example.sbv.entity.Materials;
import org.example.sbv.entity.PriceLists;
import org.example.sbv.service.PriceListsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/priceLists")
public class PriceListsController {
    private final PriceListsService priceListsService;


    @Autowired
    public PriceListsController(PriceListsService priceListsService){
        this.priceListsService = priceListsService;
    }

    @GetMapping("/all")
    @ResponseBody
    public List<PriceLists> getAllPriceLists(HttpServletRequest request){
        return priceListsService.getAllPriceLists(request);
    }

}
