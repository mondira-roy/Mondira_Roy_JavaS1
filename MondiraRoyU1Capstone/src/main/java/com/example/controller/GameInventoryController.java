package com.example.controller;

import com.example.service.InventoryService;
import com.example.viewModel.GameViewModel;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/game")
public class GameInventoryController {

    @Autowired
    InventoryService inventoryService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public GameViewModel createGame(@RequestBody @Valid GameViewModel gameViewModel) {
        return inventoryService.saveGame(gameViewModel);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GameViewModel getGame(@PathVariable("id") int gameId) throws NotFoundException {
        GameViewModel game = inventoryService.findGame(gameId);
        if (game == null)
            throw new NotFoundException("Item could not be retrieved for id " + gameId);
        return game;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteGame(@PathVariable("id") int gameId) {
        inventoryService.removeGame(gameId);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateGame(@PathVariable("id") int gameId, @RequestBody @Valid GameViewModel gameviewModel) {
        if (gameviewModel.getGameId() == 0)
            gameviewModel.setGameId(gameId);
        if (gameId != gameviewModel.getGameId()) {
            throw new IllegalArgumentException("Item ID on path must match the ID in the Item object");
        }
        inventoryService.updateGame(gameviewModel);
    }
}
