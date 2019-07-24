package com.example.controller;


import com.example.model.SalesTaxRate;
import com.example.service.InventoryService;
import com.example.viewModel.SalesTaxRateViewModel;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;

@RestController
@RequestMapping("/tax")
public class SalesTaxRateController {
    @Autowired
    InventoryService inventoryService;

    /*@PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SalesTaxRateViewModel createRate(@RequestBody @Valid SalesTaxRateViewModel rate) {
        return inventoryService.saveRate(rate);
    }*/

    /*@GetMapping("/{state}")
    @ResponseStatus(HttpStatus.OK)
    public SalesTaxRateViewModel getRate(@PathVariable("state") String state) throws NotFoundException {
        SalesTaxRateViewModel rate = inventoryService.findRate(state);
        if (rate == null)
            throw new NotFoundException("Item could not be retrieved for id " + state);
        return rate;
    }*/
    /*@GetMapping("/{rate}")
    @ResponseStatus(HttpStatus.OK)
    public SalesTaxRateViewModel getState(@PathVariable("rate") BigDecimal rate) throws NotFoundException {
        SalesTaxRateViewModel state = inventoryService.findState(rate);
        if (state == null)
            throw new NotFoundException("Item could not be retrieved for id " + rate);
        return state;
    }

    @DeleteMapping("/{state}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRate(@PathVariable("state") String state) {
        inventoryService.removeRate(state);
    }

    @PutMapping("/{state}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateRate(@PathVariable("state") String state, @RequestBody @Valid SalesTaxRateViewModel salesTaxRateViewModel) {
        if (salesTaxRateViewModel.getState().compareTo(""))
            salesTaxRateViewModel.setState(state);
        if (state != salesTaxRateViewModel.getState()) {
            throw new IllegalArgumentException("Item ID on path must match the ID in the Item object");
        }
        inventoryService.updateRate(SalesTaxRateViewModel);
    }*/
}
