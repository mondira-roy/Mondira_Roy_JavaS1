package com.example.controller;

import com.example.dao.TShirtDao;
import com.example.service.InventoryService;
import com.example.viewModel.TShirtViewModel;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/tshirt")
public class TShirtInventoryController {
    @Autowired
    InventoryService inventoryService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TShirtViewModel createTShirt(@RequestBody @Valid TShirtViewModel tshirt) {
        return inventoryService.saveTShirt(tshirt);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TShirtViewModel getTShirt(@PathVariable("id") int tShirtId) throws NotFoundException {
        TShirtViewModel tshirt= inventoryService.findTShirt(tShirtId);
        if (tshirt == null)
            throw new NotFoundException("Item could not be retrieved for id " + tShirtId);
        return tshirt;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTShirt(@PathVariable("id") int tShirtId, TShirtDao tShirtDao) {
        inventoryService.removeTShirt(tShirtId, tShirtDao);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateTShirt(@PathVariable("id") int tshirtId, @RequestBody @Valid TShirtViewModel tShirtViewModel) {
        if (tShirtViewModel.gettShirtId() == 0)
            tShirtViewModel.settShirtId(tshirtId);
        if (tshirtId != tShirtViewModel.gettShirtId()) {
            throw new IllegalArgumentException("Item ID on path must match the ID in the Item object");
        }
        inventoryService.updateTShirt(tShirtViewModel);
    }


}
